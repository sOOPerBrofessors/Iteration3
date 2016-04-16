package Model.Map;

import Model.Entity.Character.Character;
import Model.Entity.Entity;
import Model.Map.AreaEffect.AreaOfEffect;
import Model.Map.Tile.Tile;

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

    //MAP movement for character (This will only walk on the top of the characters, will most likely
    //need a separate move for fishes that swim below or birds that go above
    public boolean moveCharacter(Character character, Location newLocation){
        int currentZ = character.getZ();
        int newX = newLocation.getX();
        int newY = newLocation.getY();
        int newZ = getTopTilePosition(newX, newY);
        if (checkBounds(newX, newY) && checkHeightDifference(currentZ, newZ) && getTopTile(newX,newY).moveCharacter(character)) {
            //Map needs to handle removement of the current entity on that tile.
            getTileAt(character.getX(), character.getY(), character.getZ()).removeEntity();
            character.updateLocation(new Location(newX, newY, newZ));
            return true;
        }else{
            return false;
        }

    }
    private boolean checkHeightDifference(int current, int target){
        if ((target - current) <= 1){
            return true;
        }else{
            return false;
        }
    }





    //Other stuff for map
    public boolean checkBounds(int x, int y){
        if (x < 0 || y < 0 || x >= maxColumn || y >= maxRow) {
            return false;
        }else {
            return true;
        }
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


    //FOR LOADING IN MAP OBJECTS (ENTITY/ITEM)
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

    public void addAOE(AreaOfEffect areaOfEffect, Location location){
        int x = location.getX();
        int y = location.getY();
        //int z = location.getZ();
        getTopTile(x,y).addAOE(areaOfEffect);
    }
}
