package Utilities;

/**
 * Created by broskj on 4/6/16.
 *
 * Class to handle printing messages to the console.  Should be expanded upon in the future to print messages on the
 *  game screen to notify the player of actions/warnings/etc.
 *
 * Only prints currently if debug variable is set to true.  This may be modified by calling 'Settings.setDebug();'
 */
public class MessageHandler {
    public static void printError(String s) {
        if(Settings.debug)
            System.out.println("ERROR: " + s);
    } // end printError

    public static void printWarning(String s) {
        if(Settings.debug)
            System.out.println("WARNING: " + s);
    } // end printWarning

    public static void printSuccess(String s) {
        if(Settings.debug)
            System.out.println("SUCCESS: " + s);
    } // end printSuccess
} // end MessageHandler
