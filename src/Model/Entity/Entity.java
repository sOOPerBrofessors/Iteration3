package Model.Entity;

import java.util.ArrayList;

import Model.Map.Orientation;
import Utilities.Observables.EntityObservable;
import Utilities.Observers.EntityObserver;
import Model.Map.Location;

/**
 * Created by dyeung on 4/6/16.
 */

//All entities are able now Observables for a specific model view
public abstract class Entity implements EntityObservable {
    private Location location;
    protected Orientation orientation;
    private ArrayList<EntityObserver> observers;
    public Entity(Location location){
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
    //TODO: HOW TO HANDLE MOVING UP TILES
    public void moveNorth(){
        updateLocation(0,-1);
        //notifyObserverMoveN();
    }
    public void moveNorthEast(){
        updateLocation(1,-1);
        //notifyObserverMoveNE();
    }
    public void moveSouthEast(){
        updateLocation(1,0);
        //notifyObserverMoveSE();
    }

    public void moveSouth(){
        updateLocation(0,1);
        //notifyObserverMoveS();
    }
    public void moveSouthWest(){
        updateLocation(-1,1);
        //notifyObserverMoveSW();
    }
    public void moveNorthWest(){
        updateLocation(-1,0);
        //notifyObserverMoveNW();

    }

    public Location getLocation() {
        return location;
    }
    public Orientation getOrientation() {
        return orientation;
    }

    //TODO: Add the z values stuff
    private void updateLocation(int x, int y){
        int newX = location.getX() + x;
        int newY = location.getY() + y;
        int newZ = location.getZ() + 0;
        location.setNewLocation(newX,newY, newZ);
        notifyObserverMove();
    }


    //MIGHT NEED THIS LATER, IF NOT I WILL DELETE
    //An observable when a move is called will notify the observer that a move is called
//    @Override
//    public void notifyObserverMoveN() {
//        for (EntityObserver entityObserver : observers){
//            entityObserver.updateMoveN();
//        }
//    }
//    @Override
//    public void notifyObserverMoveNW() {
//        for (EntityObserver entityObserver : observers){
//            entityObserver.updateMoveNW();
//        }
//    }
//    @Override
//    public void notifyObserverMoveNE() {
//        for (EntityObserver entityObserver : observers){
//            entityObserver.updateMoveNE();
//        }
//    }
//    @Override
//    public void notifyObserverMoveS() {
//        for (EntityObserver entityObserver : observers){
//            entityObserver.updateMoveS();
//        }
//    }
//    @Override
//    public void notifyObserverMoveSE() {
//        for (EntityObserver entityObserver : observers){
//            entityObserver.updateMoveSE();
//        }
//    }
//    @Override
//    public void notifyObserverMoveSW() {
//        for (EntityObserver entityObserver : observers){
//            entityObserver.updateMoveSW();
//        }
//    }
}
