package Controller.AI_Controller;

import Controller.AI_Controller.FrontalLobe.FrontalLobe;
import Controller.AI_Controller.Memory.Memory;
import Controller.AI_Controller.MotorCortex.MotorCortex;
import Controller.AI_Controller.VisualCortex.VisualCortex;
import Model.Entity.Character.NPC.NPC;
import Utilities.Tickable;

/**
 * Created by aseber on 4/6/16.
 */
public class Brain implements Tickable {

    private final VisualCortex visualCortex;
    private final FrontalLobe frontalLobe;
    private final MotorCortex motorCortex;
    private final Memory memory;

    public Brain(NPC npc) { //What if it took in an NPC which has a personality?

        memory = new Memory(npc, npc.getPersonality());
        visualCortex = new VisualCortex(memory);
        frontalLobe = new FrontalLobe(memory);
        motorCortex = new MotorCortex(memory);

    }

    public void tick() {

        visualCortex.tick();
        frontalLobe.tick();
        motorCortex.tick();
        memory.tick();

    }

}
