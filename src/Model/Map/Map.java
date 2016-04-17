package Model.Map;

import Model.Entity.Character.Character;
import Model.Entity.Entity;
import Model.Map.Tile.Tile;
import Utilities.AIStuff.Pathfinding.TileLocationTuple;

import java.util.HashSet;

/**
 * Created by sgl on 4/5/16.
 */
public class Map {

    private static int maxRow;
    private static int maxColumn;

    public Map(TileColumn[][] tiles){
        mapOfTiles = tiles;
        maxRow = tiles.length;
        maxColumn = tiles[0].length;
    }

    private static TileColumn[][] mapOfTiles;

    public Tile getTile(Location location) {

        return getTileAt(location.getX(), location.getY(), location.getZ());

    }

    public Tile getTopTile(int x, int y) {
        //TODO: Needs some better checks for height difference
        //might be more helpful to add more defining functions withing 'TileColumn' to check for height
        if (x < 0 || y < 0 || x >= maxColumn || y >= maxRow) {
            return null;
        }else {
            return mapOfTiles[x][y].getTopTile();
        }
    } // end getTile

    public static int getTopTilePosition(int x, int y) {
        //TODO: Needs some better checks for height difference
        //might be more helpful to add more defining functions withing 'TileColumn' to check for height
        if (x < 0 || y < 0 || x >= maxColumn || y >= maxRow) {
            return -1;
        }else {
            return mapOfTiles[x][y].getTopPosition();
        }
    } // end getTile

    public Tile getTileNeighbor(int x, int y, int z, Orientation orientation) {

        return getTileTupleNeighbor(x, y, z, orientation).getTile();

    }

    public TileLocationTuple getTileTupleNeighbor(int x, int y, int z, Orientation orientation) {

        int newX = x + orientation.x;
        int newY = y + orientation.y;
        Tile topTile = getTopTile(newX, newY);
        int nextZ = getTopTilePosition(newX, newY) - 1;
        int difference = nextZ - z;

        if (difference <= 1) {

            return new TileLocationTuple(topTile, new Location(newX, newY, nextZ));

        }

        // We don't want to consider tiles with a significant height difference neighbors so that pathfinding works well.
        return null;

    }

    public HashSet<TileLocationTuple> getTileNeighbors(int x, int y, int z) {

        HashSet<TileLocationTuple> neighbors = new HashSet<>();

        for (Orientation orientation : Orientation.values()) {

            neighbors.add(getTileTupleNeighbor(x, y, z, orientation));

        }

        return neighbors;

    }

    public TileColumn getTileColumn(int x, int y){
        if (x < 0 || y < 0 || x >= maxColumn || y >= maxRow) {
            return null;
        }else {
            return mapOfTiles[x][y];
        }
    }
    public Tile getTileAt(int x, int y, int z){
        if (x < 0 || y < 0 || x >= maxColumn || y >= maxRow) {
            return null;
        }else {
            return mapOfTiles[x][y].getTileAt(z);
        }
    }
    //Accessor methods to tileColumns
    public int getMaxRow(){
        return maxRow;
    }
    public int getMaxColumn(){
        return maxColumn;
    }


    //FOR LOADING
    //Entities include projectile things that could be anywhere on 3d axis
    public void addEntity(Entity entity){
        mapOfTiles[entity.getX()][entity.getY()].addEntity(entity);
    }

    //Characters are essentially things that exist on the top of group types
    public void addCharacter(Character character){
        mapOfTiles[character.getX()][character.getY()].addCharacter(character);
    }

    public void removeEntity(Entity entity){
        mapOfTiles[entity.getX()][entity.getY()].removeEntity(entity);
    }
}
