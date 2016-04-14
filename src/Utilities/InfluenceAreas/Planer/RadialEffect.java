package Utilities.InfluenceAreas.Planer;

import Model.Map.Location;
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
    ArrayList<Location> list = RadialEffect.getInfluenceArea(new Location(x, y, z), radius);
    for (int i = 0; i < list.size(); i++) {
        //actions here
    }
    */
    public static ArrayList<Location> getInfluenceArea(Location location, int radius) {
        ArrayList<Location> list = new ArrayList<>();
        Location northPoint = location.getAdjacentNorth();
        Location tempPoint;
        list.add(location);
        for (int i = 1; i <= radius; i++) {
            tempPoint = northPoint;
            for (int j = 0; j < i; j++) {
                tempPoint = tempPoint.getAdjacentSouthEast();
                list.add(tempPoint);
            }
            for (int j = 0; j < i; j++) {
                tempPoint = tempPoint.getAdjacentSouth();
                list.add(tempPoint);
            }
            for (int j = 0; j < i; j++) {
                tempPoint = tempPoint.getAdjacentSouthWest();
                list.add(tempPoint);
            }
            for (int j = 0; j < i; j++) {
                tempPoint = tempPoint.getAdjacentNorthWest();
                list.add(tempPoint);
            }
            for (int j = 0; j < i; j++) {
                tempPoint = tempPoint.getAdjacentNorth();
                list.add(tempPoint);
            }
            for (int j = 0; j < i; j++) {
                tempPoint = tempPoint.getAdjacentNorthEast();
                list.add(tempPoint);
            }
            northPoint = northPoint.getAdjacentNorth();
        }
        list = removeOutOfMapLocations(list);
        return list;
    }

    /**
     * @param location : Location
     * @param radius : int
     * @return ArrayList<ArrayList<Location>>
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

        Location northPoint = location.getAdjacentNorth();
        Location tempPoint;

        innerList.add(location);
        list.add(innerList);

        for (int i = 1; i <= radius; i++) {
            innerList = new ArrayList<>();

            tempPoint = northPoint;

            for (int j = 0; j < i; j++) {
                tempPoint = tempPoint.getAdjacentSouthEast();
                innerList.add(tempPoint);
            }
            for (int j = 0; j < i; j++) {
                tempPoint = tempPoint.getAdjacentSouth();
                innerList.add(tempPoint);
            }
            for (int j = 0; j < i; j++) {
                tempPoint = tempPoint.getAdjacentSouthWest();
                innerList.add(tempPoint);
            }
            for (int j = 0; j < i; j++) {
                tempPoint = tempPoint.getAdjacentNorthWest();
                innerList.add(tempPoint);
            }
            for (int j = 0; j < i; j++) {
                tempPoint = tempPoint.getAdjacentNorth();
                innerList.add(tempPoint);
            }
            for (int j = 0; j < i; j++) {
                tempPoint = tempPoint.getAdjacentNorthEast();
                innerList.add(tempPoint);
            }
            northPoint = northPoint.getAdjacentNorth();
            innerList = removeOutOfMapLocations(innerList);
            list.add(innerList);
        }
        return list;
    }
}
