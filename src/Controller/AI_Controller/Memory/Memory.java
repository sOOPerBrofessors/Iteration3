package Controller.AI_Controller.Memory;

import Controller.AI_Controller.Decision.Decision;
import Controller.AI_Controller.FrontalLobe.FrontalLobeMemoryInterface;
import Controller.AI_Controller.MotorCortex.MotorCortexMemoryInterface;
import Controller.AI_Controller.VisualCortex.VisualCortexMemoryInterface;
import Controller.AI_Controller.VisualCortex.VisualInformation.VisualInformation;
import Model.Entity;
import Utilities.Relationship;
import Utilities.RelationshipList;
import Utilities.Tickable;

/**
 * Created by aseber on 4/6/16.
 */
public class Memory
        implements
            Tickable,
            VisualCortexMemoryInterface,
            FrontalLobeMemoryInterface,
            MotorCortexMemoryInterface {

    VisualInformation visualInformation;
    RelationshipList<Entity> entityRelationships = new RelationshipList<>();
    Decision currentDecision;

    // Methods for VisualCortexMemoryInterface //
    public void setVisualInformation(VisualInformation visualInformation) {

        this.visualInformation = visualInformation;

    }

    // Methods for FrontalLobeMemoryInterface //
    public VisualInformation getVisualInformation() {

        return visualInformation;

    }

    public boolean isCurrentDecisionValid() {

        return currentDecision.isValid(visualInformation);

    }

    public RelationshipList<Entity> getRelationships() {

        return entityRelationships;

    }

    // Methods for MotorCortexMemoryInterface //
    public Decision getCurrentDecision() {

        return currentDecision;

    }

    // Methods for Tickable //
    public void tick() {

        visualInformation.purge();

    }

}
