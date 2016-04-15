package Controller.AI_Controller.MotorCortex;

import Model.Entity.Character.NPC.NPC;
import Model.Map.Location;
import Model.Map.Orientation;
import Utilities.MathUtilities;
import Utilities.Tickable;
import Utilities.UniformPicker;

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

            randomMovement = (int) Math.round(Math.random() * 20);
            memory.getNPC().getController().move(memory.getNPC(), memory.getOrientationToMove());

        }

    }

}
