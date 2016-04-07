package Model.State;

import Controller.ControllerManager;
import Model.State.States.ActiveGameState;
import View.ViewManager;

/**
 * Created by Wimberley on 4/6/16.
 */
public class StateManager {

    // controller manager used to issue commands when controller needs to be changed
    private ControllerManager controllerManager;

    private State activeState;
    private ActiveGameState activeGameState;

    public StateManager(){
        activeGameState = new ActiveGameState();
        activeState = activeGameState;
    }

    public void pauseGame(){
        //activeState = pauseState;
    }

    public ActiveGameState getActiveGameState(){
        return activeGameState;
    }

    public void setControllerManager(ControllerManager controllerManager) {
        this.controllerManager = controllerManager;
    }
}
