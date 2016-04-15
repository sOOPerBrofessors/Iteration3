package Controller.AI_Controller.Interest.PointInterests;

import Controller.AI_Controller.Interest.Interest;

/**
 * Created by aseber on 4/9/16.
 */
public abstract class PointInterest extends Interest {

    abstract public double getValue();

    public final InterestType getType() {

        return InterestType.POINT;

    }

}
