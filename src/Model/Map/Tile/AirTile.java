package Model.Map.Tile;

import Model.Entity.Entity;

/**
 * Created by sgl on 4/5/16.
 */

//contains AirTileStrategy --> birds can fly here
public class AirTile extends MobileTile {

    public AirTile(){
    }

    @Override
    public void moveAvian(Entity entity) {
        super.entity = entity;
    }


}
