package Model.Map.Tile;

import Model.Map.Tile.TileStrategy.AquaticTileStrategy;

/**
 * Created by sgl on 4/5/16.
 */

public class WaterTile extends MobileTile {


    public WaterTile(){
        super(new AquaticTileStrategy());
    }
}
