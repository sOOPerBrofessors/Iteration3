package Utilities;

import java.util.ArrayList;

/**
 * Created by broskj on 4/15/16.
 *
 * This class manages game messages on the screen.  Only five strings are displayed at a time.
 *
 * Class uses an ArrayList to simulate a FIFO queue.
 */
public class GameMessageQueue {
    public static ArrayList<String> queue = new ArrayList<>();
    final static int cap = 5;

    public static void push(String message) {
        if (queue.size() >= cap) {
            queue.remove(0);
        }
        queue.add(message);
    } // end push
} // end class GameMessageQueue
