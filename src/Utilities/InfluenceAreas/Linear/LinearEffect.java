package Utilities.InfluenceAreas.Linear;

import Model.Map.Location;
import Model.Map.Orientation;
import Utilities.InfluenceAreas.InfluenceArea;

import java.util.ArrayList;

/**
 * Created by AndyZhu on 13/4/2016.
 *
 * This class has 3 static method
 * getLinearSameLevel(...) for getting linear locations on the same level
 * getLinearTop(...) for getting linear locations on the top
 * getLinearBottom(...) for getting linear locations on the bottom
 */
public class LinearEffect extends InfluenceArea{

    /**
     * @param location : Location
     * @param orientation : Orientation
     * @param length : int
     * @return list : ArrayList<Location>
     */
    public static ArrayList<Location> getLinearSameLevel(Location location, Orientation orientation, int length) {
        ArrayList<Location> list = new ArrayList<>();
        Location cur = location;
        for (int i = 0; i < length; i++) {
            cur = new Location(cur.getX() + orientation.x, cur.getY() + orientation.y, cur.getZ());
            list.add(cur);
        }
        list = removeOutOfMapLocations(list);
        return list;
    }

    /**
     * @param location : Location
     * @param length : int
     * @return list : ArrayList<Location>
     */
    public static ArrayList<Location> getLinearTop(Location location, int length) {
        ArrayList<Location> list = new ArrayList<>();
        Location cur = location;
        for (int i = 0; i < length; i++) {
            cur = new Location(cur.getX(), cur.getY(), cur.getZ() + 1);
            list.add(cur);
        }
        list = removeOutOfMapLocations(list);
        return list;
    }

    /**
     * @param location : Location
     * @param length : int
     * @return list : ArrayList<Location>
     */
    public static ArrayList<Location> getLinearBottom(Location location, int length) {
        ArrayList<Location> list = new ArrayList<>();
        Location cur = location;
        for (int i = 0; i < length; i++) {
            cur = new Location(cur.getX(), cur.getY(), cur.getZ() - 1);
            list.add(cur);
        }
        list = removeOutOfMapLocations(list);
        return list;
    }
}
