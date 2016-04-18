package Controller.AI_Controller.Interest.PointInterests;

import Controller.AI_Controller.Interest.Interest;
import Controller.AI_Controller.MotorCortex.MotorCortexMemoryInterface;

/**
 * Created by aseber on 4/9/16.
 */
public abstract class PointInterest extends Interest {

    abstract public double getValue();

    public final InterestType getType() {

        return InterestType.POINT;

    }

    public void onEntityTouch(MotorCortexMemoryInterface memory) {

        // Do nothing!

    }

}
