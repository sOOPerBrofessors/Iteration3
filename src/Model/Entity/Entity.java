package Model.Entity;

import java.util.ArrayList;

import Model.Map.Tile.Tile;
import Utilities.MessageHandler;
import Utilities.Navigation.Navigation;
import Utilities.Observables.EntityObservable;
import Utilities.Observers.EntityObserver;
import Model.Map.Location;

/**
 * Created by dyeung on 4/6/16.
 *
 * TODO: in movePlayerDir(...), check if entity is facing that direction: if false, set direction; else, move
 */

//All entities are able now Observables for a specific model view
public abstract class Entity implements EntityObservable {
    private Location location;
    private Navigation navigation;
    private ArrayList<EntityObserver> observers;

    public Entity(Navigation navigation, Location location){
        this.navigation = navigation;
        this.location = location;
        observers = new ArrayList<>();
    }

    //An observable when a move is called will notify the observer that a move is called
    @Override
    public void notifyObserverMoveN() {
        for (EntityObserver entityObserver : observers){
            entityObserver.updateMoveN();
        }
    }
    @Override
    public void notifyObserverMoveNW() {
        for (EntityObserver entityObserver : observers){
            entityObserver.updateMoveNW();
        }
    }
    @Override
    public void notifyObserverMoveNE() {
        for (EntityObserver entityObserver : observers){
            entityObserver.updateMoveNE();
        }
    }
    @Override
    public void notifyObserverMoveS() {
        for (EntityObserver entityObserver : observers){
            entityObserver.updateMoveS();
        }
    }
    @Override
    public void notifyObserverMoveSE() {
        for (EntityObserver entityObserver : observers){
            entityObserver.updateMoveSE();
        }
    }
    @Override
    public void notifyObserverMoveSW() {
        for (EntityObserver entityObserver : observers){
            entityObserver.updateMoveSW();
        }
    }

    @Override
    public void addObserver(EntityObserver entityObserver) {
        observers.add(entityObserver);
    }
    //TODO: HOW TO HANDLE MOVING UP TILES
    public void moveNorth(Tile targetTile){
        if(navigation.move(targetTile, this)) {
            updateLocation(0, -1);
            notifyObserverMoveN();
        }
    }
    public void moveNorthEast(Tile targetTile){
        if(navigation.move(targetTile, this)) {
            updateLocation(1, -1);
            notifyObserverMoveNE();
        }
    }
    public void moveSouthEast(Tile targetTile){
        if(navigation.move(targetTile, this)) {
            updateLocation(1, 0);
            notifyObserverMoveSE();
        }
    }

    public void moveSouth(Tile targetTile){
        if(navigation.move(targetTile, this)) {
            updateLocation(0, 1);
            notifyObserverMoveS();
        }
    }
    public void moveSouthWest(Tile targetTile){
        if(navigation.move(targetTile, this)) {
            updateLocation(-1, 1);
            notifyObserverMoveSW();
        }
    }
    public void moveNorthWest(Tile targetTile){
        if(navigation.move(targetTile, this)) {
            updateLocation(-1, 0);
            notifyObserverMoveNW();
        }
    }

    public Location getLocation() {
        return location;
    }

    //TODO: Add the z values stuff
    private void updateLocation(int x, int y){
        int newX = location.getX() + x;
        int newY = location.getY() + y;
        int newZ = location.getZ() + 0;
        location.setNewLocation(newX,newY, newZ);
    }

    public void setLocation(Location location) {
        this.location = location;
    } // end setLocation
}
