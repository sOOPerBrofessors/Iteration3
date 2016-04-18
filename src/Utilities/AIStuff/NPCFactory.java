package Utilities.AIStuff;

import Controller.AI_Controller.Brain;
import Controller.AI_Controller.Personality.Personality;
import Controller.AI_Controller.Personality.PersonalityFactory;
import Model.Entity.Character.Mount.Mount;
import Model.Entity.Character.Mount.TheRealMount;
import Model.Entity.Character.NPC.NPC;
import Model.Entity.Character.NPC.NPCStrategy.NPCStrategy;
import Model.Entity.Character.NPC.NPCStrategy.TalkNPCStrategy;
import Model.Entity.Character.Occupation.Smasher;
import Model.Faction.Faction;
import Model.Faction.FactionFactory;
import Model.Map.Location;
import Model.Map.Map;
import Utilities.Navigation.Navigation;

import java.util.ArrayList;

/**
 * Created by Wimberley on 4/9/16.
 */
public class NPCFactory {

    private static ArrayList<Mount> mounts;
    private static ArrayList<NPC> npcs;

    public static NPC makeGanondorf(Map map){
        Personality personality = PersonalityFactory.getPersonality("friendly");
        Faction faction = FactionFactory.getFaction("red");
        NPCStrategy strategy = new TalkNPCStrategy("Ganondorf: Hi minion", "Ganondorf: I am awesome", "Ganondorf: What do you want?");
        NPC gandorf = new NPC(new Smasher(), new Location(1,1,map.getTopTilePosition(1,1)), personality, faction, strategy);
        Brain brain = new Brain(gandorf);
        gandorf.setBrain(brain);
        return gandorf;
    }

    public static Mount theRealMount(Map map){
        return new TheRealMount(Navigation.makeVehicleNav(), new Location(7,4,map.getTopTilePosition(7,4)));
    }

    public static void init(Map map){
        mounts = new ArrayList<>();
        npcs = new ArrayList<>();

        npcs.add(makeGanondorf(map));
        mounts.add(theRealMount(map));
    }

    public static ArrayList<NPC> getNPCS(){
        return npcs;
    }

    public static ArrayList<Mount> getMounts(){
        return mounts;
    }
}