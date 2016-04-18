package Model.Entity.Character.Mount;

import Model.Entity.Character.Character;
import Model.Entity.Entity;
import Model.Map.Location;
import Model.Map.Tile.Terrain.Terrain;
import Model.Stats.EntityStats;
import Utilities.Navigation.Navigation;
import Utilities.Tickable;
import Utilities.Visitor.CharacterVisitor;

/**
 * Created by Wimberley on 4/6/16.
 */

//For now this will only contain this stuff (might implement more later)
public abstract class Mount extends Entity{

    protected Character passenger;
    protected int delay;
    protected boolean canMove;
    protected EntityStats stats;

    protected Mount(Navigation navigation, Location location){
        super(navigation, location);
        delay = 1500 / stats.getMovement();
        canMove = true;
    }

    protected void addPassenger(Character passenger){
        this.passenger = passenger;
    }

    protected void removePassenger(){

    }

    public boolean checkStrategy(Terrain terrain){
        return navigation.canMove(terrain);
    }
}