package Model.Entity.Character.NPC;

import Controller.AI_Controller.AI_Controller;
import Controller.AI_Controller.Brain;
import Controller.AI_Controller.Personality.Personality;
import Model.Entity.Character.Character;
import Model.Entity.Character.Occupation.Occupation;
import Model.Faction.Faction;
import Model.Map.Location;
import Utilities.Tickable;
import Utilities.Visitor.EntityViewVisitor;

/**
 * Created by Wimberley on 4/9/16.
 */
public class NPC extends Character implements Tickable{

    private Brain brain;
    private Faction faction;
    private Personality personality;
    AI_Controller controller;

    public NPC(Occupation o, Location location, Personality personality, Faction faction) {
        super(o, location);
        this.faction = faction;
        this.personality = personality;
    }

    @Override
    public void tick(){
        brain.tick();
    }

    public void setController(AI_Controller controller) {

        this.controller = controller;

    }

    public AI_Controller getController() {

        return controller;

    }

    /*public static NPC makeEnemy(){
        return new NPC(new Smasher(), new Location(1,1,0), new Personality("Ganondorf", ), )
    }*/


    @Override
    public void update() {

    }

    @Override
    public void remove() {

    }

    public Personality getPersonality(){
        return personality;
    }

    public void setBrain(Brain brain){
        this.brain = brain;
    }

    @Override
    public void acceptEntityVisitor(EntityViewVisitor entityViewVisitor) {
        entityViewVisitor.createNPCView(this);
    }
}
