package Model.Map.Tile;

import Model.Map.Tile.TileStrategy.TileStrategy;
import Utilities.MessageHandler;

/**
 * Created by sgl on 4/5/16.
 */
public abstract class Tile {

    private TileStrategy tileStrategy;

    public Tile(TileStrategy tileStrategy){
        this.tileStrategy = tileStrategy;
    }

    public void moveAvian(){
        MessageHandler.printError("You cannot move to this tile.");
    }

    public void moveAquatic(){
        MessageHandler.printError("You cannot move to this tile.");
    }

    public  void moveBoat(){
        MessageHandler.printError("You cannot move to this tile.");
    }

    public void moveChar(){
        MessageHandler.printError("You cannot move to this tile.");
    }

    public void moveProjectile(){
        MessageHandler.printError("You cannot move to this tile.");
    }

    public void moveVehicle(){
        MessageHandler.printError("You cannot move to this tile.");
    }



}
