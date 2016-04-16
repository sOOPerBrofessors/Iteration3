package Controller.AI_Controller.Decision;

import Controller.AI_Controller.Interest.Interest;
import Controller.AI_Controller.MotorCortex.MotorCortexMemoryInterface;
import Controller.AI_Controller.VisualCortex.VisualInformation.VisualInformation;
import Model.Entity.Character.NPC.NPC;
import Model.Map.Orientation;

/**
 * Created by aseber on 4/6/16.
 */
public class Decision {

    // We should only change decisions if the decision is finished, or the entity has randomly decided to drop it.
    // Dropping decisions is less likely if  the entity is more interested in the decision

    private Orientation orientationToMoveTo;
    private boolean movementAvailable;
    private Interest interest;
    private double weight;

    public Decision(Interest interest, double weight, VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        this.interest = interest;
        this.weight = weight;
        interest.initialize(visualInformation, memoryInterface);
        orientationToMoveTo = interest.getNextOrientationToMove();

    }

    // This method just passes along the checking to the interest, where it can truly be handled.
    public boolean isValid(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        // Given the current interest in this decision, check if that interest is still valid
        return !interest.isFinished(visualInformation, memoryInterface);

    }

    public void update(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        interest.update(visualInformation, memoryInterface);

        if (!isMovementAvailable()) {

            setNextMovementStep(interest.getNextOrientationToMove());

        }

    }

    public final void moveStep(NPC npc) {

        // Move the NPC to the next step
        boolean moved = npc.getController().move(npc, getOrientationToMoveTo());

        // If movement successful
        if (moved) {

            // consume the movement action, requiring us to update() to get a new one.
            consumeMovement();

        }

    }

    private final Orientation getOrientationToMoveTo() {

        return orientationToMoveTo;

    }

    private boolean isMovementAvailable() {

        return movementAvailable;

    }

    private void consumeMovement() {

        movementAvailable = false;

    }

    private void setNextMovementStep(Orientation orientationToMoveTo) {

        if (orientationToMoveTo != null) {

            this.orientationToMoveTo = orientationToMoveTo;
            movementAvailable = true;

        }

    }

    public double getValue() {

        // TODO: Need to multiply by distance!
        return interest.getValue();

    }

    public String toString() {


        return interest.toString() + " (" + weight + ")";
    }

}
