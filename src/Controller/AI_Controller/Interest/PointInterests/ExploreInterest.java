package Controller.AI_Controller.Interest.PointInterests;

import Controller.AI_Controller.MotorCortex.MotorCortexMemoryInterface;
import Controller.AI_Controller.VisualCortex.VisualInformation.VisualInformation;
import Model.Map.Orientation;
import Utilities.UniformPicker;

import java.util.ArrayList;

/**
 * Created by aseber on 4/8/16.
 */
public class ExploreInterest extends PointInterest {

    Orientation orientationToMove;

    public void initialize(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        // TODO: Use visitor?
        // TODO: Need a way to get the rim of this entities known tiles, so we can explore new regions!
        UniformPicker<Orientation> orientations = new UniformPicker<>();
        ArrayList<Orientation> validOrientations = memoryInterface.getNPC().getController().moveableOrientations(memoryInterface.getNPC());

        for (Orientation orientation : validOrientations) {

            orientations.add(orientation, 1.0);

        }

        orientationToMove =  orientations.pick();

    }

    public boolean isFinished(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        return false;//!((memoryInterface.getNPC().getLocation()).equals(memoryInterface.getNPC().getLocation()));

    }

    public boolean isSatisfiable(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        return true;

    }

    public void update(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        // No need to update the interest point for a simple exploration. May be necessary for a more complicated guardInterest

        return;

    }

    public Orientation getNextOrientationToMove() {

        return orientationToMove;

    }

    public String getName() {

        return "ExploreInterest";

    }

    public double getValue() {

        return 100;

    }

}
