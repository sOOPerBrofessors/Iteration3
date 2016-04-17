package Utilities.MovementCalculations;

import Model.Map.Orientation;

import java.util.HashMap;

/**
 * Created by Wimberley on 4/17/16.
 */
public class ViewCalculations {

    private static HashMap<Orientation, Integer> startXPixel;
    private static HashMap<Orientation, Integer> startYPixel;

    private static HashMap<Orientation, Integer> moveXPixel;
    private static HashMap<Orientation, Integer> moveYPixel;

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

    public static void initPixels(){
        startXPixel = new HashMap<>();
        startYPixel = new HashMap<>();
        moveXPixel = new HashMap<>();
        moveYPixel = new HashMap<>();

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
        startXPixel.put(Orientation.NORTH, 0);
        startXPixel.put(Orientation.NORTHEAST, -1);
        startXPixel.put(Orientation.NORTHWEST, 1);
        startXPixel.put(Orientation.SOUTHEAST, -1);
        startXPixel.put(Orientation.SOUTHWEST, 1);
        startXPixel.put(Orientation.SOUTH, 0);

        // move y pixels based off orientation
        startYPixel.put(Orientation.NORTH, -2);
        startYPixel.put(Orientation.NORTHEAST, -1);
        startYPixel.put(Orientation.NORTHWEST, -1);
        startYPixel.put(Orientation.SOUTHEAST, 1);
        startYPixel.put(Orientation.SOUTHWEST, 1);
        startYPixel.put(Orientation.SOUTH, 2);
    }
}