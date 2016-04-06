package Model.Entity;

import EntityObservable.EntityObservable;
import EntityObserver.EntityObserver;
import java.util.ArrayList;

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
    public void notifyObserverMove(int direction) {
        for (EntityObserver entityObserver : observers){
            entityObserver.updateMove(direction);
        }
    }

    @Override
    public void addObserver(EntityObserver entityObserver) {
        observers.add(entityObserver);
    }


}
