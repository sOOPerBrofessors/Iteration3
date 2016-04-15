package Utilities.InfluenceAreas.Planer;

import Model.Map.Location;
import Model.Map.Orientation;
import Utilities.InfluenceAreas.InfluenceArea;

import java.util.ArrayList;

/**
 * Created by AndyZhu on 13/4/2016.
 *
 * This class has two public method
 * The first one return an ArrayList of all locations
 * While the second one return an ArrayList of ArrayLists.
 * Each inner ArrayList contains all locations with the same radius.
 */
public class RadialEffect extends InfluenceArea{

    /**
     * @param location : Location
     * @param radius : int
     * @return ArrayList of all the locations inside the radius
     */
    /* Example of use:
    ArrayList<Location> list = RadialEffect.getRadialArea(new Location(x, y, z), radius);
    for (int i = 0; i < list.size(); i++) {
        //actions here
    }
    */
    public static ArrayList<Location> getRadialArea(Location location, int radius) {
        ArrayList<Location> list = new ArrayList<>();

        Location northPoint = location.getAdjacent(Orientation.NORTH);

        list.add(location);
        for (int i = 1; i <= radius; i++) {
            list = addLocationsOnCurrentRadius(list, i, northPoint);
            northPoint = northPoint.getAdjacent(Orientation.NORTH);
        }
        list = removeOutOfMapLocations(list);
        return list;
    }

    /**
     * @param location : Location
     * @param radius : int
     * @return an ArrayList of ArrayLists of Locations, each inner ArrayList contains Locations with the same radius
     */
    /* Example of use
    ArrayList<ArrayList<Location>> list = RadialEffect.getAreaWithRadius(new Location(x, y, z), radius);

    for (int i = 0; i < list.size(); i++) {
        System.out.println("Radius: " + i);
        for (Location aList : list.get(i)) {
            System.out.println("(" + aList.getX() + ", " + aList.getY() + ")");
        }
    }
    */
    public static ArrayList<ArrayList<Location>> getAreaWithRadius(Location location, int radius) {
        ArrayList<ArrayList<Location>> list = new ArrayList<>();
        ArrayList<Location> innerList = new ArrayList<>();

        Location northPoint = location.getAdjacent(Orientation.NORTH);

        innerList.add(location);
        list.add(innerList);

        for (int i = 1; i <= radius; i++) {
            innerList = new ArrayList<>();

            innerList = addLocationsOnCurrentRadius(innerList, i, northPoint);

            northPoint = northPoint.getAdjacent(Orientation.NORTH);

            innerList = removeOutOfMapLocations(innerList);
            list.add(innerList);
        }
        return list;
    }

    private static ArrayList<Location> addLocationsOnCurrentRadius(ArrayList<Location> list, int curRadius, Location northPoint) {
        int curOrientationIndex = 2; //SouthEast
        for (int j = 0; j < 6; j++) {
            for (int k = 0; k < curRadius; k++) {
                northPoint = northPoint.getAdjacent(orientationArr[curOrientationIndex]);
                list.add(northPoint);
            }
            curOrientationIndex = getNextOriIndexClockwise(curOrientationIndex);
        }
        return list;
    }
}
