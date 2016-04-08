package Controller.AI_Controller.Interest;

import Controller.AI_Controller.Personality.Personality;

import java.util.HashMap;

/**
 * Created by aseber on 4/8/16.
 */
public class InterestFactory {

    private static HashMap<String, Interest> interests = new HashMap<>();

    public static void addInterest(String interestName, Interest interest) {

        System.out.println("ba");
        interests.put(interestName, interest);

    }

    public static Interest getInterest(String interestName) {

        return interests.get(interestName);

    }

}
