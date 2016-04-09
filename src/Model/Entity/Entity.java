package Model.Entity;

import java.util.ArrayList;

import Model.Map.Map;
import Model.Map.MapObject;
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
public abstract class Entity implements EntityObservable, MapObject {
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


    private Tile getNextTile(Map map, Orientation orientation){
        int newX = location.getX() + orientation.x;
        int newY = location.getY() + orientation.y;
        return map.getTopTile(newX,newY);
    }
    //TODO: HOW TO HANDLE MOVING UP TILES
    public void move(Map map, Orientation orientation){
        //System.out.println("Entity: update location was called from move:" + this.orientation + ":" + orientation);
        if (navigation.move(getNextTile(map,orientation),this)){
            updateLocation(map ,orientation);
        }
    }

    public Location getLocation() {
        return location;
    }
    public Orientation getOrientation() {
        return orientation;
    }
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
    //TODO: Add the z values stuff
    private void updateLocation(Map map, Orientation orientation){
        //Might be better to have a removeAvatar() function within tilecolumn
        //map.getTile(location.getX(), location.getY()).removeAvatar();
        if (this.orientation.equals(orientation)) {
            map.getMapOfTiles()[location.getX()][location.getY()].removeMapObject(this); //LoD

            //Updates the new location
            int newX = location.getX() + orientation.x;
            int newY = location.getY() + orientation.y;
            int newZ = location.getZ() + 0;
            location.setNewLocation(newX, newY, newZ);
            notifyObserverMove();

            //Adds to the new tile
            map.getMapOfTiles()[newX][newY].addMapObjects(this);
        }else {
            //Basically it'll only update orientation if key is pressed, else it'll start moving
            setOrientation(orientation);
        }
    }

    public void setLocation(Location location) {
        this.location = location;
    } // end setLocation

}


