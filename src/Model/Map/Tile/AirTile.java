package Model.Map.Tile;

import Model.Map.Location;
import Model.Map.Tile.TileStrategy.AvianTileStrategy;
import Utilities.Visitor.TileVisitor;
import View.TerrainView.TileView;

/**
 * Created by sgl on 4/5/16.
 */

//contains AirTileStrategy --> birds can fly here
public class AirTile extends MobileTile {

    public AirTile(){
        super(new AvianTileStrategy());
    }

    @Override
    public TileView acceptTileVisitor(TileVisitor tv, Location location) {
        return tv.createAirTile(location);
    }


}
