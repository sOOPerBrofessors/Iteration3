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

    public boolean moveAvian(Entity entity){
        MessageHandler.printError("You cannot move to this tile.");
        return false;
    }

    public boolean moveAquatic(Entity entity){
        MessageHandler.printError("You cannot move to this tile.");
        return false;
    }

    public boolean moveBoat(Entity entity){
        MessageHandler.printError("You cannot move to this tile.");
        return false;
    }

    public boolean moveChar(Entity entity){
        MessageHandler.printError("You cannot move to this tile.");
        return false;
    }

    public boolean moveProjectile(Entity entity){
        MessageHandler.printError("You cannot move to this tile.");
        return false;
    }

    public boolean moveVehicle(Entity entity){
        MessageHandler.printError("You cannot move to this tile.");
        return false;
    }

    public abstract TileView acceptTileVisitor(TileVisitor tv);


}
