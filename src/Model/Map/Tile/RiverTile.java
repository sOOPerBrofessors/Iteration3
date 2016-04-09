package Model.Map.Tile;

import Model.Map.Location;
import Utilities.Visitor.TileVisitor;
import View.TerrainView.TileView;


/**
 * Created by sgl on 4/5/16.
 */
public class RiverTile extends WaterTile {
    private int flowRate;
    private int direction;

    public RiverTile(){
    }

    private boolean movePlayer(){
        //entity.move(direction);
        return true;
    }

    @Override
    public TileView acceptTileVisitor(TileVisitor tv) {
        return tv.createAirTile();
    }
}
