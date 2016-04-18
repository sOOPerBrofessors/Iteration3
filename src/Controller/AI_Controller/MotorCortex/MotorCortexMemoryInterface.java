package Controller.AI_Controller.MotorCortex;

import Controller.AI_Controller.Decision.Decision;
import Controller.AI_Controller.Personality.Personality;
import Model.Entity.Character.NPC.NPC;

/**
 * Created by aseber on 4/6/16.
 */
public interface MotorCortexMemoryInterface {

    // The decision getter
    NPC getNPC();
    void moveNPC();
    Decision getCurrentDecision();
    Personality getPersonality();

}
