package Controller.AI_Controller.Interest;

import Controller.AI_Controller.MotorCortex.MotorCortexMemoryInterface;
import Controller.AI_Controller.VisualCortex.VisualInformation.VisualInformation;

import java.awt.*;

/**
 * Created by aseber on 4/6/16.
 */
public abstract class Interest {

    abstract public boolean isValid(Point pointOfInterest, VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface);

    abstract public String getName();

    abstract public void update(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface);

}