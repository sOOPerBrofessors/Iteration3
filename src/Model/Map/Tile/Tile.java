package Model.Map.Tile;

import Model.Entity.Entity;
import Utilities.ErrorLevel;
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
        MessageHandler.println("You cannot move to this tile.", ErrorLevel.ERROR);
        return false;
    }

    public boolean moveAquatic(Entity entity){
        MessageHandler.println("You cannot move to this tile.", ErrorLevel.ERROR);
        return false;
    }

    public boolean moveBoat(Entity entity){
        MessageHandler.println("You cannot move to this tile.", ErrorLevel.ERROR);
        return false;
    }

    public boolean moveChar(Entity entity){
        MessageHandler.println("You cannot move to this tile.", ErrorLevel.ERROR);
        return false;
    }

    public boolean moveProjectile(Entity entity){
        MessageHandler.println("You cannot move to this tile.", ErrorLevel.ERROR);
        return false;
    }

    public boolean moveVehicle(Entity entity){
        MessageHandler.println("You cannot move to this tile.", ErrorLevel.ERROR);
        return false;
    }

    public abstract TileView acceptTileVisitor(TileVisitor tv);


}
