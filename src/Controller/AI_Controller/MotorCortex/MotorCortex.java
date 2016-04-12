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

            NPC npc = memory.getNPC();

            UniformPicker<Orientation> orientations = new UniformPicker<>();
            orientations.add(Orientation.NORTH, 1.0);
            orientations.add(Orientation.NORTHEAST, 1.0);
            orientations.add(Orientation.NORTHWEST, 1.0);
            orientations.add(Orientation.SOUTH, 1.0);
            orientations.add(Orientation.SOUTHEAST, 1.0);
            orientations.add(Orientation.SOUTHWEST, 1.0);

            npc.getController().move(npc, orientations.pick());

            randomMovement = (int) Math.round(Math.random() * 20);

        }

    }

}
