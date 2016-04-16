package Controller.AI_Controller.Interest.EntityInterests;

import Controller.AI_Controller.MotorCortex.MotorCortexMemoryInterface;
import Controller.AI_Controller.VisualCortex.VisualInformation.VisualInformation;
import Model.Map.Location;

/**
 * Created by aseber on 4/8/16.
 */
public class AttackInterest extends EntityInterest {

    Location locationOfEnemy;

    public void initialize(VisualInformation visualInformation, MotorCortexMemoryInterface memoryInterface) {

        update(visualInformation, memoryInterface);

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
            if (!locationOfEnemy.equals(newLocation)) {



            }

            locationOfEnemy = newLocation;

        }

    }

    public String getName() {

        return "AttackInterest";

    }

    public double getValue() {

        return 100;

    }

}
