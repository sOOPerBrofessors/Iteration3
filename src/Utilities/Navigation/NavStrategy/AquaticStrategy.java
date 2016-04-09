package Utilities.Navigation.NavStrategy;

import Model.Entity.Entity;
import Model.Map.Tile.Tile;

/**
 * Created by broskj on 4/5/16.
 */
public class AquaticStrategy implements NavStrategy {
    @Override
    public boolean move(Tile targetTile, Entity entity) {
        return targetTile.moveAquatic(entity);
    }
}
