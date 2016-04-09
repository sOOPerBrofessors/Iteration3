package Controller.AI_Controller;

import Controller.AI_Controller.FrontalLobe.FrontalLobe;
import Controller.AI_Controller.Memory.Memory;
import Controller.AI_Controller.MotorCortex.MotorCortex;
import Controller.AI_Controller.Personality.Personality;
import Controller.AI_Controller.VisualCortex.VisualCortex;
import Model.Entity.Entity;
import Utilities.Tickable;

/**
 * Created by aseber on 4/6/16.
 */
public class Brain implements Tickable {

    private VisualCortex visualCortex;
    private FrontalLobe frontalLobe;
    private MotorCortex motorCortex;
    private Memory memory;

    public Brain(Entity entity) { //What if it took in an NPC which has a personality?

        //memory = new Memory(entity, entity.getPersonality());
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
