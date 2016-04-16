package Controller.AI_Controller.MotorCortex;

import Utilities.Tickable;

/**
 * Created by aseber on 4/6/16.
 */
public class MotorCortex implements Tickable {

    int randomMovement;

    private MotorCortexMemoryInterface memory;

    public MotorCortex(MotorCortexMemoryInterface memory) {

        this.memory = memory;

    }

    public void tick() {

        if (--randomMovement < 0) {

            randomMovement = 20;
            memory.moveNPC();

        }

    }

}
