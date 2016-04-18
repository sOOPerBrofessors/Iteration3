package Controller.AI_Controller.Personality;

import java.util.HashMap;

/**
 * Created by aseber on 4/7/16.
 */
public class PersonalityFactory {

    private static final HashMap<String, Personality> personalities = new HashMap<>();

    public static void addPersonality(String personalityName, Personality personality) {

        personalities.put(personalityName, personality);

    }

    public static Personality getPersonality(String personalityName) {

        return personalities.get(personalityName);

    }

}
