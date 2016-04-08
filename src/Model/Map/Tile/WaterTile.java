package Model.Map.Tile;

import Model.Map.Location;
import Model.Map.Tile.TileStrategy.AquaticTileStrategy;
import Utilities.Visitor.TileVisitor;
import View.TerrainView.TileView;

/**
 * Created by sgl on 4/5/16.
 */

public class WaterTile extends MobileTile {


    public WaterTile(){
        super(new AquaticTileStrategy());
    }

    @Override
    public TileView acceptTileVisitor(TileVisitor tv, Location location) {
        return tv.createWaterTile(location);
    }
}
