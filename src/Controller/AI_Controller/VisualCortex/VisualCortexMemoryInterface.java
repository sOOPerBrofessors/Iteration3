package Controller.AI_Controller.VisualCortex;

import Controller.AI_Controller.VisualCortex.VisualInformation.VisualInformation;
import Model.Entity.Character.NPC.NPC;

/**
 * Created by aseber on 4/6/16.
 */
public interface VisualCortexMemoryInterface {

    // The setter for visualInformation
    NPC getNPC();
    void setVisualInformation(VisualInformation visualInformation);

}
