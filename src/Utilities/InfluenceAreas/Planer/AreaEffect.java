package Utilities.InfluenceAreas.Planer;

import Model.Map.Location;
import Utilities.InfluenceAreas.InfluenceArea;

import java.util.ArrayList;

/**
 * Created by AndyZhu on 13/4/2016.
 *
 *
 * ArrayList<Location> list = AreaEffect.getInfluenceArea(new Location(x, y, z), radius);
 * for (int i = 0; i < list.size(); i++) {
 *     //actions here
 * }
 */
public class AreaEffect implements InfluenceArea{

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
        return list;
    }
}
