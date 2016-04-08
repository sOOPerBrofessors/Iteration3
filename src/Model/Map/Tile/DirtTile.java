package Model.Map.Tile;

import Model.Map.Location;
import Model.Map.Tile.TileStrategy.DirtTileStrategy;
import Utilities.Visitor.TileVisitor;
import View.TerrainView.TileView;

/**
 * Created by sgl on 4/5/16.
 */

//DirtTile is just tells Nav that the Tile could not be travelled by. (doesn't hold a handle of entity)
public class DirtTile extends Tile {

    public DirtTile(){
        super(new DirtTileStrategy());
    }


    @Override
    public TileView acceptTileVisitor(TileVisitor tv, Location location) {
        //tv.createAirTile(location)
        //TODO: CHANGE THIS TO GROUND TILE
        return tv.createGrassTile(location);
    }
}
