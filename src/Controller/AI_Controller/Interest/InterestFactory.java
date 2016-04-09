package Controller.AI_Controller.Interest;

import Utilities.IOUtilities;
import Utilities.ErrorLevel;
import Utilities.PersonFilter;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;

/**
 * Created by aseber on 4/8/16.
 */
public class InterestFactory {

    private static final String urlString = IOUtilities.getFileSystemDependentPath("Controller/AI_Controller/Interest/");
    private static final String packagePath = InterestFactory.class.getPackage().getName();
    private static HashMap<String, Interest> interests = new HashMap<>();

    private static void addInterest(String interestName, Interest interest) {

        interests.put(interestName, interest);

    }

    public static Interest getInterest(String interestName) {

        // Get the interest from the hashmap
        Interest interest = interests.get(interestName);

        // If the interest is null, try and dynamically load it from this directory
        if (interest == null) {

            try {

                URL[] urls = {new File(urlString).toURI().toURL()};
                URLClassLoader classLoader = new URLClassLoader(urls);
                Interest newInterest = (Interest) classLoader.loadClass(packagePath + "." + interestName).getConstructor().newInstance();
                addInterest(interestName, newInterest);
                interest = interests.get(interestName);
                Utilities.MessageHandler.println("InterestFactory: Dynamically loaded " + interestName + ".java", ErrorLevel.NOTICE, PersonFilter.AUSTIN);

            } catch (Exception e) {

                Utilities.MessageHandler.println("InterestFactory: Exception in getInterest method", ErrorLevel.ERROR, PersonFilter.AUSTIN);

            }

        }

        if (interest == null) {

            Utilities.MessageHandler.println("InterestFactory: NULL interest returned from input: " + interestName, ErrorLevel.CRITICAL, PersonFilter.AUSTIN);
            throw new NullPointerException();

        }

        return interest;

    }

}
