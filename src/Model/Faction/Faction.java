package Model.Faction;

import Utilities.AIStuff.Relationship;
import Utilities.AIStuff.RelationshipList;

/**
 * Created by aseber on 4/7/16.
 */
public class Faction {

    private final String name;
    private final RelationshipList<Faction> factionRelationshipList = new RelationshipList<>();

    public Faction(String name) {

        this.name = name;

    }

    public void addFactionRelationship(Faction faction, Relationship relationship) {

        factionRelationshipList.addRelationship(faction, relationship);

    }

    private String getName() {

        return name;

    }

    public double getRelationship(Faction otherFaction) {

        if (this == otherFaction) {
            return 1.0;
        }

        Relationship relationship = factionRelationshipList.getRelationship(otherFaction);

        if (relationship == null) {

            return 0.0;

        }

        return relationship.getValue();

    }

    public String printRelationships() {

        String output = "";

        output += "Faction: " + getName() + "\n";
        output += factionRelationshipList.toString();

        return output;

    }

    public String toString() {

        return getName();

    }

}
