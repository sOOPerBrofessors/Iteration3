package Controller.AI_Controller.Memory;

import Controller.AI_Controller.Decision.Decision;
import Controller.AI_Controller.FrontalLobe.FrontalLobeMemoryInterface;
import Controller.AI_Controller.MotorCortex.MotorCortexMemoryInterface;
import Controller.AI_Controller.Personality.Personality;
import Controller.AI_Controller.VisualCortex.VisualCortexMemoryInterface;
import Controller.AI_Controller.VisualCortex.VisualInformation.VisualInformation;
import Model.Entity.Entity;
import Utilities.AIStuff.RelationshipList;
import Utilities.Tickable;

/**
 * Created by aseber on 4/6/16.
 */

// tiredness of interests, affects weight of interest. If all you do is try and trade, eventually you'll go and do something else until that value lessens

public class Memory implements Tickable, VisualCortexMemoryInterface, FrontalLobeMemoryInterface, MotorCortexMemoryInterface {

    private Entity entity;
    private Personality personality;

    private VisualInformation visualInformation;
    private RelationshipList<Entity> entityRelationships = new RelationshipList<>();
    private Decision currentDecision;

    public Memory(Entity entity, Personality personality) {

        this.entity = entity;
        this.personality = personality;

    }

    // Methods for VisualCortexMemoryInterface //
    public void setVisualInformation(VisualInformation visualInformation) {

        this.visualInformation = visualInformation;

    }

    // Methods for FrontalLobeMemoryInterface //
    public VisualInformation getVisualInformation() {

        return visualInformation;

    }

    public boolean isCurrentDecisionValid() {

        // If the current decision doesn't exist, return false so we choose a new one
        if (currentDecision == null) {

            return false;

        }

        return currentDecision.isValid(visualInformation);

    }

    public RelationshipList<Entity> getRelationships() {

        return entityRelationships;

    }

    public void setRelationships(RelationshipList<Entity> entityRelationships) {

        this.entityRelationships = entityRelationships;

    }

    public void setCurrentDecision(Decision currentDecision) {

        this.currentDecision = currentDecision;

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
