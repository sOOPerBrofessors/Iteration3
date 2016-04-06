package Model.Map;

import Model.Map.Tile.Tile;
import Model.Model;

/**
 * Created by sgl on 4/5/16.
 */
public class Map {
    //Data needs to be changed to avatar position
    private int data;
    public Map(){
        data = 0;
    }
    private Tile[][][] mapOfTiles;

    public int getData(){
        return data;
    }
}
