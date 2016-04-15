package Controller.AI_Controller.Interest;

import Controller.AI_Controller.MotorCortex.MotorCortexMemoryInterface;
import Controller.AI_Controller.VisualCortex.VisualInformation.VisualInformation;

import java.awt.*;

/**
 * Created by aseber on 4/6/16.
 */
public abstract class Interest {

    public enum InterestType {

        ENTITY,
        ITEM,
        POINT

    }

    // Checks to see if the interest is finished, this will immediately finish the decision
    abstract public boolean isFinished(Point pointOfInterest, VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface);

    // Checks to see if the interest is currently applicable. If not, the interest may do something in order to make it
    // satisfiable again, such as go to the last possible point they were seen, but the bottom line is that after a suitable amount
    // of time, the decision will declare the interest dead (based on the scatter_brainedness variable)
    abstract public boolean isSatisfiable(Point pointOfInterest, VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface);

    // Allows the interest to update its internals
    abstract public void update(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface);

    // The interest name, duh.
    abstract public String getName();

    // Allows the interest to return its declared point of interest
    abstract public Point derivePointOfInterest(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface);

    // Gets the declared value of the interest, the higher the value, the higher the probabliity of its corresponding
    // decision will be picked from a uniform picker.
    abstract public double getValue();

    abstract public InterestType getType();

    public final String toString() {

        return getName();

    }

}