package Model.Map;

import Model.Map.Tile.Tile;
import Model.Model;

import java.util.ArrayList;

/**
 * Created by sgl on 4/5/16.
 */
public class Map {

    public Map(TileColumn[][] tiles){
        mapOfTiles = tiles;
    }
    //Going to change this to array list with an array list of objects (instead of confusing 3d array)
    //private Tile[][][] mapOfTiles;
    private TileColumn[][] mapOfTiles;

    //For loading -- might need some version of design pattern to get rid of this
    public TileColumn[][] getMapOfTiles(){
        return mapOfTiles;
    }

    public Tile getTile(Location location) {
        return mapOfTiles[location.getX()][location.getY()].getTileList().get(0);
    } // end getTile
}
