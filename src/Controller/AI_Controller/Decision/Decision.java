package Controller.AI_Controller.Decision;

import Controller.AI_Controller.Interest.Interest;
import Controller.AI_Controller.MotorCortex.MotorCortexMemoryInterface;
import Controller.AI_Controller.VisualCortex.VisualInformation.VisualInformation;

import java.awt.*;

/**
 * Created by aseber on 4/6/16.
 */
public class Decision {

    // We should only change decisions if the decision is finished, or the entity has randomly decided to drop it.
    // Dropping decisions is less likely if  the entity is more interested in the decision

    private Point pointOfInterest;
    private Interest interest;
    private double weight;

    public Decision(Interest interest, double weight, VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        this.interest = interest;
        this.weight = weight;
        this.pointOfInterest = interest.derivePointOfInterest(visualInformation, memoryInterface);

    }

    // This method just passes along the checking to the interest, where it can truly be handled.
    public boolean isValid(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        // Given the current interest in this decision, check if that interest is still valid
        return !interest.isFinished(getPointOfInterest(), visualInformation, memoryInterface);

    }

    public void update(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        interest.update(visualInformation, memoryInterface);
        setPointOfInterest(interest.derivePointOfInterest(visualInformation, memoryInterface));

    }

    private void setPointOfInterest(Point newPointOfInterest) {

        this.pointOfInterest = newPointOfInterest;

    }

    public final Point getPointOfInterest() {

        return pointOfInterest;

    }

    public double getValue() {

        // TODO: Need to multiply by distance!
        return interest.getValue();

    }

    public String toString() {


        return interest.toString() + " (" + weight + ")";
    }

}
