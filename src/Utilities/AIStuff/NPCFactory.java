package Utilities.AIStuff;

import Controller.AI_Controller.Brain;
import Controller.AI_Controller.Personality.Personality;
import Controller.AI_Controller.Personality.PersonalityFactory;
import Model.Entity.Character.Mount.Mount;
import Model.Entity.Character.Mount.TheRealMount;
import Model.Entity.Character.NPC.KingKrab;
import Model.Entity.Character.NPC.NPC;
import Model.Entity.Character.NPC.NPCStrategy.NPCStrategy;
import Model.Entity.Character.NPC.NPCStrategy.TalkNPCStrategy;
import Model.Entity.Character.NPC.SeaGull;
import Model.Entity.Character.Occupation.*;
import Model.Faction.Faction;
import Model.Faction.FactionFactory;
import Model.Inventory.Inventory;
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

    public static NPC makeGuard(Location location) {
        Personality personality = PersonalityFactory.getPersonality("enemy");
        Faction faction = FactionFactory.getFaction("blue");
        //This should be a factory, testing for now
        NPCStrategy strategy = new TalkNPCStrategy("Ganondorf: Hi minion", "Ganondorf: I am awesome", "Ganondorf: What do you want?");
        NPC gandorf = new NPC(new Smasher(), location, personality, faction, new Inventory(), strategy);
        Brain brain = new Brain(gandorf);
        gandorf.setBrain(brain);
        return gandorf;
    }

    private static NPC makeGanondorf(Location location) {
        Personality personality = PersonalityFactory.getPersonality("enemy");
        Faction faction = FactionFactory.getFaction("red");
        NPCStrategy strategy = new TalkNPCStrategy("Ganondorf: Hi minion", "Ganondorf: I am awesome", "Ganondorf: What do you want?");
        NPC gandorf = new NPC(new Smasher(), location, personality, faction, new Inventory(), strategy);
        //gandorf.experienceEffect(5000);
        Brain brain = new Brain(gandorf);
        gandorf.setBrain(brain);
        return gandorf;
    }

    public static NPC makeEnemy(Location location) {
        Personality personality = PersonalityFactory.getPersonality("enemy");
        Faction faction = FactionFactory.getFaction("red");
        NPCStrategy strategy = new TalkNPCStrategy("MegaWizard: Die", "MegaWizard: I will break your Game", "MegaWizard: You will fail");
        NPC enemy = new NPC(new Enemy(), location, personality, faction, new Inventory(), strategy);
        Brain brain = new Brain(enemy);
        enemy.setBrain(brain);
        return enemy;
    }

    public static NPC makeCrab(Location location) {

        Personality personality = PersonalityFactory.getPersonality("enemy");
        Faction faction = FactionFactory.getFaction("neutral");
        NPCStrategy strategy = new TalkNPCStrategy("");
        NPC enemy = new KingKrab(new Crabby(), location, personality, faction, new Inventory(), strategy);
        Brain brain = new Brain(enemy);
        enemy.setBrain(brain);
        return enemy;

    }

    public static NPC makeBird(Location location) {

        Personality personality = PersonalityFactory.getPersonality("friendly");
        Faction faction = FactionFactory.getFaction("neutral");
        NPCStrategy strategy = new TalkNPCStrategy("");
        NPC enemy = new SeaGull(new Bird(), location, personality, faction, new Inventory(), strategy);
        Brain brain = new Brain(enemy);
        enemy.setBrain(brain);
        return enemy;

    }

    private static Mount theRealMount(Map map){
        return new TheRealMount(Navigation.makeVehicleNav(), new Location(6,2,map.getTopTilePosition(6,2)));
    }

    public static void init(Map map){
        mounts = new ArrayList<>();
        npcs = new ArrayList<>();

        npcs.add(makeHellCat());
        npcs.add(makeCrab(new Location(2,3, map.getTopTilePosition(2,3))));
        npcs.add(makeShopkeeper());
        npcs.add(makeGanondorf(new Location(10, 10, map.getTopTilePosition(10, 10))));
        npcs.add(makeEnemy(new Location(10, 7, map.getTopTilePosition(5, 7))));
//        npcs.add(makeBird(new Location(10, 7, 6)));
        mounts.add(theRealMount(map));
    }

    public static ArrayList<NPC> getNPCS(){
        return npcs;
    }

    public static NPC makeHellCat(){
        Personality personality = PersonalityFactory.getPersonality("pet");
        Faction faction = FactionFactory.getFaction("blue");
        //This should be a factory, testing for now
        NPCStrategy strategy = new TalkNPCStrategy("");
        NPC hellcat = new NPC(new Pet(), new Location(5,3,0), personality, faction, new Inventory(), strategy);
        Brain brain = new Brain(hellcat);
        hellcat.setBrain(brain);
        return hellcat;
    }

    public static NPC makeShopkeeper(){
        Personality personality = PersonalityFactory.getPersonality("shopkeeper");
        Faction faction = FactionFactory.getFaction("shopkeeper");
        //This should be a factory, testing for now
        NPCStrategy strategy = new TalkNPCStrategy("Hi! I'm the shopkeeper! Trade me!");
//        NPC gandorf = new NPC(new Smasher(), new Location(1,1,0), personality, faction, strategy);
        NPC shopkeeper = new NPC(new Shopkeeper(), new Location(4, 6, 0), personality, faction, new Inventory(), strategy);
        Brain brain = new Brain(shopkeeper);
        shopkeeper.setBrain(brain);
        return shopkeeper;
    }

    public static ArrayList<Mount> getMounts(){
        return mounts;
    }
}