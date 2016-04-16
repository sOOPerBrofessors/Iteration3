package Model.Map.Tile.Terrain;

import Utilities.Visitor.TerrainVisitor;

/**
 * Created by sgl on 4/5/16.
 */

//This tile can hold LandEntities and items
public class GrassTerrain extends Terrain{


    public GrassTerrain(){
    }

    @Override
    public void acceptTerrainVisitor(TerrainVisitor tv) {
        tv.visitGrassTerrain();
    }


    //    @Override
//    public void acceptTileVisitor(TerrainVisitor tv) {
//        //TODO: ADD ITEM STUFF
//        tv.visitGrassTile(this);
//    }
//
//    public boolean moveChar(Entity entity){
//
//        if(super.entity == null) {
//            super.entity = entity;
//            notifyObservers();
//            //I guess we also need to notify that there are effects within the tiles
//            return true;
//        } else {
//            super.moveChar(entity);
//            return false;
//        }
//    }
//
//    public boolean canMoveChar() {
//        return super.entity == null;
//    }



}
