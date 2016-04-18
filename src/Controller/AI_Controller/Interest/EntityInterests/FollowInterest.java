package Controller.AI_Controller.Interest.EntityInterests;

import Controller.AI_Controller.MotorCortex.MotorCortexMemoryInterface;
import Controller.AI_Controller.VisualCortex.VisualInformation.VisualInformation;
import Model.Map.Location;

/**
 * Created by aseber on 4/8/16.
 */
public class FollowInterest extends EntityInterest {

    private Location targetOldLocation;

    public void initialize(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        // TODO: Need to pathfind to entity, and save the npcs current location!
        addToMovementQueue(computePathToTarget(memoryInterface.getNPC()));

    }

    public boolean isFinished(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        // We can always follow our interest!
        return false;

    }

    public boolean isSatisfiable(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        return visualInformation.entityExists(getTargetEntity());

    }

    public void update(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        if (isSatisfiable(visualInformation, memoryInterface)) {

            if (!getTargetEntity().getLocation().equals(targetOldLocation)) {

                resetMovementQueue();
                addToMovementQueue(computePathToTarget(memoryInterface.getNPC()));

            }

        }

    }

    public String getName() {

        return "FollowInterest";

    }

    public double getValue() {

        return 100;

    }

}
