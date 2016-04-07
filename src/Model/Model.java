package Model;

import Model.State.StateManager;

import java.util.HashMap;

/**
 * Created by Wimberley on 3/23/16.
 */
public class Model implements Runnable{

    private StateManager stateManager;

    public Model(){
        stateManager = new StateManager();
    }

    public void start(){

    }

    @Override
    public void run() {

    }

    public StateManager getStateManager() {
        return stateManager;
    }
}
