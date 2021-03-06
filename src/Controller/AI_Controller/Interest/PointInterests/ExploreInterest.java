package Controller.AI_Controller.Interest.PointInterests;

import Controller.AI_Controller.FrontalLobe.FrontalLobeMemoryInterface;
import Controller.AI_Controller.MotorCortex.MotorCortexMemoryInterface;
import Controller.AI_Controller.VisualCortex.VisualInformation.VisualInformation;
import Model.Map.Orientation;
import Utilities.ErrorLevel;
import Utilities.MessageHandler;
import Utilities.UniformPicker;

import java.util.ArrayList;

/**
 * Created by aseber on 4/8/16.
 */
public class ExploreInterest extends PointInterest {

    public void initialize(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        // TODO: Use visitor?
        // TODO: Need a way to get the rim of this npcs known tiles, so we can explore new regions!
        UniformPicker<Orientation> orientations = new UniformPicker<>();
        ArrayList<Orientation> validOrientations = memoryInterface.getNPC().getController().moveableOrientations(memoryInterface.getNPC());

        for (Orientation orientation : validOrientations) {

            orientations.add(orientation, 1.0);

        }

        try {

            addToMovementQueue(orientations.pick());

        } catch (NullPointerException e) {

            MessageHandler.println("ExploreInterest: Decision picker was empty when you tried to pick from it, make sure this NPC is in an area it's actually mean't to be", ErrorLevel.ERROR);

        }


    }

    public boolean isFinished(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        return isMovementQueueEmpty();

    }

    public boolean isSatisfiable(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        return true;

    }

    public void update(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        // No need to update the interest point for a simple exploration. May be necessary for a more complicated guardInterest

    }

    public String getName() {

        return "ExploreInterest";

    }

    public double getValue(FrontalLobeMemoryInterface memoryInterface) {

        return 100;

    }

}
