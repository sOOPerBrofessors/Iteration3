package Model.Faction;

import java.util.HashMap;

/**
 * Created by aseber on 4/7/16.
 */
public class FactionFactory {

    private static HashMap<String, Faction> personalities = new HashMap<>();

    public static void addFaction(String factionName, Faction faction) {

        personalities.put(factionName, faction);

    }

    public static Faction getFaction(String factionName) {

        return personalities.get(factionName);

    }

}
