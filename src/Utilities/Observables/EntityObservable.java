package Utilities.Observables;

import Utilities.Observers.EntityObserver;
import Model.Map.Location;

/**
 * Created by dyeung on 4/6/16.
 */
public interface EntityObservable {
    void notifyObserverMoveN();
    void notifyObserverMoveNW();
    void notifyObserverMoveNE();
    void notifyObserverMoveS();
    void notifyObserverMoveSW();
    void notifyObserverMoveSE();
    void addObserver(EntityObserver entityObserver);
}
