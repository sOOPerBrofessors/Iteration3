package Model.Map.Tile;

import Model.Entity;
import Model.Map.Tile.TileStrategy.TileStrategy;

/**
 * Created by sgl on 4/5/16.
 */

//MobileTile can hold a single entity
public class MobileTile extends Tile{
    private Entity entity;

    public MobileTile(TileStrategy tileStrategy){
        super(tileStrategy);
        entity = null;
    }



}


