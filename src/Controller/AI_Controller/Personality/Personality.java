package Controller.AI_Controller.Personality;

import Controller.AI_Controller.Interest.Interest;
import Controller.AI_Controller.Interest.InterestFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aseber on 4/7/16.
 */
public class Personality {

    private final String name;
    private final double scatter_brainedness;
    private final double aggressiveness;
    private final double laziness;
    private HashMap<String, Double> interests = new HashMap<>();

    public Personality(String name, double scatter_brainedness, double aggressiveness, double laziness, HashMap<String, Double> interests) {

        this.name = name;
        this.scatter_brainedness = scatter_brainedness;
        this.aggressiveness = aggressiveness;
        this.laziness = laziness;
        this.interests = interests;

    }

    private String getName() {

        return name;

    }

    public double getScatter_brainedness() {

        return scatter_brainedness;

    }

    public double getAggressiveness() {

        return aggressiveness;

    }

    public double getLaziness() {

        return laziness;

    }

    public HashMap<Interest, Double> getInterestsFromType(Interest.InterestType type) {

        HashMap<Interest, Double> interestsByType = new HashMap<>();

        for (Map.Entry<String, Double> entry : interests.entrySet()) {

            Interest interest = InterestFactory.getInterest(entry.getKey());

            if (interest.getType() == type) {

                interestsByType.put(interest, entry.getValue());

            }

        }

        return interestsByType;

    }

    public String printInterests() {

        String output = "";

        output += "Personality: " + getName() + "\n";
        output += "Beginning of InterestList:\n";
        for (Map.Entry<String, Double> entry : interests.entrySet()) {

            output += "\tEntry: (" + entry.getKey() + ", " + entry.getValue() + ")\n";

        }

        output += "End of InterestList";

        return output;

    }

    public String toString() {

        return getName();

    }

}
