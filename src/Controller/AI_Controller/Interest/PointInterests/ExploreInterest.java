package Controller.AI_Controller.Interest.PointInterests;

import Controller.AI_Controller.MotorCortex.MotorCortexMemoryInterface;
import Controller.AI_Controller.VisualCortex.VisualInformation.VisualInformation;

import java.awt.*;

/**
 * Created by aseber on 4/8/16.
 */
public class ExploreInterest extends PointInterest {

    public boolean isFinished(Point pointOfInterest, VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        return !((pointOfInterest).equals(memoryInterface.getNPC().getLocation()));

    }

    public boolean isSatisfiable(Point pointOfInterest, VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        return true;

    }

    public void update(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        // No need to update the interest point for a simple exploration. May be necessary for a more complicated guardInterest
        return;

    }

    public Point derivePointOfInterest(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        // TODO: Use visitor?
        // TODO: Need a way to get the rim of this entities known tiles, so we can explore new regions!
        return new Point(0, 0);

    }

    public String getName() {

        return "ExploreInterest";

    }

    public double getValue() {

        return 100;

    }

}
