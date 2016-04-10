package Utilities.Observers;


/**
 * Created by dyeung on 4/10/16.
 */

//This is the tile. The tile is an observable object by that will notify everything anything that it accepts
public interface TileObservable {
    void acceptTileObserver(TileObserver tileObserver);
    void notifyObservers();
}
