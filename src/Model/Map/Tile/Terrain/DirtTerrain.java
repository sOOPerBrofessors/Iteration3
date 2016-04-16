package Model.Map.Tile.Terrain;


import Utilities.Visitor.TerrainVisitor;

/**
 * Created by sgl on 4/5/16.
 */

//DirtTerrain is just tells Nav that the Tile could not be travelled by. (doesn't hold a handle of entity)
public class DirtTerrain extends Terrain {
    @Override
    public void acceptTerrainVisitor(TerrainVisitor tv) {
        tv.visitDirtTerrain();
    }
}
