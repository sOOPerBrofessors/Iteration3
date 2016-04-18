package Controller.AI_Controller.VisualCortex.VisualInformation;

import Controller.AI_Controller.FrontalLobe.FrontalLobeMemoryInterface;
import Model.Entity.Character.Character;
import Model.Entity.Entity;
import Utilities.AIStuff.Relationship;
import Utilities.AIStuff.RelationshipList;
import Utilities.ErrorLevel;
import Utilities.MathUtilities;
import Utilities.MessageHandler;
import Visitors.VisualInformationVisitor;

import java.util.Random;

/**
 * Created by aseber on 4/7/16.
 */
public class EntityRelationshipVisitor implements VisualInformationVisitor {

    private RelationshipList<Entity> relationshipList;
    private FrontalLobeMemoryInterface memory;

    public EntityRelationshipVisitor(RelationshipList<Entity> relationshipList, FrontalLobeMemoryInterface memory) {

        this.relationshipList = relationshipList;
        this.memory = memory;

    }

    public void visit(VisualInformation target) {

        Random rng = new Random(System.currentTimeMillis());

        for (Character entity : target.getEntityInformation().keySet()) {

            if (!relationshipList.relationshipExists(entity) && entity != memory.getNPC()) {

                // friendly Faction should add some good weight
                // especially those part of the same faction
                // enemy faction should add some bad weight
                double aggressiveFactor = -memory.getPersonality().getAggressiveness();
                double scatter_brainedNess = memory.getPersonality().getScatter_brainedness();
                double scatterBrainFactor = scatter_brainedNess * rng.nextGaussian() - (scatter_brainedNess / 2);
                double factionFactor = memory.getNPC().getFaction().getRelationship(entity.getFaction());

                double relationalValue = aggressiveFactor + scatterBrainFactor + factionFactor;
                relationalValue = MathUtilities.putInRange(-1.0, relationalValue, 1.0);

                Relationship relationship = new Relationship(relationalValue);
                //MessageHandler.println("RELATIONAL VALUE: " + memory.getNPC() + " -> " + entity + ": " +  relationalValue, ErrorLevel.NOTICE);
                relationshipList.addRelationship(entity, relationship);

            }

        }

    }

    public RelationshipList<Entity> getRelationshipList() {

        return relationshipList;

    }

}
