package Model.Map.Tile;


import Model.Map.Location;
import Utilities.Visitor.TileVisitor;
import View.TerrainView.TileView;
import Model.Entity.Entity;

/**
 * Created by sgl on 4/5/16.
 */


public class WaterTile extends MobileTile {


    public WaterTile(){
    }

    @Override
    public boolean moveAquatic(Entity entity){
        this.entity = entity;
        return true;
    }

    @Override
    public boolean moveBoat(Entity entity){
        this.entity = entity;
        return true;
    }

    @Override
    public TileView acceptTileVisitor(TileVisitor tv, Location location) {
        return tv.createWaterTile(location);
    }
}
