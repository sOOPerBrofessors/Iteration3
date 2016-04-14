package Utilities.InfluenceAreas.Volumetric;

import Model.Map.Location;
import Utilities.InfluenceAreas.InfluenceArea;
import Utilities.InfluenceAreas.Planer.RadialEffect;

import java.util.ArrayList;

/**
 * Created by AndyZhu on 13/4/2016.
 */
public class PrismEffect extends InfluenceArea {

    /* Example of use
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
            list = addLocationsInSameColumn(list, curLocation);
        }

        list = removeOutOfMapLocations(list);
        return list;
    }

    /* Example of use
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

        for (ArrayList<Location> aPlanerAreaList : planerAreaList) {
            innerList = new ArrayList<>();
            for (Location curLocation : aPlanerAreaList) {
                innerList = addLocationsInSameColumn(innerList, curLocation);
            }
            innerList = removeOutOfMapLocations(innerList);
            list.add(innerList);
        }
        return list;
    }

    private static ArrayList<Location> addLocationsInSameColumn(ArrayList<Location> list, Location location) {
        Location temp = new Location(location.getX(), location.getY(), 0);
        int zLimit = 10; //largest index of vertical tiles
        for (int z = 0; z <= zLimit; z++) {
            list.add(temp);
            temp = temp.getAdjacentTop();
        }
        return list;
    }
}
