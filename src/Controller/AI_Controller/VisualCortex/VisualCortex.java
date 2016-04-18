package Controller.AI_Controller.VisualCortex;

import Controller.AI_Controller.VisualCortex.VisualInformation.VisualInformation;
import Utilities.Tickable;

/**
 * Created by aseber on 4/6/16.
 */
public class VisualCortex implements Tickable {

    private VisualCortexMemoryInterface memory;

    public VisualCortex(VisualCortexMemoryInterface memory) {

        this.memory = memory;

    }

    public void tick() {

        VisualInformation newVisualInformation = new VisualInformation();

        // TODO: Need to add all npcs seen by the current entity here
        // Need to get area around entity, then add all npcs/etc to their respective hashmaps

        memory.setVisualInformation(newVisualInformation);
    }
}
