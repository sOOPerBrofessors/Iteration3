package Model.Map.Tile.Terrain;

import Utilities.Visitor.TerrainVisitor;

/**
 * Created by sgl on 4/5/16.
 */

//contains AirTileStrategy --> birds can fly here
public class AirTerrain extends Terrain {
    @Override
    public void acceptTerrainVisitor(TerrainVisitor tv) {
        tv.visitAirTerrain();
    }
//    @Override
//    public void acceptTileVisitor(TerrainVisitor tv) {
//         tv.visitAirTile(this);
//    }
//
//    public boolean moveAvian(Entity entity) {
//        //if (super.entity!= null) return false;
//        super.entity = entity;
//        notifyObservers();
//        return true;
//    }
//
//    public boolean canMoveAvian() {
//        return super.entity == null;
//    }

}
