package Model.Map.Tile;

import Model.Entity.Entity;

/**
 * Created by sgl on 4/5/16.
 */


public class WaterTile extends MobileTile {


    public WaterTile(){
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
