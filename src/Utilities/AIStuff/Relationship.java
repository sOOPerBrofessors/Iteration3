package Utilities.AIStuff;

import Utilities.MathUtilities;

/**
 * Created by aseber on 4/6/16.
 */
public class Relationship {

    private double value = 0.0;

    public Relationship(double value) {

        this.value = MathUtilities.putInRange(-1.0, value);

    }

    public double getValue() {

        return value;

    }

    private void setValue(double value) {

        this.value = MathUtilities.putInRange(-1.0, value);

    }

    public void modifyValue(double delta_Value) {

        setValue(getValue() - delta_Value);

    }

    public boolean isFriendly() {

        return value > 0.25;

    }

    public boolean isNeutral() {

        return value >= -0.25 && value <= 0.25;

    }

    public boolean isHostile() {

        return value < -0.25;

    }

    public String toString() {

        return "Relationship: (" + Double.toString(value) + ")";

    }

}
