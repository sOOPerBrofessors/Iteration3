package Utilities.InfluenceAreas.Planer;

import Model.Map.Location;
import Model.Map.Orientation;
import Utilities.InfluenceAreas.InfluenceArea;

import java.util.ArrayList;

/**
 * Created by AndyZhu on 13/4/2016.
 *
 * This class has two public static methods
 * see comments below
 */
public class AngularEffect extends InfluenceArea {
    /**
     * @param location : Location
     * @param orientation : Orientation
     * @param radius : int
     * @return an ArrayList with all Locations in the influence area
     */
    /* Example of use
    ArrayList<Location> list = AngularEffect.getAngularArea(new Location(x, y, z), Orientation.SOUTH, radius);
    for (Location aList : list) {
        System.out.println("(" + aList.getX() + ", " + aList.getY() + ")");
    }
    */
    public static ArrayList<Location> getAngularArea(Location location, Orientation orientation, int radius) {
        ArrayList<Location> list = new ArrayList<>();

        Location middle = location;
        int orientationIndex = getOrientationIndex(orientation);

        for (int curRadius = 0; curRadius <= radius; curRadius++) {
            list = addLocationsOnCurrentRadius(list, middle, orientationIndex, curRadius);
            middle = middle.getAdjacent(orientation);
        }
        list = removeOutOfMapLocations(list);
        return list;
    }

    /**
     *
     * @param location : Location
     * @param orientation : Orientation
     * @param radius : int
     * @return an ArrayList of ArrayLists of Locations, each inner ArrayList contains Locations with the same radius
     */
    /* Example of use
    ArrayList<ArrayList<Location>> list = AngularEffect.getAngularAreaWithRadius(new Location(11,9,1), Orientation.SOUTHWEST, 10);
    for (int i = 0; i < list.size(); i++) {
        System.out.println("Radius: " + i);
        for (Location aList : list.get(i)) {
            System.out.println("(" + aList.getX() + ", " + aList.getY() + ")");
        }
    }
    */
    public static ArrayList<ArrayList<Location>> getAngularAreaWithRadius(Location location, Orientation orientation, int radius) {
        ArrayList<ArrayList<Location>> list = new ArrayList<>();
        ArrayList<Location> innerList;

        Location middle = location;
        int orientationIndex = getOrientationIndex(orientation);

        for (int curRadius = 0; curRadius <= radius; curRadius++) {
            innerList = new ArrayList<>();
            innerList = addLocationsOnCurrentRadius(innerList, middle, orientationIndex, curRadius);
            innerList = removeOutOfMapLocations(innerList);

            middle = middle.getAdjacent(orientation);
            list.add(innerList);
        }

        return list;
    }

    //only for use in this class
    private static ArrayList<Location> addLocationsOnCurrentRadius(ArrayList<Location> list,
                                                                   Location middleLocation,
                                                                   int orientationIndex,
                                                                   int curRadius) {
        list.add(middleLocation);

        Location temp = middleLocation;

        orientationIndex = getNextOriIndexClockwise(orientationIndex);
        orientationIndex = getNextOriIndexClockwise(orientationIndex);

        //if even then expand out curRadius/2 in both directions
        //if odd expand out curRadius/2 (truncated) in both directions
        //i < 2 for two direction
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= curRadius / 2; j++) {
                temp = temp.getAdjacent(orientationArr[orientationIndex]);
                list.add(temp);
            }

            orientationIndex = getNextOriIndexClockwise(orientationIndex);
            orientationIndex = getNextOriIndexClockwise(orientationIndex);
            temp = middleLocation;
        }
        return list;
    }
}
