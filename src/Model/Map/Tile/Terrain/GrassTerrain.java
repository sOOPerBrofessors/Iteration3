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




}
