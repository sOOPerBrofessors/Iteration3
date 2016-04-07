package Model.Map;

import Model.Map.Tile.Tile;

import java.util.ArrayList;

/**
 * Created by dyeung on 4/6/16.
 */
public class TileColumn {
    ArrayList<Tile> tileList;
    public TileColumn(){
        tileList = new ArrayList<>();
    }
    public void addTiles(Tile tile){
        if (tileList.size() < 10) {
            tileList.add(tile);
        }else {
            System.out.println("TileColumn is full, need to delete first");
        }
    }
    public ArrayList<Tile> getTileList(){
        return tileList;
    }
}
