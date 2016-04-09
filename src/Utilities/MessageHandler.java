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

    public static void println(String string, ErrorLevel errorLevel, PersonFilter personFilter) {

        // First check the person filter
        if (isPersonFilterValid(personFilter)) {

            // Then the error filter
            if (isErrorLevelValid(errorLevel)) {

                // Then finally print the string!
                print(string, errorLevel, personFilter);

            }

        }

    }

    public static void println(String string, ErrorLevel errorLevel) {

        println(string, errorLevel, PersonFilter.UNSPECIFIED);

    }

    private static boolean isPersonFilterValid(PersonFilter personFilter) {

        return (personFilter == Settings.personFilter || Settings.personFilter == PersonFilter.ALL);

    }

    private static boolean isErrorLevelValid(ErrorLevel errorLevel) {

        return errorLevel.compare(Settings.errorLevel) >= 0;

    }

    private static void print(String string, ErrorLevel errorLevel, PersonFilter personFilter) {

        String output = "";

        output += errorLevel.toString();

        if (Settings.personFilter == PersonFilter.ALL) {

            output += " (" + personFilter.toString() + ")";

        }

        output += ": " + string;

        if (errorLevel.compare(ErrorLevel.ERROR) >= 0) {

            System.err.println(output);

        } else {

            System.out.println(output);

        }

    }

}
