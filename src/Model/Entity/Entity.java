package Model.Entity;

import java.util.ArrayList;

import Model.Map.Map;
import Model.Map.MapObjects;
import Model.Map.Tile.Tile;
import Utilities.MessageHandler;
import Utilities.Navigation.Navigation;
import Model.Map.Orientation;
import Utilities.Observables.EntityObservable;
import Utilities.Observers.EntityObserver;
import Model.Map.Location;

/**
 * Created by dyeung on 4/6/16.
 *
 * TODO: in movePlayerDir(...), check if entity is facing that direction: if false, set direction; else, move
 */

//All entities are able now Observables for a specific model view
public abstract class Entity implements EntityObservable, MapObjects {
    private Location location;
    private Navigation navigation;
    protected Orientation orientation;

    private ArrayList<EntityObserver> observers;

    public Entity(Navigation navigation, Location location){
        this.navigation = navigation;
        this.location = location;
        observers = new ArrayList<>();
        orientation = Orientation.SOUTH;
    }

    @Override
    public void notifyObserverMove() {
        for (EntityObserver entityObserver : observers){
            entityObserver.updateMove();
        }
    }

    @Override
    public void addObserver(EntityObserver entityObserver) {
        observers.add(entityObserver);
    }


    private Tile getNextTile(Map map, int x, int y){
        int newX = location.getX() + x;
        int newY = location.getY() + y;
        return map.getTopTile(newX,newY);
    }
    //TODO: HOW TO HANDLE MOVING UP TILES
    public void moveNorth(Map map){
        if(navigation.move(getNextTile(map, 0, -1), this)) {
            //and update to the new tile
            updateLocation(0, -1, map);
        }
    }
    public void moveNorthEast(Map map){
        if(navigation.move(getNextTile(map, 1, -1), this)) {
            updateLocation(1, -1, map);
        }
    }
    public void moveSouthEast(Map map){
        if(navigation.move(getNextTile(map, 1, 0), this)) {
            updateLocation(1, 0, map);
        }
    }

    public void moveSouth(Map map){
        if(navigation.move(getNextTile(map,0,1), this)) {
            updateLocation(0, 1, map);
        }
    }
    public void moveSouthWest(Map map){
        if(navigation.move(getNextTile(map,-1,1), this)) {
            updateLocation(-1, 1, map);
        }
    }
    public void moveNorthWest(Map map){
        if(navigation.move(getNextTile(map,-1,0), this)) {
            updateLocation(-1, 0, map);
        }
    }

    public Location getLocation() {
        return location;
    }
    public Orientation getOrientation() {
        return orientation;
    }

    //TODO: Add the z values stuff
    private void updateLocation(int x, int y, Map map){
        //Might be better to have a removeAvatar() function within tilecolumn
        //map.getTile(location.getX(), location.getY()).removeAvatar();

        //TESTING for now Removes old object from current tile
        System.out.println("Entity: update location was called from move");
        map.getMapOfTiles()[location.getX()][location.getY()].removeMapObject();

        //Updates the new location
        int newX = location.getX() + x;
        int newY = location.getY() + y;
        int newZ = location.getZ() + 0;
        location.setNewLocation(newX,newY, newZ);
        notifyObserverMove();
        
        //Adds to the new tile
        map.getMapOfTiles()[newX][newY].addMapObjects(this);
    }

    public void setLocation(Location location) {
        this.location = location;
    } // end setLocation

}
