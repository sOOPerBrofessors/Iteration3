package Utilities.InfluenceAreas.Volumetric;

import Model.Map.Location;
import Utilities.InfluenceAreas.InfluenceArea;
import Utilities.InfluenceAreas.Linear.LinearEffect;
import Utilities.InfluenceAreas.Planer.RadialEffect;

import java.util.ArrayList;

/**
 * Created by AndyZhu on 13/4/2016.
 * Tested by Andy on 14/4/2016
 *
 * There are three public methods in this class, you can get whole sphere or hemi sphere
 */
class SphericalEffect extends InfluenceArea {

    /**
     * base method in this class, the other two methods are similar
     * @param location : Location
     * @param radius : int
     * @return an ArrayList of all locations in the sphere
     */
    /** Example of use */
    /*
    ArrayList<Location> list = SphericalEffect.getSphericalEffect(new Location(11,3,1), 3);
    for (Location aList:list) {
        System.out.println("(" + aList.getX() + ", " + aList.getY() + ", " + aList.getZ() + ')');
    }
    */
    private static ArrayList<Location> getSphericalEffect(Location location, int radius) {
        ArrayList<Location> list = new ArrayList<>();
        ArrayList<Location> tempLocations = RadialEffect.getRadialArea(location, radius);
        list.addAll(tempLocations); //on same level

        ArrayList<Location> centerLineTop = LinearEffect.getLinearTop(location, radius);
        for (int distanceFromOrigin = 1; distanceFromOrigin < centerLineTop.size(); distanceFromOrigin++) {
            Location tempOrigin = centerLineTop.get(distanceFromOrigin);
            tempLocations = RadialEffect.getRadialArea(tempOrigin, radius - distanceFromOrigin);
            list.addAll(tempLocations);
        }

        ArrayList<Location> centerLineBottom = LinearEffect.getLinearBottom(location, radius);
        for (int distanceFromOrigin = 1; distanceFromOrigin < centerLineBottom.size(); distanceFromOrigin++) {
            Location tempOrigin = centerLineBottom.get(distanceFromOrigin);
            tempLocations = RadialEffect.getRadialArea(tempOrigin, radius - distanceFromOrigin);
            list.addAll(tempLocations);
        }

        list = removeOutOfMapLocations(list);
        return list;
    }

    public static ArrayList<Location> getTopHemiSphericalEffect (Location location, int radius) {
        ArrayList<Location> wholeSphereList = SphericalEffect.getSphericalEffect(location, radius);
        ArrayList<Location> list = new ArrayList<>();

        for (Location locationInWholeSphere : wholeSphereList) {
            if (locationInWholeSphere.getZ() >= location.getZ()) {
                list.add(locationInWholeSphere);
            }
        }

        return list;
    }

    public static ArrayList<Location> getBottomHemiSphericalEffect (Location location, int radius) {
        ArrayList<Location> wholeSphereList = SphericalEffect.getSphericalEffect(location, radius);
        ArrayList<Location> list = new ArrayList<>();

        for (Location locationInWholeSphere : wholeSphereList) {
            if (locationInWholeSphere.getZ() <= location.getZ()) {
                list.add(locationInWholeSphere);
            }
        }

        return list;
    }
}
