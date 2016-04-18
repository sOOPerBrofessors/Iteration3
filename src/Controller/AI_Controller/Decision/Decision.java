package Controller.AI_Controller.Decision;

import Controller.AI_Controller.FrontalLobe.FrontalLobeMemoryInterface;
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

    private Interest interest;
    private double weight;
    private int interestSatisfiableTicker = -1;

    public Decision(Interest interest, double weight, VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        this.interest = interest;
        this.weight = weight;
        interest.initialize(visualInformation, memoryInterface);

    }

    // This method just passes along the checking to the interest, where it can truly be handled.
    public boolean isValid(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        // Decision isn't valid if the interest is finished
        if (interest.isFinished(visualInformation, memoryInterface)) {

            return false;

        }

        // If the interest ticker logic returns true, the interest is now stale and therefore invalid
        if (isInterestStale(visualInformation, memoryInterface)) {

            return false;

        }

        // Finally, if all else fails, the interest is valid! Yay!
        return true;

    }

    private boolean isInterestStale(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        // If the decision isn't satisfiable and the ticker is "uninitialized", initialize it.
        if (!interest.isSatisfiable(visualInformation, memoryInterface) && !isInterestTickerInitialized()) {

            initializeInterestTicker(visualInformation, memoryInterface);

        }

        // If the interest becomes satisfiable again and the interest ticker is "initialized", "uninitialize" it
        if (interest.isSatisfiable(visualInformation, memoryInterface) && isInterestTickerInitialized()) {

            uninitializeInterestTicker();

        }

        // Control decrements the interest ticker if it is "initialized"
        if (interestSatisfiableTicker != -1) {

            decrementInterestTicker();

        }

        // If the interest ticker is 0, we have lost interest due to time.
        if (hasInterestTickerFinished()) {

            return true;

        }

        return false;

    }

    private int getInterestTicker() {

        return interestSatisfiableTicker;

    }

    private void setInterestTicker(int value) {

        interestSatisfiableTicker = value;

    }

    private void initializeInterestTicker(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        setInterestTicker((int) (100 + (weight * 100) - (100 * Math.random() * memoryInterface.getPersonality().getScatter_brainedness())));

    }

    private void uninitializeInterestTicker() {

        setInterestTicker(-1);

    }

    private boolean isInterestTickerInitialized() {

        return getInterestTicker() != -1;

    }

    private void decrementInterestTicker() {

        setInterestTicker(getInterestTicker() - 1);

    }

    private boolean hasInterestTickerFinished() {

        return getInterestTicker() == 0;

    }

    public void update(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        interest.update(visualInformation, memoryInterface);
        interest.onEntityTouch(memoryInterface);

    }

    public final void moveStep(NPC npc) {

        boolean moved = false;

        if (shouldMove()) {
            // Move the NPC to the next step
            npc.setOrientation(getOrientationToMoveTo());
            moved = npc.getController().move(npc, getOrientationToMoveTo());

        }

        // If movement successful
        if (moved) {

            // consume the movement action, requiring us to update() to get a new one.
            consumeMovement();

        }

    }

    private boolean shouldMove() {

        return getOrientationToMoveTo() != null;

    }

    private final Orientation getOrientationToMoveTo() {

        return interest.getNextOrientationToMove();

    }

    private void consumeMovement() {

        interest.consumeMovement();

    }

    public double getValue(FrontalLobeMemoryInterface memoryInterface, double distance) {

        // TODO: Need to multiply by distance!
        double distanceScaling = 1 / Math.sqrt(distance);
        return interest.getValue(memoryInterface) * distanceScaling * weight;

    }

    public String toString() {


        return interest.toString() + " (" + weight + ")";
    }

}
