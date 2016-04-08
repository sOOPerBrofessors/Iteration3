package Model.Entity;

import java.util.ArrayList;

import Utilities.Observables.EntityObservable;
import Utilities.Observers.EntityObserver;
import Model.Map.Location;

/**
 * Created by dyeung on 4/6/16.
 */

//All entities are able now Observables for a specific model view
public abstract class Entity implements EntityObservable {
    private ArrayList<EntityObserver> observers;
    public Entity(){
        observers = new ArrayList<>();
    }

    //An observable when a move is called will notify the observer that a move is called
    @Override
    public void notifyObserverMove(Location direction) {
        for (EntityObserver entityObserver : observers){
            entityObserver.updateMove(direction);
        }
    }

    @Override
    public void addObserver(EntityObserver entityObserver) {
        observers.add(entityObserver);
    }

    public void moveNorth(){
        notifyObserverMove(new Location(0,-1,0));
    }
    public void moveNorthWest(){
        notifyObserverMove(new Location(-1,0,0));
    }
    public void moveSouthWest(){
        notifyObserverMove(new Location(-1,1,0));
    }
    public void moveSouth(){
        notifyObserverMove(new Location(0,1,0));
    }
    public void moveSouthEast(){
        notifyObserverMove(new Location(1,0,0));
    }
    public void moveNorthEast(){
        notifyObserverMove(new Location(1,-1,0));
    }

}
