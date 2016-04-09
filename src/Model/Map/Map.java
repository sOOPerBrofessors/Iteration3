package Model.Map;

import Model.Map.Tile.Tile;
import Model.Model;

import java.util.ArrayList;

/**
 * Created by sgl on 4/5/16.
 */
public class Map {
    private int maxRow;
    private int maxColumn;
    public Map(TileColumn[][] tiles){
        mapOfTiles = tiles;
        maxRow = tiles.length;
        maxColumn = tiles[0].length;
    }
    private TileColumn[][] mapOfTiles;

    //For loading -- might need some version of design pattern to get rid of this
    public TileColumn[][] getMapOfTiles(){
        return mapOfTiles;
    }

    public Tile getTopTile(int x, int y) {
        //TODO: Needs some better checks for height difference
        //might be more helpful to add more defining functions withing 'TileColumn' to check for height
        if (x < 0 || y < 0 || x > maxColumn || y > maxRow) {
            return null;
        }else {
            return mapOfTiles[x][y].getTopTile();
        }
    } // end getTile
}
