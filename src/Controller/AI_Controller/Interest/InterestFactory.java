package Controller.AI_Controller.Interest;

import Controller.AI_Controller.Interest.EntityInterests.AttackInterest;
import Controller.AI_Controller.Interest.EntityInterests.FollowInterest;
import Controller.AI_Controller.Interest.PointInterests.ExploreInterest;
import Utilities.ErrorLevel;
import Utilities.PersonFilter;

import java.util.HashMap;

/**
 * Created by aseber on 4/8/16.
 */
public class InterestFactory {

//    private static final String urlString = IOUtilities.getFileSystemDependentPath("Controller/AI_Controller/Interest/");
//    private static final String packagePath = InterestFactory.class.getPackage().getName();
    private static HashMap<String, AbstractInterestFactory> interests = new HashMap<>();

    static {

        addInterest(ExploreInterest::new);
        addInterest(FollowInterest::new);
        addInterest(AttackInterest::new);
//        addInterest(new FleeInterest());
//        addInterest(new ItemPickupInterest());
//        addInterest(new TalkInterest());
//        addInterest(new TradeInterest());

    }

    private static void addInterest(AbstractInterestFactory interestFactory) {

        interests.put(interestFactory.create().getName(), interestFactory);

    }

    public static Interest getInterest(String interestName) {

        // Get the interest from the hashmap
        AbstractInterestFactory interestCreator = interests.get(interestName);

        // If the interest is null, try and dynamically load it from this directory
        // Note: this is not OOP! So instead we'll be using a static factory implementation
        /*if (interest == null) {

            try {

                URL[] urls = {new File(urlString).toURI().toURL()};
                URLClassLoader classLoader = new URLClassLoader(urls);
                Interest newInterest = (Interest) classLoader.loadClass(packagePath + "." + interestName).getConstructor().newInstance();
                addInteres*t(interestName, newInterest);
                interest = interests.get(interestName);
                Utilities.MessageHandler.println("InterestFactory: Dynamically loaded " + interestName + ".java", ErrorLevel.NOTICE, PersonFilter.AUSTIN);

            } catch (Exception e) {

                Utilities.MessageHandler.println("InterestFactory: Exception in getInterest method", ErrorLevel.ERROR, PersonFilter.AUSTIN);

            }

        }*/

        if (interestCreator == null) {

            Utilities.MessageHandler.println("InterestFactory: NULL interest returned from input: " + interestName, ErrorLevel.CRITICAL, PersonFilter.AUSTIN);
            throw new NullPointerException();

        }

        return interestCreator.create();

    }

    private interface AbstractInterestFactory {

        Interest create();

    }

}