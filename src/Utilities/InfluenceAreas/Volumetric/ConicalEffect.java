package Utilities.InfluenceAreas.Volumetric;

import Model.Map.Location;
import Model.Map.Orientation;
import Utilities.InfluenceAreas.InfluenceArea;
import Utilities.InfluenceAreas.Linear.LinearEffect;
import Utilities.InfluenceAreas.Planer.AngularEffect;
import Utilities.InfluenceAreas.Planer.RadialEffect;

import java.util.ArrayList;

/**
 * Created by AndyZhu on 13/4/2016.
 * Tested by Andy on 14/4/2016
 *
 * For all the methods in this class, distance between locations and origin location are not recorded
 *
 */
class ConicalEffect extends InfluenceArea {
    /** Example of use, the same for all methods */
    /*
    ArrayList<Location> list = ConicalEffect.getConicalEffectTop(new Location(11,3,1), 12);
    for (Location aList:list) {
        System.out.println("(" + aList.getX() + ", " + aList.getY() + ", " + aList.getZ() + ')');
    }
    */
    public static ArrayList<Location> getConicalEffectTop(Location location, int height) {
        ArrayList<Location> list = new ArrayList<>();
        ArrayList<Location> centerLine = LinearEffect.getLinearTop(location, height);
        list = addLocationsAroundALine3D(list, centerLine);
        list = removeOutOfMapLocations(list);
        return list;
    }

    public static ArrayList<Location> getConicalEffectBottom(Location location, int height) {
        ArrayList<Location> list = new ArrayList<>();
        ArrayList<Location> centerLine = LinearEffect.getLinearBottom(location, height);
        list = addLocationsAroundALine3D(list, centerLine);
        list = removeOutOfMapLocations(list);
        return list;
    }

    private static ArrayList<Location> getConicalEffect(Orientation orientation, Location location, int length) {
        ArrayList<Location> list = new ArrayList<>();
        ArrayList<Location> centerLine = LinearEffect.getLinearSameLevel(location, orientation, length);

        ArrayList<Location> locationsOnSameLevel = AngularEffect.getAngularArea(location, orientation, length);
        Location tempOrigin;
        list.addAll(locationsOnSameLevel);
        //note curRadius start from 1 on purpose
        for (int curRadius = 1; curRadius < centerLine.size(); curRadius++) {
            //top
            tempOrigin = centerLine.get(curRadius);
            for (int i = 0; i < curRadius; i++)
                tempOrigin = tempOrigin.getAdjacentTop();
            locationsOnSameLevel = AngularEffect.getAngularArea(tempOrigin, orientation, length - curRadius);
            list.addAll(locationsOnSameLevel);
            //bottom
            tempOrigin = centerLine.get(curRadius);
            for (int i = 0; i < curRadius; i++)
                tempOrigin = tempOrigin.getAdjacentBottom();
            locationsOnSameLevel = AngularEffect.getAngularArea(tempOrigin, orientation, length - curRadius);
            list.addAll(locationsOnSameLevel);
        }
        list = removeOutOfMapLocations(list);
        return list;
    }

    public static ArrayList<Location> getTopHemiConicalEffect(Orientation orientation, Location location, int length) {
        ArrayList<Location> list = getConicalEffect(orientation, location, length);
        ArrayList<Location> newList = new ArrayList<>();
        for (Location aList : list) {
            if (aList.getZ() >= location.getZ())
                newList.add(aList);
        }
        return newList;
    }

    public static ArrayList<Location> getBottomHemiConicalEffect(Orientation orientation, Location location, int length) {
        ArrayList<Location> list = getConicalEffect(orientation, location, length);
        ArrayList<Location> newList = new ArrayList<>();
        for (Location aList : list) {
            if (aList.getZ() <= location.getZ())
                newList.add(aList);
        }
        return newList;
    }

    private static ArrayList<Location> addLocationsAroundALine3D(ArrayList<Location> list, ArrayList<Location> centerLine){
        Location center;
        ArrayList<Location> locationsOnSameLevel;
        for (int curRadius = 0; curRadius < centerLine.size(); curRadius++) {
            center = centerLine.get(curRadius);
            locationsOnSameLevel = RadialEffect.getRadialArea(center, curRadius);
            list.addAll(locationsOnSameLevel);
        }
        return list;
    }
}
