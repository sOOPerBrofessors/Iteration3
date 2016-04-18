package Model.Map;

import Model.Entity.Character.Character;
import Model.Entity.Character.Mount.Mount;
import Model.Map.AreaEffect.AreaOfEffect;
import Model.Map.Tile.Tile;
import Model.Entity.Projectile.Projectile;
import Utilities.ItemStuff.ItemManager;
import Utilities.AIStuff.Pathfinding.TileLocationTuple;

import java.util.HashSet;

/**
 * Created by sgl on 4/5/16.
 */
public class Map {

    private final int maxRow;
    private final int maxColumn;
    private ItemManager itemManager;

    public Map(TileColumn[][] tiles){
        mapOfTiles = tiles;
        maxRow = tiles.length;
        maxColumn = tiles[0].length;
    }

    public void addItemManager(ItemManager itemManager) {
        this.itemManager = itemManager;
    } // end addItemManager

    private final TileColumn[][] mapOfTiles;

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
        if(newTile == null)
            return false;
        //newTile.doRiverEffect(this, character);
        Location location = character.getLocation();
        //Needs to move the character before the tile does interaction because of "teleport" effect
        if (checkCanInteractWithTile(location, newLocation)
                && !checkHasObstacle(newLocation)
                && newTile.moveCharacter(character)){
            getTileAt(currentX, currentY, currentZ).removeCharacter();
            character.updateLocation(new Location(newX,newY,newZ));
            newTile.doTileEffects(character); //does the interaction
            newTile.doRiverEffect(this,character);
            if(currentZ - newZ >= 3)
                character.applyFallDamage(-1*(currentZ - newZ + 1)/3);
            return true;
        }else{
            return false;
        }
    }

    public boolean moveMount(Mount mount, Location newLocation){
        int currentX = mount.getX();
        int currentY = mount.getY();
        int currentZ = mount.getZ();
        int newX = newLocation.getX();
        int newY = newLocation.getY();
        int newZ = getTopTilePosition(newX, newY);
        Tile newTile = getTopTile(newX,newY);
        Location location = mount.getLocation();
        //Needs to move the character before the tile does interaction because of "teleport" effect
        if (checkCanInteractWithTile(location, newLocation)
                && !checkHasObstacle(newLocation)
                && newTile.moveMount(mount)){
            getTileAt(currentX, currentY, currentZ).removeMount();
            mount.updateLocation(new Location(newX,newY,newZ));
            //newTile.doTileEffects(mount); //does the interaction
            return true;
        }else{
            return false;
        }
    }
    public boolean teleportCharacter(Character character, Location targetLocation) {
        if(moveCharacter(character, targetLocation)) {
            character.notifyOfTeleport();
            return true;
        }
        return false;
    } // end teleportCharacter

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
                && newTile.moveProjectile(projectile)){
            getTileAt(currentX, currentY, currentZ).removeProjectile();
            projectile.updateLocation(new Location(newX,newY,newZ));
            return true;
        }else{
            return false;
        }
    }

    private boolean checkHeightDifference(int current, int target){
        return (target - current) <= 1;
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

        return checkBounds(newX, newY) && checkHeightDifference(currentZ, newZ);
    }

    private boolean checkHasObstacle(Location newLocation) {
        return itemManager.tileContainsObstacle(newLocation);
    } // end checkHasObstacle





    //Other stuff for map
    private boolean checkBounds(int x, int y){
        return !(x < 0 || y < 0 || x >= maxColumn || y >= maxRow);
    }

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

    public int getTopTilePosition(int x, int y) {
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

    private TileLocationTuple getTileTupleNeighbor(int x, int y, int z, Orientation orientation) {

        int newX = x + orientation.x;
        int newY = y + orientation.y;
        Tile topTile = getTopTile(newX, newY);
        int nextZ = getTopTilePosition(newX, newY);
        int difference = (nextZ - 1) - z;

        if (getTopTile(newX, newY) == null) {

            return null;

        }

        if (difference <= 1) {

            return new TileLocationTuple(topTile, new Location(newX, newY, nextZ));

        }

        // We don't want to consider tiles with a significant height difference neighbors so that pathfinding works well.
        return null;

    }

    public HashSet<TileLocationTuple> getTileNeighbors(int x, int y, int z) {

        HashSet<TileLocationTuple> neighbors = new HashSet<>();

        for (Orientation orientation : Orientation.values()) {

            TileLocationTuple tuple = getTileTupleNeighbor(x, y, z, orientation);

            if (tuple != null) {

                neighbors.add(getTileTupleNeighbor(x, y, z, orientation));

            }

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


    //FOR LOADING IN MAP OBJECTS (ENTITY/ITEM)
    //Characters are essentially things that exist on the top of group types
    public void addCharacter(Character character){
        mapOfTiles[character.getX()][character.getY()].addCharacter(character);
    }

    public void removeCharacter(Character character){
        mapOfTiles[character.getX()][character.getY()].removeCharacter(character);
    }

    public void addMount(Mount mount){
        mapOfTiles[mount.getX()][mount.getY()].addMount(mount);
    }

    public void addAOE(AreaOfEffect areaOfEffect, Location location){
        int x = location.getX();
        int y = location.getY();
        //int z = location.getZ();
        getTopTile(x,y).addAOE(areaOfEffect);
    }
}