package Utilities;

import java.util.ArrayList;

/**
 * Created by broskj on 4/15/16.
 *
 * This class manages game messages on the screen.  Only five strings are displayed at a time.
 *
 * Class uses an ArrayList to simulate a FIFO queue.
 *
 * Any messages with length over a
 */
public class GameMessageQueue {
    public static final ArrayList<String> queue = new ArrayList<>();
    private final static int cap = 5;

    public static void push(String message) {
        while(message.length() > Settings.CHAR_LIMIT) {
            int startIndex = message.length() - message.length() % Settings.CHAR_LIMIT;
            String newString = " " + message.substring(startIndex, message.length());
            push(newString);
            message = message.substring(0, message.length()-newString.length()+1);
        }
        if (queue.size() >= cap) {
            queue.remove(0);
        }
        queue.add(message);
    } // end push
} // end class GameMessageQueue
