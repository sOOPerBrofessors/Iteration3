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

    @Override
    public void acceptTileVisitor(TileVisitor tv) {
         tv.createAirTile(this);
    }

    public boolean moveAvian(Entity entity) {
        //if (super.entity!= null) return false;
        super.entity = entity;
        notifyObservers();
        return true;
    }

    public boolean canMoveAvian() {
        return super.entity == null;
    }

}
