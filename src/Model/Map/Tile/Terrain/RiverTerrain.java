package Model.Map.Tile.Terrain;


import Utilities.Visitor.TerrainVisitor;

/**
 * Created by sgl on 4/5/16.
 */
public class RiverTerrain extends WaterTerrain {
    private int flowRate;
    private int direction;

    public RiverTerrain(){
    }

    private boolean movePlayer(){
        //entity.move(direction);
        return true;
    }

    @Override
    public void acceptTerrainVisitor(TerrainVisitor tv) {
        tv.visitRiverTerrain();
    }
}
