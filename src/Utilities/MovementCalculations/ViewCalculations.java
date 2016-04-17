package Utilities.MovementCalculations;

import Model.Map.Orientation;
import Utilities.Settings;

import java.util.HashMap;

/**
 * Created by Wimberley on 4/17/16.
 */
public class ViewCalculations {

    private static HashMap<Orientation, Integer> xPixel;
    private static HashMap<Orientation, Integer> yPixel;

    public static int getXPixel(Orientation orientation, int x){
        return xPixel.get(orientation) + x*Settings.TILEWIDTH - (x*(Settings.TILEWIDTH))/4;
    }

    public static int getYPixel(Orientation orientation, int y){
        return yPixel.get(orientation) + y*(Settings.TILEHEIGHT - 5) + ((Settings.TILEHEIGHT-7)*y)/2;
    }

    public static void initPixels(){
        xPixel = new HashMap<>();
        yPixel = new HashMap<>();

        // x pixels based off orientation
        xPixel.put(Orientation.NORTH, 0);
        xPixel.put(Orientation.NORTHEAST, Settings.TILEWIDTH/2);
        xPixel.put(Orientation.NORTHWEST, -Settings.TILEWIDTH/2);
        xPixel.put(Orientation.SOUTHEAST, Settings.TILEWIDTH/2);
        xPixel.put(Orientation.SOUTHWEST, -Settings.TILEWIDTH/2);
        xPixel.put(Orientation.SOUTH, 0);

        // y pixels based off orientation
        yPixel.put(Orientation.NORTH, -Settings.TILEHEIGHT);
        yPixel.put(Orientation.NORTHEAST, 0);
        yPixel.put(Orientation.NORTHWEST, 0);
        yPixel.put(Orientation.SOUTHEAST, 0);
        yPixel.put(Orientation.SOUTHWEST, 0);
        yPixel.put(Orientation.SOUTH, Settings.TILEHEIGHT);
    }
}
