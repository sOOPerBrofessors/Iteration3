package Model.Map.Tile;

import Model.Map.Tile.TileStrategy.RiverTileStrategy;

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
}
