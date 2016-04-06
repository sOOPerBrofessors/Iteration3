package EntityObservable;

import EntityObserver.EntityObserver;

/**
 * Created by dyeung on 4/6/16.
 */
public interface EntityObservable {
    void notifyObserverMove(int direction);
    void addObserver(EntityObserver entityObserver);
}
