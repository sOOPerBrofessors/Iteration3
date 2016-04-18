package Controller.AI_Controller.FrontalLobe;

import Controller.AI_Controller.Decision.Decision;
import Controller.AI_Controller.Interest.EntityInterests.EntityInterest;
import Controller.AI_Controller.Interest.Interest;
import Controller.AI_Controller.Interest.PointInterests.ExploreInterest;
import Controller.AI_Controller.Memory.Memory;
import Controller.AI_Controller.Personality.Personality;
import Controller.AI_Controller.VisualCortex.VisualInformation.EntityRelationshipVisitor;
import Controller.AI_Controller.VisualCortex.VisualInformation.VisualInformation;
import Model.Entity.Entity;
import Utilities.*;
import Utilities.AIStuff.RelationshipList;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by aseber on 4/6/16.
 */
public class FrontalLobe implements Tickable {

    private FrontalLobeMemoryInterface memory;

    public FrontalLobe(FrontalLobeMemoryInterface memory) {

        this.memory = memory;

    }

    public void tick() {

        checkForNewRelationships();

        if (shouldChangeDecisions()) {

            selectNewDecision();

        }

    }

    private void checkForNewRelationships() {

        VisualInformation visualInformation = memory.getVisualInformation();

        RelationshipList<Entity> relationshipList = memory.getRelationships();
        EntityRelationshipVisitor visitor = new EntityRelationshipVisitor(relationshipList);
        visualInformation.accept(visitor);

        relationshipList = visitor.getRelationshipList();
        memory.setRelationships(relationshipList);

    }

    private boolean shouldChangeDecisions() {

        if (!memory.isCurrentDecisionValid()) {

            MessageHandler.println("FrontalLobe: current decision not valid", ErrorLevel.DEV, PersonFilter.AUSTIN);
            return true;

        }

        if (isScatterBrainTrue()) {

            MessageHandler.println("FrontalLobe: scatter brain returned true", ErrorLevel.DEV, PersonFilter.AUSTIN);
            return true;

        }

        return false;

    }

    private boolean isScatterBrainTrue() {

        Personality personality = memory.getPersonality();
        return personality.getScatter_brainedness() >= Math.random();

    }

    private void selectNewDecision() {

        UniformPicker<Decision> decisionPicker = new UniformPicker<>();
        Personality personality = memory.getPersonality();
        HashMap<Interest, Double> entityInterests = personality.getInterestsFromType(Interest.InterestType.ENTITY);
        HashMap<Interest, Double> itemInterests = personality.getInterestsFromType(Interest.InterestType.ITEM);
        HashMap<Interest, Double> pointInterests = personality.getInterestsFromType(Interest.InterestType.POINT);

        for (Map.Entry<Interest, Double> entry : entityInterests.entrySet()) {

            for (Map.Entry<Point, Entity> entry2 : memory.getVisualInformation().getEntityInformation().entrySet()) {

                EntityInterest interest = (EntityInterest) entry.getKey();
                interest.setTarget(entry2.getValue());
                Decision decision = new Decision(interest, entry.getValue(), memory.getVisualInformation(), (Memory) memory);
                decisionPicker.add(decision, decision.getValue());

            }

        }

        for (Map.Entry<Interest, Double> entry : itemInterests.entrySet()) {



        }

        for (Map.Entry<Interest, Double> entry : pointInterests.entrySet()) {

            Decision decision = new Decision(entry.getKey(), entry.getValue(), memory.getVisualInformation(), (Memory) memory);
            decisionPicker.add(decision, decision.getValue());

        }

        memory.setCurrentDecision(decisionPicker.pick());

    }

}
