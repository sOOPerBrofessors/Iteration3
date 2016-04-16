package Utilities.Navigation.NavStrategy;

import Model.Entity.Entity;
import Model.Map.Tile.Tile;

/**
 * Created by broskj on 4/5/16.
 */
public class VehicleStrategy extends NavStrategy {
    @Override
    public boolean move(Tile targetTile, Entity entity) {
        return false; ///targetTile.moveVehicle(entity);
    }

    public boolean canMove(Tile targetTile) {

        return false; //targetTile.canMoveVehicle();

    }

    @Override
    public void visitGrassTerrain() {
        canMoveFlag = true;
    }
}
