package Controller.AI_Controller.Interest.EntityInterests;

import Controller.AI_Controller.FrontalLobe.FrontalLobeMemoryInterface;
import Controller.AI_Controller.MotorCortex.MotorCortexMemoryInterface;
import Controller.AI_Controller.VisualCortex.VisualInformation.VisualInformation;
import Model.Map.Location;
import Utilities.AIStuff.Relationship;

/**
 * Created by aseber on 4/8/16.
 */
public class FollowInterest extends EntityInterest {

    private Location targetOldLocation;

    public void initialize(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        // TODO: Need to pathfind to entity, and save the entities current location!
        addToMovementQueue(computePathToTarget(memoryInterface));
        targetOldLocation = getTargetEntity().getLocation();
    }

    public boolean isFinished(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        // We can always follow our target!
        return false;

    }

    public boolean isSatisfiable(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        return visualInformation.entityExists(getTargetEntity());

    }

    public void update(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        if (isSatisfiable(visualInformation, memoryInterface)) {

            if (!(getTargetEntity().getLocation().equals(targetOldLocation))) {

                resetMovementQueue();
                addToMovementQueue(computePathToTarget(memoryInterface));
                targetOldLocation = getTargetEntity().getLocation();

            }

        }

    }

    public String getName() {

        return "FollowInterest";

    }

    public double getValue(FrontalLobeMemoryInterface memoryInterface) {

        Relationship entityRelationship = memoryInterface.getRelationships().getRelationship(getTargetEntity());

        if (entityRelationship.isFriendly()) {

            return 100 * entityRelationship.getValue();

        }

        return 0;

    }

    public void onEntityTouch(MotorCortexMemoryInterface memory) {

        // Do nothing! Gaze at them, we don't care.

    }

}
