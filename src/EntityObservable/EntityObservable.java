package EntityObservable;

import EntityObserver.EntityObserver;
import Model.Map.Location;

/**
 * Created by dyeung on 4/6/16.
 */
public interface EntityObservable {
    void notifyObserverMove(Location direction);
    void addObserver(EntityObserver entityObserver);
}
