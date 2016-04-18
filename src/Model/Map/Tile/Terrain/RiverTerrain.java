package Model.Map.Tile.Terrain;


import Model.Entity.Character.Character;
import Model.Map.Map;
import Model.Map.Orientation;
import Utilities.Visitor.TerrainVisitor;

/**
 * Created by sgl on 4/5/16.
 */
public class RiverTerrain extends WaterTerrain {
    private int flowRate;
    private Orientation direction;



    public RiverTerrain(){
        flowRate = 10;
        direction = Orientation.SOUTH;
    }

    private boolean movePlayer(){
        //entity.move(direction);
        return true;
    }

    @Override
    public void onInteract(Map map, Character character) {
        character.setOrientation(direction);
        //character.setDelay(flowRate);
        //character.move(map, direction);
        //map.moveCharacter(character, map.ge)
    }

    @Override
    public void acceptTerrainVisitor(TerrainVisitor tv) {
        tv.visitRiverTerrain();
    }
}
