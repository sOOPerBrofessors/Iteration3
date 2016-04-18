package Controller.AI_Controller.Interest.EntityInterests;

import Controller.AI_Controller.FrontalLobe.FrontalLobeMemoryInterface;
import Controller.AI_Controller.MotorCortex.MotorCortexMemoryInterface;
import Controller.AI_Controller.VisualCortex.VisualInformation.VisualInformation;
import Model.Entity.Entity;
import Model.Map.Location;
import Utilities.AIStuff.Relationship;

/**
 * Created by aseber on 4/8/16.
 */
public class AttackInterest extends EntityInterest {

    Location targetOldLocation;

    public void initialize(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        addToMovementQueue(computePathToTarget(memoryInterface));
        targetOldLocation = getTargetEntity().getLocation();

    }

    public boolean isFinished(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        // TODO: Need to actually implement this, the entity must be dead!
        return false;

    }

    public boolean isSatisfiable(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        // We don't know where the entity is, so we'll try and move to their last known location!
        return visualInformation.entityExists(getTargetEntity());

    }

    public void update(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        Location newLocation;

        if (isSatisfiable(visualInformation, memoryInterface)) {

            newLocation = getTargetEntity().getLocation();

            // TODO: Rebuild the navigation queue when the old locaiton does not equal the new location
            if (!targetOldLocation.equals(newLocation)) {

                resetMovementQueue();
                addToMovementQueue(computePathToTarget(memoryInterface));
                targetOldLocation = getTargetEntity().getLocation();

            }

            targetOldLocation = newLocation;

        }

    }

    public String getName() {

        return "AttackInterest";

    }

    public double getValue(FrontalLobeMemoryInterface memoryInterface) {

        Relationship entityRelationship = memoryInterface.getRelationships().getRelationship(getTargetEntity());

        if (entityRelationship.isHostile()) {

            return 100 * entityRelationship.getValue();

        }

        return 0;

    }

    public void onEntityTouch(MotorCortexMemoryInterface memoryInterface) {

        memoryInterface.getNPC().getController().attack(memoryInterface.getNPC());

    }

}
