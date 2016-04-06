package Model.Map.Tile;

import Model.Map.Tile.TileStrategy.TileStrategy;

/**
 * Created by sgl on 4/5/16.
 */
public abstract class Tile {

    private TileStrategy tileStrategy;

    public Tile(TileStrategy tileStrategy){
        this.tileStrategy = tileStrategy;
    }

    public void moveAvian(){

    }

    public void moveAquatic(){

    }

    public  void moveBoat(){

    }

    public void moveChar(){

    }

    public void moveProjectile(){

    }

    public void moveVehicle(){

    }



}
