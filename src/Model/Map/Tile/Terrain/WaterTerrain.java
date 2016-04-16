package Model.Map.Tile.Terrain;


import Utilities.Visitor.TerrainVisitor;

/**
 * Created by sgl on 4/5/16.
 */


public class WaterTerrain extends Terrain {


    public WaterTerrain(){
    }

    @Override
    public void acceptTerrainVisitor(TerrainVisitor tv) {
        tv.visitWaterTerrain();
    }
    //    @Override
//    public boolean moveAquatic(Entity entity){
//        this.entity = entity;
//        notifyObservers();
//        return true;
//    }
//
//    @Override
//    public boolean moveBoat(Entity entity){
//        //if (super.entity!= null) return false;
//        this.entity = entity;
//        notifyObservers();
//        return true;
//    }
//
//    public boolean canMoveAquatic() {
//        return super.entity == null;
//    }
//
//    public boolean canMoveBoat() {
//        return super.entity == null;
//    }
//
//    @Override
//    public void acceptTileVisitor(TerrainVisitor tv) {
//         tv.visitWaterTile(this);
//    }
}
