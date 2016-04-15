package Controller.AI_Controller.MotorCortex;

import Controller.AI_Controller.Decision.Decision;
import Model.Entity.Character.NPC.NPC;
import Model.Map.Orientation;

/**
 * Created by aseber on 4/6/16.
 */
public interface MotorCortexMemoryInterface {

    // The decision getter
    NPC getNPC();
    Orientation getOrientationToMove();
    Decision getCurrentDecision();

}
