package Controller.AI_Controller.FrontalLobe;

import Controller.AI_Controller.Decision.Decision;
import Controller.AI_Controller.VisualCortex.VisualInformation.VisualInformation;
import Model.Entity;
import Utilities.RelationshipList;

/**
 * Created by aseber on 4/6/16.
 */
public interface FrontalLobeMemoryInterface {

    // Getter for visual information
    VisualInformation getVisualInformation();

    // Relationship related methods
    RelationshipList<Entity> getRelationships();
    void setRelationships(RelationshipList<Entity> entityRelationships);

    // Decision related methods
    boolean isCurrentDecisionValid();
    void setCurrentDecision(Decision currentDecision);

}
