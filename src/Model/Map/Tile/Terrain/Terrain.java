package Model.Map.Tile.Terrain;

import Model.Entity.Character.Character;
import Model.Map.Map;
import Utilities.Visitor.TerrainVisitable;

/**
 * Created by dyeung on 4/15/16.
 */
public abstract class Terrain implements TerrainVisitable {
    //All of these terrains unless otherwise overwritten will not return true

    public void onInteract(Map map, Character character) {
        // do nothin
    }
}
