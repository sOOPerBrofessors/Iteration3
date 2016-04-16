package Utilities;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aseber on 4/6/16.
 */
public class UniformPicker<T> {

    // We store all the values in a hashmap with their weights
    private HashMap<T, Double> values = new HashMap<>();
    private double totalWeight = 0.0;

    // Method for adding values to the hashmap
    public void add(T value, Double weight) {

        totalWeight += weight;
        values.put(value, weight);

    }

    // Method for removing values from the hashmap
    public void remove(T value) {

        if (values.containsKey(value)) {

            totalWeight -= values.get(value);
            values.remove(value);

        }

    }

    // Method randomly picks a value from the hashmap, removes it, then returns it.
    // This works by first iterating through the hashmap and normalizing all of the values to [0, 1],
    // Then picking a randomly distributed number and returning the value that fits in that space.
    public T pick() {

        if (isEmpty()) {

            MessageHandler.println("UniformPicker: Trying to pick from an empty set!", ErrorLevel.ERROR);
            return null;

        }

        T value = getNextValue();
        remove(value);
        return value;

    }

    public boolean isEmpty() {

        return values.isEmpty();

    }

    private T getNextValue() {

        HashMap<T, Range> normalizedValues = normalizeValues();
        double d = getNextRandom();

        for (HashMap.Entry<T, Range> value : normalizedValues.entrySet()) {

            if (value.getValue().inRange(d)) {

                return value.getKey();

            }

        }

        MessageHandler.println("UniformPicker: Reached end of normalized values and couldn't find a suitable value. d = " + d, ErrorLevel.ERROR);
        return null;

    }

    private double getNextRandom() {

        return Math.random();

    }

    private HashMap<T, Range> normalizeValues() {

        HashMap<T, Range> normalizedValues = new HashMap<>();
        double location = 0.0;

        for (HashMap.Entry<T, Double> value : values.entrySet()) {

            double weightDiff = value.getValue() / totalWeight;

            double beginLocation = location;
            double endLocation = location + weightDiff;
            normalizedValues.put(value.getKey(), new Range(beginLocation, endLocation));

            location += weightDiff;

        }

        return normalizedValues;

    }

    public String toString() {

        String output = "";

        output += "UniformPicker values:\n";
        HashMap<T, Range> normalizedValues = normalizeValues();

        for (Map.Entry<T, Range> entry : normalizedValues.entrySet()) {

            output += "\t" + entry.getKey() + entry.getValue() + "\n";

        }

        return output;

    }

    private class Range {

        private double begin;
        private double end;

        public Range(double begin, double end) {

            this.begin = begin;
            this.end = end;

        }

        public boolean inRange(double value) {

            return (begin <= value && value < end);

        }

        public String toString() {

            return "(" + begin + " - " + end + ")";

        }

    }

}
