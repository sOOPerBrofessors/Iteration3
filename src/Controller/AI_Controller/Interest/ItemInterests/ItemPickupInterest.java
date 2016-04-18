package Controller.AI_Controller.Interest.ItemInterests;

import Controller.AI_Controller.MotorCortex.MotorCortexMemoryInterface;
import Controller.AI_Controller.VisualCortex.VisualInformation.VisualInformation;

import java.awt.*;

/**
 * Created by aseber on 4/9/16.
 */
class ItemPickupInterest {// extends ItemInterest {

    public boolean isValid(Point pointOfInterest, VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        return false;

    }

    public void update(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {



    }

    public String getName() {

        return "ItemPickupInterest";

    }

}
