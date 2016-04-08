package Utilities;

/**
 * Created by aseber on 4/6/16.
 */
public class MathUtilities {

    public static final double putInRange(double min, double value, double max) {

        return Math.min(max, Math.max(value, min));

    }

}
