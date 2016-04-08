package Model.Map.Tile;

import Model.Map.Location;
import Model.Map.Tile.TileStrategy.RiverTileStrategy;
import Utilities.Visitor.TileVisitor;
import View.TerrainView.TileView;

/**
 * Created by sgl on 4/5/16.
 */
public class RiverTile extends MobileTile {
    private int flowRate;
    private int direction;

    public RiverTile(){
        super(new RiverTileStrategy()); //Is this necessary or will the waterTile Strategy cover everything??
    }

    private void movePlayer(){
        //entity.move(direction);
    }

    @Override
    public TileView acceptTileVisitor(TileVisitor tv, Location location) {
        return tv.createAirTile(location);
    }
}
