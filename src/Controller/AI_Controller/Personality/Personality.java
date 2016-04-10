package Controller.AI_Controller.Personality;

import Controller.AI_Controller.Interest.Interest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aseber on 4/7/16.
 */
public class Personality {

    private String name;
    private double scatter_brainedness;
    private double aggressiveness;
    private double laziness;
    private HashMap<Interest, Double> interests = new HashMap<>();

    public Personality(String name, double scatter_brainedness, double aggressiveness, double laziness, HashMap<Interest, Double> interests) {

        this.name = name;
        this.scatter_brainedness = scatter_brainedness;
        this.aggressiveness = aggressiveness;
        this.laziness = laziness;
        this.interests = interests;

    }

    public String getName() {

        return name;

    }

    public String printInterests() {

        String output = new String();

        output += "Personality: " + getName() + "\n";
        output += "Beginning of InterestList:\n";
        for (Map.Entry<Interest, Double> entry : interests.entrySet()) {

            output += "\tEntry: (" + entry.getKey() + ", " + entry.getValue() + ")\n";

        }

        output += "End of InterestList";

        return output;

    }

    public String toString() {

        return getName();

    }

}
