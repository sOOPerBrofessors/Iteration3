package Utilities.Navigation.NavStrategy;

import Model.Entity.Entity;
import Model.Map.Tile.Tile;

/**
 * Created by broskj on 4/5/16.
 */
public class AquaticStrategy extends NavStrategy {
    @Override
    public boolean move(Tile targetTile, Entity entity) {
        return false;//targetTile.moveAquatic(entity);
    }

    public boolean canMove(Tile targetTile) {

        return false;//targetTile.canMoveAquatic();

    }

    @Override
    public void visitRiverTerrain() {
        canMoveFlag = true;
    }

    @Override
    public void visitWaterTerrain() {
        canMoveFlag = true;
    }
}
