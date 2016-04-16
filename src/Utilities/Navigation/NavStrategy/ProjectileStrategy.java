package Utilities.Navigation.NavStrategy;

import Model.Entity.Entity;
import Model.Map.Tile.Tile;

/**
 * Created by broskj on 4/5/16.
 */
public class ProjectileStrategy extends NavStrategy {
    @Override
    public boolean move(Tile targetTile, Entity entity) {
        return false; //targetTile.moveProjectile(entity);
    }

    @Override
    public void visitWaterTerrain() {
        canMoveFlag = true;
    }

    @Override
    public void visitGrassTerrain() {
        canMoveFlag = true;
    }

    @Override
    public void visitAirTerrain() {
        canMoveFlag = true;
    }

    @Override
    public void visitRiverTerrain() {
        canMoveFlag = true;
    }
}
