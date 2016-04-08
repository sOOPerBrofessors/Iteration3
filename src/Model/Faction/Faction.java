package Model.Faction;

import Utilities.Relationship;
import Utilities.RelationshipList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aseber on 4/7/16.
 */
public class Faction {

    private String name;
    private RelationshipList<Faction> factionRelationshipList = new RelationshipList<>();

    public Faction(String name) {

        this.name = name;

    }

    public void addFactionRelationship(Faction faction, Relationship relationship) {

        factionRelationshipList.addRelationship(faction, relationship);

    }

    public String getName() {

        return name;

    }

    public String printRelationships() {

        String output = new String();

        output += "Faction: " + getName() + "\n";
        output += factionRelationshipList.toString();

        return output;

    }

    public String toString() {

        return getName();

    }

}
