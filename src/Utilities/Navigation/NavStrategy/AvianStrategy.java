package Utilities.Navigation.NavStrategy;

import Model.Entity.Entity;
import Model.Map.Tile.Tile;

/**
 * Created by broskj on 4/5/16.
 */
public class AvianStrategy extends NavStrategy {
    @Override
    public boolean move(Tile targetTile, Entity entity) {
        //return targetTile.moveAvian(entity);
        return false;
    }

    @Override
    public void visitAirTerrain() {
        canMoveFlag = true;
    }
}
