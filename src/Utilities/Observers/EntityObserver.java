package Utilities.Observers;

import Model.Map.Location;

/**
 * Created by dyeung on 4/6/16.
 */

//Observers will essentially be the view objects created for each entity
public interface EntityObserver {
    void updateMove();
}
