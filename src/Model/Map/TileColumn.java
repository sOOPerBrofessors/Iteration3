package Model.Map;

import Model.Map.Tile.AirTile;
import Model.Map.Tile.GrassTile;
import Model.Map.Tile.Tile;
import Model.Map.Tile.WaterTile;

import java.util.ArrayList;

/**
 * Created by dyeung on 4/6/16.
 */
public class TileColumn {
    ArrayList<Tile> tileList;
    private int topTile;
    private int topWater; //Maybe necessary?
    public TileColumn(){
        topTile = 0;
        topWater = 0;
        tileList = new ArrayList<>();
    }


    public void addTiles(AirTile tile){
        if (tileList.size() < 10) {
            tileList.add(tile);
        }else {
            System.out.println("TileColumn is full, need to delete first");
        }
    }
    public void addTiles(WaterTile tile){
        if (tileList.size() < 10) {
            topTile++;
            tileList.add(tile);
        }else {
            System.out.println("TileColumn is full, need to delete first");
        }
    }
    public void addTiles(GrassTile tile){
        if (tileList.size() < 10) {
            topTile++;
            tileList.add(tile);
        }else {
            System.out.println("TileColumn is full, need to delete first");
        }
    }
    public ArrayList<Tile> getTileList(){
        return tileList;
    }

    public Tile getTop(){
        return tileList.get(topTile);
    }
}
