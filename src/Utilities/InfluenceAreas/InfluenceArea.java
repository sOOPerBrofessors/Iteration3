package Utilities.InfluenceAreas;

import Model.Map.Location;
import Model.Map.Orientation;
import Utilities.ErrorLevel;
import Utilities.MessageHandler;
import Utilities.PersonFilter;

import java.util.ArrayList;

/**
 * Created by AndyZhu on 13/4/2016.
 *
 * Parent of all kinds of influence areas
 * Has several utility methods for it's subclasses to use
 */
public abstract class InfluenceArea {

    protected static final Orientation[] orientationArr = {
            Orientation.NORTH,
            Orientation.NORTHEAST,
            Orientation.SOUTHEAST,
            Orientation.SOUTH,
            Orientation.SOUTHWEST,
            Orientation.NORTHWEST
    };
    /**
     * change xLimit, yLimit, and zLimit for different map size
     * @param list : ArrayList<Location>
     * @return a new list with only valid locations. i.e. locations inside map
     */
    protected static ArrayList<Location> removeOutOfMapLocations (ArrayList<Location> list) {
        int xLimit = 14;
        int yLimit = 14;
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

    protected static int getOrientationIndex(Orientation orientation) {
        for (int i = 0; i < orientationArr.length; i++) {
            if (orientationArr[i] == orientation)
                return i;
        }
        MessageHandler.println("InfluenceArea: orientation not found", ErrorLevel.NOTICE, PersonFilter.ANDY);
        return 0;
    }

    protected static int getNextOriIndexClockwise (int i) {
        if (i == orientationArr.length - 1)
            return 0;
        return i + 1;
    }
}
