package Utilities;

/**
 * Created by aseber on 4/9/16.
 */

/* Class defines a method that acts like System.out.println(). Useful because instead of typing a conditional statement
*  like if (Settings.debug) {
*           System.out.println(string);
*       }
*
*  with Utilities.Debug.println(string);
* */
public class Debug {

    // The actual method definition
    public static void println(String string) {

        if (Settings.debug) {

            System.out.println(string);

        }

    }

}
