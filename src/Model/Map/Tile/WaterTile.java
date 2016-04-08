package Model.Map.Tile;

import Model.Entity.Entity;
import Model.Map.Tile.TileStrategy.AquaticTileStrategy;

/**
 * Created by sgl on 4/5/16.
 */


public class WaterTile extends MobileTile {


    public WaterTile(){
        super(new AquaticTileStrategy());
    }

    @Override
    public void moveAquatic(Entity entity){
        this.entity = entity;
    }

    @Override
    public void moveBoat(Entity entity){
        this.entity = entity;
    }
}
