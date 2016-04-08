package Model.Map.Tile;

import Model.Entity.Entity;
import Model.Map.Tile.TileStrategy.TileStrategy;
import Utilities.MessageHandler;

/**
 * Created by sgl on 4/5/16.
 */
public abstract class Tile {

    protected TileStrategy tileStrategy;

    public Tile(TileStrategy tileStrategy){
        this.tileStrategy = tileStrategy;
    }

    public void moveAvian(Entity entity){
        MessageHandler.printError("You cannot move to this tile.");
    }

    public void moveAquatic(Entity entity){
        MessageHandler.printError("You cannot move to this tile.");
    }

    public void moveBoat(Entity entity){
        MessageHandler.printError("You cannot move to this tile.");
    }

    public void moveChar(Entity entity){
        MessageHandler.printError("You cannot move to this tile.");
    }

    public void moveProjectile(Entity entity){
        MessageHandler.printError("You cannot move to this tile.");
    }

    public void moveVehicle(Entity entity){
        MessageHandler.printError("You cannot move to this tile.");
    }



}
