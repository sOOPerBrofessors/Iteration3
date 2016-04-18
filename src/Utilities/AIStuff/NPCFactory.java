package Utilities.AIStuff;

import Controller.AI_Controller.Brain;
import Controller.AI_Controller.Personality.Personality;
import Controller.AI_Controller.Personality.PersonalityFactory;
import Model.Entity.Character.NPC.NPC;
import Model.Entity.Character.NPC.NPCStrategy.NPCStrategy;
import Model.Entity.Character.NPC.NPCStrategy.TalkNPCStrategy;
import Model.Entity.Character.Occupation.Pet;
import Model.Entity.Character.Occupation.Shopkeeper;
import Model.Entity.Character.Occupation.Smasher;
import Model.Faction.Faction;
import Model.Faction.FactionFactory;
import Model.Inventory.Inventory;
import Model.Items.Takeable.Useable.Money;
import Model.Map.Location;

import java.util.ArrayList;

/**
 * Created by Wimberley on 4/9/16.
 */
public class NPCFactory {

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

    public static NPC makeGanondorf(Location location) {
        Personality personality = PersonalityFactory.getPersonality("enemy");
        Faction faction = FactionFactory.getFaction("red");
        //This should be a factory, testing for now
        NPCStrategy strategy = new TalkNPCStrategy("Ganondorf: Hi minion", "Ganondorf: I am awesome", "Ganondorf: What do you want?");
       // NPC gandorf = new NPC(new Smasher(), new Location(9,2,3), personality, faction, new Inventory(), strategy);
        NPC gandorf = new NPC(new Smasher(), location, personality, faction, new Inventory(), strategy);
        Brain brain = new Brain(gandorf);
        gandorf.setBrain(brain);
        return gandorf;
    }

    public static NPC makeHellCat(){
        Personality personality = PersonalityFactory.getPersonality("pet");
        Faction faction = FactionFactory.getFaction("blue");
        //This should be a factory, testing for now
        NPCStrategy strategy = new TalkNPCStrategy("");
//        NPC gandorf = new NPC(new Smasher(), new Location(1,1,0), personality, faction, strategy);
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
        NPC shopkeeper = new NPC(new Shopkeeper(), new Location(7, 4, 0), personality, faction, new Inventory(), strategy);
        Brain brain = new Brain(shopkeeper);
        shopkeeper.setBrain(brain);
        return shopkeeper;
    }

    public static ArrayList<NPC> init(){
        ArrayList<NPC> entities = new ArrayList<>();

        entities.add(makeGanondorf(new Location(10,13,0)));
        entities.add(makeGuard(new Location(11,12,0)));

        entities.add(makeHellCat());

        return entities;
    }
}
