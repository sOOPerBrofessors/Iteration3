package Model.Map.Tile;

import Model.Map.Location;
import Model.Entity.Entity;
import Utilities.MessageHandler;
import Utilities.Visitor.TileVisitor;
import View.TerrainView.TileView;

/**
 * Created by sgl on 4/5/16.
 */
public abstract class Tile {


    public Tile(){

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

    public abstract TileView acceptTileVisitor(TileVisitor tv, Location location);


}
