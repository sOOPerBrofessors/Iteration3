package Utilities.AIStuff;

import Controller.AI_Controller.Brain;
import Controller.AI_Controller.Personality.Personality;
import Controller.AI_Controller.Personality.PersonalityFactory;
import Model.Entity.Character.Character;
import Model.Entity.Character.NPC.NPC;
import Model.Entity.Character.Occupation.Smasher;
import Model.Entity.Entity;
import Model.Faction.Faction;
import Model.Faction.FactionFactory;
import Model.Map.Location;

import java.util.ArrayList;

/**
 * Created by Wimberley on 4/9/16.
 */
public class NPCFactory {

    public static NPC makeGanondorf(){
        Personality personality = PersonalityFactory.getPersonality("enemy");
        Faction faction = FactionFactory.getFaction("red");
        NPC gandorf = new NPC(new Smasher(), new Location(1,1,0), personality, faction);
        Brain brain = new Brain(gandorf);
        gandorf.setBrain(brain);
        return gandorf;
    }

    public static ArrayList<Entity> init(){
        ArrayList<Entity> entities = new ArrayList<>();

        entities.add(makeGanondorf());

        return entities;
    }
}
