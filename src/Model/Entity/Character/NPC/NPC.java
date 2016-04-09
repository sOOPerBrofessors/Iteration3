package Model.Entity.Character.NPC;

import Controller.AI_Controller.Brain;
import Controller.AI_Controller.Personality.Personality;
import Model.Entity.Character.Character;
import Model.Entity.Character.Occupation.Occupation;
import Model.Entity.Character.Occupation.Smasher;
import Model.Faction.Faction;
import Model.Map.Location;
import Utilities.Tickable;
import Utilities.Visitor.ColumnVisitor;
import View.MapView.MapObjectView;

/**
 * Created by Wimberley on 4/9/16.
 */
public class NPC extends Character implements Tickable{

    private Brain brain;
    private Faction faction;
    private Personality personality;

    private NPC(Occupation o, Location location, Personality personality, Faction faction) {
        super(o, location);
        this.faction = faction;
        this.personality = personality;
    }

    @Override
    public void tick(){
        brain.tick();
    };

    /*public static NPC makeEnemy(){
        return new NPC(new Smasher(), new Location(1,1,0), new Personality("Ganondorf", ), )
    }*/

    @Override
    public MapObjectView acceptMapVisitor(ColumnVisitor columnVisitor) {
        return null;
    }

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
}
