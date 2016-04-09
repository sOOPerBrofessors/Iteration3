package Model.Map;

import Model.Entity.Entity;
import Model.Map.Tile.AirTile;
import Model.Map.Tile.GrassTile;
import Model.Map.Tile.Tile;
import Model.Map.Tile.WaterTile;
import Utilities.Visitor.ColumnVisitable;
import Utilities.Visitor.ColumnVisitor;
import View.MapView.MapObjectView;

import java.util.ArrayList;

/**
 * Created by dyeung on 4/6/16.
 */
public class TileColumn implements ColumnVisitable{
    ArrayList<Tile> tileList;

    private int topTile;
    private int topWater; //Maybe necessary?

    ArrayList<MapObject> objectList; //This needs to include items some how (might have to change this to like every single object)

    public TileColumn(){
        topTile = 0;
        topWater = 0;
        tileList = new ArrayList<>();
        objectList = new ArrayList<>();
    }

    public void addMapObjects (MapObject mapObject) {
        objectList.add(mapObject);
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

    public Tile getTopTile(){
        return tileList.get(topTile - 1);
    }
    public int getTopPosition(){
        return topTile;
    }
    public ArrayList<MapObject> getObjectList() {
        return objectList;
    }

    @Override
    public ArrayList<MapObjectView> acceptMapVisitor(ColumnVisitor columnVisitor) {
        //TODO: something like
        ArrayList<MapObjectView> objects = new ArrayList<>();
        for (MapObject mapObjects : objectList){
            objects.add(mapObjects.acceptMapVisitor(columnVisitor));
        }
        return objects;
    }

    public void removeMapObject(MapObject mapObject){
        objectList.remove(mapObject);
    }
}
