package Model.Entity;

import java.util.ArrayList;

import Model.Map.Map;
import Model.Map.MapObject;
import Model.Map.Tile.Tile;
import Utilities.Navigation.Navigation;
import Model.Map.Orientation;
import Utilities.Observables.EntityObservable;
import Utilities.Observers.EntityObserver;
import Model.Map.Location;
import Utilities.Visitor.EntityVisitable;

import Utilities.Tickable;


/**
 * Created by dyeung on 4/6/16.
 *
 * TODO: in movePlayerDir(...), check if entity is facing that direction: if false, set direction; else, move
 */

//All entities are able now Observables for a specific model view

public abstract class Entity implements EntityObservable, MapObject, Tickable, EntityVisitable{
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
        if (this.orientation.equals(orientation)) {
            //This is done this way since when you call navigation.move it'll automatically move the entity-- thus we
            //need to check its orientation before the move
            if (navigation.move(getNextTile(map, orientation), this)) {
                updateLocation(map, orientation);
            }
        }else {
            setOrientation(orientation);
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
    private void updateLocation(Map map, Orientation orientation){
        //Freaking long ass thing to remove an entity
        map.getMapOfTiles()[location.getX()][location.getY()].getTileAt(location.getZ()).removeEntity();
        int newX = location.getX() + orientation.x;
        int newY = location.getY() + orientation.y;
        int newZ = location.getZ() + 0;
        location.setNewLocation(newX, newY, newZ);
        notifyObserverMove();
    }

    public void setLocation(Location location) {
        this.location = location;
    } // end setLocation

    public int getX(){
        return location.getX();
    }
    public int getY(){
        return location.getY();
    }
    public int getZ(){
        return location.getZ();
    }


}


