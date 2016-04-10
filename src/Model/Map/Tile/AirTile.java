package Model.Map.Tile;

import Model.Map.Location;
import Utilities.Visitor.TileVisitor;
import View.TerrainView.TileView;
import Model.Entity.Entity;

/**
 * Created by sgl on 4/5/16.
 */

//contains AirTileStrategy --> birds can fly here
public class AirTile extends MobileTile {

    public AirTile(){
    }

    @Override
    public void acceptTileVisitor(TileVisitor tv) {
         tv.createAirTile(this);
    }
    public boolean moveAvian(Entity entity) {
        super.entity = entity;
        return true;
    }


}
