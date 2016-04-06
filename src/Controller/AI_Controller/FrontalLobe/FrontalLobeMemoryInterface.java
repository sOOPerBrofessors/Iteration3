package Controller.AI_Controller.FrontalLobe;

import Controller.AI_Controller.VisualCortex.VisualInformation.VisualInformation;
import Model.Entity;
import Utilities.RelationshipList;

/**
 * Created by aseber on 4/6/16.
 */
public interface FrontalLobeMemoryInterface {

    VisualInformation getVisualInformation();

    boolean isCurrentDecisionValid();

    RelationshipList<Entity> getRelationships();

}
