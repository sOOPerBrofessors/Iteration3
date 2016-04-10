package Utilities.AIStuff;

import Utilities.AIStuff.Relationship;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aseber on 4/6/16.
 */
public class RelationshipList<T> {

    HashMap<T, Relationship> relationships = new HashMap<>();

    public void addRelationship(T object, Relationship relationship) {

        relationships.put(object, relationship);

    }

    public void removeRelationship(T object) {

        relationships.remove(object);

    }

    public boolean relationshipExists(T object) {

        return relationships.keySet().contains(object);

    }

    public Relationship getRelationship(T object) {

        return relationships.get(object);

    }

    public String toString() {

        String output = new String();

        output += "Beginning of RelationshipList:\n";
        for (Map.Entry<T, Relationship> entry : relationships.entrySet()) {

            output += "\tEntry: (" + entry.getKey() + ", " + entry.getValue() + ")\n";

        }

        output += "End of RelationshipList";

        return output;

    }

}
