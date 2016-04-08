package Controller.AI_Controller.FrontalLobe;

import Controller.AI_Controller.VisualCortex.VisualInformation.EntityRelationshipVisitor;
import Controller.AI_Controller.VisualCortex.VisualInformation.VisualInformation;
import Model.Entity.Entity;
import Utilities.RelationshipList;
import Utilities.Tickable;

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
        boolean shouldChangeDecision = shouldChangeDecisions();

        if (shouldChangeDecision) {

            selectNewDecision();

        } else {

            return;

        }

        // Need faction loader, and personality loader

        // Check if any new entities in map, then add them as relationships
        // Check if we should reselect our decision
        // IF need new decision, select one

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

        if (memory.isCurrentDecisionValid()) {

            // TODO: change to scatter-brainedness
            if (true) {

                return false;

            }

        }

        return true;

    }

    private void selectNewDecision() {

        // Use uniform picker on all entities, items, and others (like exploring)

    }

}
