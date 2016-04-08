package Model.Map.Tile;

import Model.Map.Tile.TileStrategy.DirtTileStrategy;

/**
 * Created by sgl on 4/5/16.
 */

//DirtTile is just tells Nav that the Tile could not be travelled by. (doesn't hold a handle of entity)
public class DirtTile extends Tile {

    public DirtTile(){
        super(new DirtTileStrategy());
    }


}
