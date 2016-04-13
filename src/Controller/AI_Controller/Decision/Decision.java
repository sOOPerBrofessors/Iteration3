package Controller.AI_Controller.Decision;

import Controller.AI_Controller.Interest.Interest;
import Controller.AI_Controller.MotorCortex.MotorCortexMemoryInterface;
import Controller.AI_Controller.VisualCortex.VisualInformation.VisualInformation;

import java.awt.*;

/**
 * Created by aseber on 4/6/16.
 */
public abstract class Decision {

    private Point pointOfInterest;
    private Interest interest;

    protected void setInterest(Interest interest) {

        this.interest = interest;

    }

    // This method just passes along the checking to the interest, where it can truly be handled.
    public boolean isValid(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        // Given the current interest in this decision, check if that interest is still valid
        return interest.isValid(getPointOfInterest(), visualInformation, memoryInterface);

    }

    public void update(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        interest.update(visualInformation, memoryInterface);
        //setPointOfInterest(interest.);

    }

    protected void setPointOfInterest(Point newPointOfInterest) {

        this.pointOfInterest = newPointOfInterest;

    }

    public final Point getPointOfInterest() {

        return pointOfInterest;

    }

}
