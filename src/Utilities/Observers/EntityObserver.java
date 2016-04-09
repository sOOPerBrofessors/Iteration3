package Utilities.Observers;

import Model.Map.Location;

/**
 * Created by dyeung on 4/6/16.
 */

//Observers will essentially be the view objects created for each entity
public interface EntityObserver {
//    void updateMoveN(); //Signals that the entity needs to upadate its move parameters
//    void updateMoveNW();
//    void updateMoveNE();
//    void updateMoveS();
//    void updateMoveSW();
//    void updateMoveSE();
    void updateMove();

    void updateOrientation();

}
