package Utilities.InfluenceAreas.Volumetric;

import Model.Map.Location;
import Utilities.InfluenceAreas.InfluenceArea;
import Utilities.InfluenceAreas.Planer.RadialEffect;

import java.util.ArrayList;

/**
 * Created by AndyZhu on 13/4/2016.
 *
 * This class has four public methods
 * 1st get all locations in the prism with full height
 * 2nd get all locations in the prism with full height, with radius
 * 3rd get all locations in the prism with height higher than the location passed in
 * 4th get all locations in the prism with height higher than the location passed in, with radius
 */
public class PrismEffect extends InfluenceArea {

    /** Example of use */
    /*
    ArrayList<Location> list = PrismEffect.getPrismVolumeFullHeight(new Location(11,3,1),2);
    for (Location aList : list) {
        System.out.println("(" + aList.getX() + ", " + aList.getY() + ", " + aList.getZ() + ")");
    }
    */

    /**
     * @param location : Location
     * @param radius : int
     * @return an ArrayList with all tiles in the prism volume
     */
    public static ArrayList<Location> getPrismVolumeFullHeight(Location location, int radius) {
        ArrayList<Location> list = new ArrayList<>();
        ArrayList<Location> planerAreaList = RadialEffect.getRadialArea(location, radius);

        for (Location curLocation : planerAreaList) {
            list = addLocationsInSameColumnFullHeight(list, curLocation);
        }

        list = removeOutOfMapLocations(list);
        return list;
    }

    /** Example of use */
    /*
    ArrayList<ArrayList<Location>> list = PrismEffect.getPrismVolumeFullHeightWithRadius(new Location(11,3,1),2);

    for (int i = 0; i < list.size(); i++) {
        System.out.println("Radius: " + i);
        for (Location aList : list.get(i)) {
            System.out.println("(" + aList.getX() + ", " + aList.getY() + ", " + aList.getZ() + ")");
        }
    }
    */
    /**
     * @param location : Location
     * @param radius : int
     * @return an ArrayList of ArrayList of Locations with all tiles in the prism volume with same radius
     */
    public static ArrayList<ArrayList<Location>> getPrismVolumeFullHeightWithRadius (Location location, int radius) {
        ArrayList<ArrayList<Location>> list = new ArrayList<>();
        ArrayList<Location> innerList;
        ArrayList<ArrayList<Location>> planerAreaList = RadialEffect.getAreaWithRadius(location, radius);

        //traverse innerLists, i.e. circles
        for (ArrayList<Location> aPlanerAreaList : planerAreaList) {
            innerList = new ArrayList<>();
            //do stuff with the locations of the same circle
            for (Location curLocation : aPlanerAreaList) {
                innerList = addLocationsInSameColumnFullHeight(innerList, curLocation);
            }

            innerList = removeOutOfMapLocations(innerList);
            list.add(innerList);
        }
        return list;
    }

    /**
     * Use this method the same way with getPrismVolumeFullHeight()
     * @param location : Location
     * @param radius : int
     * @return an ArrayList with all tiles in the prism volume
     */
    public static ArrayList<Location> getPrismVolumeHigherThanLocationPassedIn(Location location, int radius) {
        int height = location.getZ();
        ArrayList<Location> list = getPrismVolumeFullHeight(location, radius);
        list = removeLocationsLowerThan(list, height);
        return list;
    }

    /**
     * Use this method the same way with getPrismVolumeFullHeightWithRadius()
     * @param location : Location
     * @param radius : int
     * @return an ArrayList of ArrayList of Locations with all tiles in the prism volume with same radius,
     * and at the same time higher or on the same level, with respect to the height of location passed in
     */
    public static ArrayList<ArrayList<Location>> getPrismVolumeHigherThanLocationPassedInWithRadius (Location location, int radius) {
        int height = location.getZ();
        ArrayList<ArrayList<Location>> list = getPrismVolumeFullHeightWithRadius(location, radius);
        ArrayList<ArrayList<Location>> validatedList = new ArrayList<>();
        for (ArrayList<Location> aList : list) {
            aList = removeLocationsLowerThan(aList, height);
            validatedList.add(aList);
        }
        return validatedList;
    }


    /**
     * Below are private methods
     */
    private static ArrayList<Location> addLocationsInSameColumnFullHeight(ArrayList<Location> list, Location location) {
        Location temp = new Location(location.getX(), location.getY(), 0);
        int zLimit = 10; //largest index of vertical tiles
        for (int z = 0; z <= zLimit; z++) {
            list.add(temp);
            temp = temp.getAdjacentTop();
        }
        return list;
    }

    private static ArrayList<Location> removeLocationsLowerThan(ArrayList<Location> list, int height) {
        ArrayList<Location> newList = new ArrayList<>();
        for (Location aList : list) {
            if (aList.getZ() >= height)
                newList.add(aList);
        }
        return newList;
    }
}
