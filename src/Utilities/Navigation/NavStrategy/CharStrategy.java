package Utilities.Navigation.NavStrategy;

import Model.Entity.Entity;
import Model.Map.Tile.Tile;

/**
 * Created by broskj on 4/5/16.
 */
public class CharStrategy extends NavStrategy {
    @Override
    public boolean move(Tile targetTile, Entity entity) {
        return true; //targetTile.moveChar(entity);
    }

    @Override
    public void visitGrassTerrain() {
        canMoveFlag = true;
    }
}
