package Model.Map.Tile;

import Model.Map.Tile.TileStrategy.AvianTileStrategy;

/**
 * Created by sgl on 4/5/16.
 */

//contains AirTileStrategy --> birds can fly here
public class AirTile extends MobileTile {

    public AirTile(){
        super(new AvianTileStrategy());
    }
}
