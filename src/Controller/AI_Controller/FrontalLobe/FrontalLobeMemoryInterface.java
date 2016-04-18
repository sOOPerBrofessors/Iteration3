package Controller.AI_Controller.FrontalLobe;

import Controller.AI_Controller.Decision.Decision;
import Controller.AI_Controller.Personality.Personality;
import Controller.AI_Controller.VisualCortex.VisualInformation.VisualInformation;
import Model.Entity.Character.NPC.NPC;
import Model.Entity.Entity;
import Utilities.AIStuff.RelationshipList;

/**
 * Created by aseber on 4/6/16.
 */
public interface FrontalLobeMemoryInterface {

    NPC getNPC();

    // Getter for visual information
    VisualInformation getVisualInformation();

    // Relationship related methods
    RelationshipList<Entity> getRelationships();
    void setRelationships(RelationshipList<Entity> entityRelationships);

    // Decision related methods
    boolean isCurrentDecisionValid();
    void setCurrentDecision(Decision currentDecision);

    // Personality related methods
    Personality getPersonality();

}
