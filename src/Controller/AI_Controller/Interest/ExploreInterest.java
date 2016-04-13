package Controller.AI_Controller.Interest;

import Controller.AI_Controller.MotorCortex.MotorCortexMemoryInterface;
import Controller.AI_Controller.VisualCortex.VisualInformation.VisualInformation;

import java.awt.*;

/**
 * Created by aseber on 4/8/16.
 */
public class ExploreInterest extends PointInterest {

    public boolean isValid(Point pointOfInterest, VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        return !((pointOfInterest).equals(memoryInterface.getNPC().getLocation()));

    }

    public void update(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        // No need to update the interest point for a simple exploration. May be necessary for a more complicated guardInterest
        return;

    }

    public String getName() {

        return "ExploreInterest";

    }

}
