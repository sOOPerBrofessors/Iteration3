package Utilities;

import Model.Map.Location;

/**
 * Created by aseber on 4/6/16.
 */
public class MathUtilities {

    public static final double putInRange(double min, double value, double max) {

        return Math.min(max, Math.max(value, min));

    }

    public static final double euclideanDistance(Location l1, Location l2) {

        double value = Math.sqrt(
            Math.pow(l2.getX() - l1.getX(), 2.0) +
            Math.pow(l2.getY() - l1.getY(), 2.0) +
            Math.pow(l2.getZ() - l1.getZ(), 2.0)
        );

        return value;

    }

    public static final Location subtractLocations(Location l1, Location l2) {

        return new Location(l1.getX() - l2.getX(), l1.getY() - l2.getY(), l1.getZ() - l2.getZ());

    }

}
