package Controller.AI_Controller.Interest;

import Controller.AI_Controller.MotorCortex.MotorCortexMemoryInterface;
import Controller.AI_Controller.VisualCortex.VisualInformation.VisualInformation;

import java.awt.*;

/**
 * Created by aseber on 4/8/16.
 */
public class TalkInterest extends EntityInterest {

    public boolean isValid(Point pointOfInterest, VisualInformation visualInformatio, MotorCortexMemoryInterface memoryInterface) {

        return false;

    }

    public void update(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {



    }

    public String getName() {

        return "TalkInterest";

    }

}
