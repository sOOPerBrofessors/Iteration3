package EntityObserver;

/**
 * Created by dyeung on 4/6/16.
 */

//Observers will essentially be the view objects created for each entity
public interface EntityObserver {
    void updateMove(int direction); //Signals that the entity needs to upadate its move parameters
}
