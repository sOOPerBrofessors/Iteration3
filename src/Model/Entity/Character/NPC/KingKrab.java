package Model.Entity.Character.NPC;

import Controller.AI_Controller.Personality.Personality;
import Model.Entity.Character.NPC.NPCStrategy.NPCStrategy;
import Model.Entity.Character.Occupation.Occupation;
import Model.Faction.Faction;
import Model.Inventory.Inventory;
import Model.Map.Location;
import Utilities.Navigation.Navigation;

/**
 * Created by aseber on 4/18/16.
 */
public class KingKrab extends NPC {

    public KingKrab(Occupation o, Location location, Personality personality, Faction faction, Inventory inventory, NPCStrategy npcStrategy) {
        super(o, location, personality, faction, inventory, npcStrategy);
        navigation = Navigation.makeAquaticNav();
    }

}
