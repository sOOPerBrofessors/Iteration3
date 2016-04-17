package Utilities.MovementCalculations;

import Model.Map.Orientation;
import Utilities.Settings;

import java.util.HashMap;

/**
 * Created by Wimberley on 4/17/16.
 */
public class ViewCalculations {

    private static HashMap<Orientation, Integer> startXPixel;
    private static HashMap<Orientation, Integer> startYPixel;

    private static HashMap<Orientation, Integer> moveXPixel;
    private static HashMap<Orientation, Integer> moveYPixel;

    private static HashMap<Orientation, Integer> goalXPixel;
    private static HashMap<Orientation, Integer> goalYPixel;

    public static int startXPixel(Orientation orientation, int x){
        return  x + startXPixel.get(orientation);
    }

    public static int startYPixel(Orientation orientation, int y){
        return  y + startYPixel.get(orientation);
    }

    public static int moveXPixel(Orientation orientation, int x){
        return x + moveXPixel.get(orientation);
    }

    public static int moveYpixel(Orientation orientation, int y){
        return y + moveYPixel.get(orientation);
    }

    public static int goalXPixel(Orientation orientation, int x){
        return x + goalXPixel.get(orientation);
    }

    public static int goalYPixel(Orientation orientation, int y){
        return y + goalYPixel.get(orientation);
    }

    public static void initPixels(){
        startXPixel = new HashMap<>();
        startYPixel = new HashMap<>();
        moveXPixel = new HashMap<>();
        moveYPixel = new HashMap<>();
        goalXPixel = new HashMap<>();
        goalYPixel = new HashMap<>();

        // start x pixels based off orientation
        startXPixel.put(Orientation.NORTH, 0);
        startXPixel.put(Orientation.NORTHEAST, -22);
        startXPixel.put(Orientation.NORTHWEST, 22);
        startXPixel.put(Orientation.SOUTHEAST, -22);
        startXPixel.put(Orientation.SOUTHWEST, 22);
        startXPixel.put(Orientation.SOUTH, 0);

        // start y pixels based off orientation
        startYPixel.put(Orientation.NORTH, 10);
        startYPixel.put(Orientation.NORTHEAST, 12);
        startYPixel.put(Orientation.NORTHWEST, 12);
        startYPixel.put(Orientation.SOUTHEAST, -10);
        startYPixel.put(Orientation.SOUTHWEST, -10);
        startYPixel.put(Orientation.SOUTH, -20);

        // move x pixels based off orientation
        moveXPixel.put(Orientation.NORTH, 0);
        moveXPixel.put(Orientation.NORTHEAST, 1);
        moveXPixel.put(Orientation.NORTHWEST, -1);
        moveXPixel.put(Orientation.SOUTHEAST, 1);
        moveXPixel.put(Orientation.SOUTHWEST, -1);
        moveXPixel.put(Orientation.SOUTH, 0);

        // move y pixels based off orientation
        moveYPixel.put(Orientation.NORTH, -2);
        moveYPixel.put(Orientation.NORTHEAST, -1);
        moveYPixel.put(Orientation.NORTHWEST, -1);
        moveYPixel.put(Orientation.SOUTHEAST, 1);
        moveYPixel.put(Orientation.SOUTHWEST, 1);
        moveYPixel.put(Orientation.SOUTH, 2);

        // goal x pixels based off orientation
        goalXPixel.put(Orientation.NORTH, 0);
        goalXPixel.put(Orientation.NORTHEAST, Settings.TILEWIDTH/2);
        goalXPixel.put(Orientation.NORTHWEST, -Settings.TILEWIDTH/2);
        goalXPixel.put(Orientation.SOUTHEAST, Settings.TILEWIDTH/2);
        goalXPixel.put(Orientation.SOUTHWEST, -Settings.TILEWIDTH/2);
        goalXPixel.put(Orientation.SOUTH, 0);

        // goal y pixels based off orientation
        goalYPixel.put(Orientation.NORTH, -Settings.TILEHEIGHT/2);
        goalYPixel.put(Orientation.NORTHEAST, -Settings.TILEHEIGHT/4);
        goalYPixel.put(Orientation.NORTHWEST, -Settings.TILEHEIGHT/4);
        goalYPixel.put(Orientation.SOUTHEAST, Settings.TILEHEIGHT/4);
        goalYPixel.put(Orientation.SOUTHWEST, Settings.TILEHEIGHT/4);
        goalYPixel.put(Orientation.SOUTH, Settings.TILEHEIGHT/2);
    }
}