package Model.Map;

import Model.Entity.Character.Character;
import Model.Map.AreaEffect.AreaOfEffect;
import Model.Map.Tile.Tile;
import Model.Entity.Projectile.Projectile;
import Utilities.ItemStuff.ItemManager;

/**
 * Created by sgl on 4/5/16.
 */
public class Map {

    private int maxRow;
    private int maxColumn;
    private ItemManager itemManager;

    public Map(TileColumn[][] tiles){
        mapOfTiles = tiles;
        maxRow = tiles.length;
        maxColumn = tiles[0].length;
    }

    public void addItemManager(ItemManager itemManager) {
        this.itemManager = itemManager;
    } // end addItemManager

    private TileColumn[][] mapOfTiles;

    //MAP movement for character (This will only walk on the top of the characters, will most likely
    //need a separate move for fishes that swim below or birds that go above
    public boolean moveCharacter(Character character, Location newLocation){
        int currentX = character.getX();
        int currentY = character.getY();
        int currentZ = character.getZ();
        int newX = newLocation.getX();
        int newY = newLocation.getY();
        int newZ = getTopTilePosition(newX, newY);
        Tile newTile = getTopTile(newX,newY);
        Location location = character.getLocation();
        //Needs to move the character before the tile does interaction because of "teleport" effect
        if (checkCanInteractWithTile(location, newLocation)
                && !checkHasObstacle(newLocation)
                && newTile.moveCharacter(character)){
            getTileAt(currentX, currentY, currentZ).removeCharacter();
            character.updateLocation(new Location(newX,newY,newZ));
            newTile.doTileEffects(character); //does the interaction
            return true;
        }else{
            return false;
        }

    }

    public boolean moveProjectile(Projectile projectile, Location newLocation){
        int currentX = projectile.getX();
        int currentY = projectile.getY();
        int currentZ = projectile.getZ();
        int newX = newLocation.getX();
        int newY = newLocation.getY();
        int newZ = getTopTilePosition(newX, newY);
        Tile newTile = getTopTile(newX,newY);
        Location location = projectile.getLocation();
        //Needs to move the character before the tile does interaction because of "teleport" effect
        if (checkCanInteractWithTile(location, newLocation)
                && !checkHasObstacle(newLocation)
                && newTile.moveProjectile(projectile);){
            getTileAt(currentX, currentY, currentZ).removeCharacter();
            projectile.updateLocation(new Location(newX,newY,newZ));
            newTile.doTileEffects(projectile); //does the interaction
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

    public void checkTileInteraction(Character character, Location currentLocation, Location newLocation){
        if (checkCanInteractWithTile(currentLocation, newLocation)){
            getTopTile(newLocation.getX(), newLocation.getY()).doInteractionsNPC(character);
        }
    }
    //This function basically checks if the tile is applicable for interactions (IE only 1 tile away and above you)
    //New Location only needs an x and a y no Z is necessary
    private boolean checkCanInteractWithTile(Location currentLocation, Location newLocation){
        int currentZ = currentLocation.getZ();
        int newX = newLocation.getX();
        int newY = newLocation.getY();
        int newZ = getTopTilePosition(newX, newY);

        if (checkBounds(newX, newY) && checkHeightDifference(currentZ, newZ)){
            return true;
        }else{
            return false;
        }
    }

    private boolean checkHasObstacle(Location newLocation) {
        return itemManager.tileContainsObstacle(newLocation);
    } // end checkHasObstacle





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

    public int getTopTilePosition(int x, int y) {
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
    //Characters are essentially things that exist on the top of group types
    public void addCharacter(Character character){
        mapOfTiles[character.getX()][character.getY()].addCharacter(character);
    }

    public void removeCharacter(Character character){
        mapOfTiles[character.getX()][character.getY()].removeCharacter(character);
    }

    // All about them projectiles bro
    public void addProjectile(Projectile projectile){
        mapOfTiles[projectile.getX()][projectile.getY()].addProjectile(projectile);
    }

    public void addAOE(AreaOfEffect areaOfEffect, Location location){
        int x = location.getX();
        int y = location.getY();
        //int z = location.getZ();
        getTopTile(x,y).addAOE(areaOfEffect);
    }
}