package Utilities.InfluenceAreas;

import Model.Map.Location;

import java.util.ArrayList;

/**
 * Created by AndyZhu on 13/4/2016.
 */
public abstract class InfluenceArea {
    /**
     * change xLimit, yLimit, and zLimit for different map size
     * @param list : ArrayList<Location>
     * @return a new list with only valid locations. i.e. locations inside map
     */
    protected static ArrayList<Location> removeOutOfMapLocations (ArrayList<Location> list) {
        int xLimit = 10;
        int yLimit = 10;
        int zLimit = 10;
        int curX, curY, curZ;
        ArrayList<Location> newList = new ArrayList<>();
        for (Location cur : list) {
            curX = cur.getX();
            curY = cur.getY();
            curZ = cur.getZ();
            if ((curX >= 0 && curX <= xLimit) &&
                    (curY >= 0 && curY <= yLimit) &&
                    (curZ >= 0 && curZ <= zLimit)) {
                newList.add(cur);
            }
        }
        return newList;
    }
}
