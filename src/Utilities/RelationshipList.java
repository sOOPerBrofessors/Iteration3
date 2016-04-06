package Utilities;

import java.util.HashMap;

/**
 * Created by aseber on 4/6/16.
 */
public class RelationshipList<T> {

    HashMap<T, Relationship> relationships = new HashMap<>();

    public void addRelationship(T object, Relationship relationship) {

        relationships.put(object, relationship);

    }

    public Relationship getRelationship(T object) {

        return relationships.get(object);

    }

}
