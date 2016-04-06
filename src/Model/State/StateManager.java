package Model.State;

import Controller.ControllerManager;
import Model.State.States.ActiveGameState;
import View.ViewManager;

/**
 * Created by Wimberley on 4/6/16.
 */
public class StateManager {

    private State activeState;
    private ActiveGameState activeGameState;

    private ControllerManager controllerManager;

    public StateManager(ControllerManager controllerManager){
        this.controllerManager = controllerManager;
    }

    public void pauseGame(){
        //activeState = pauseState;
    }
}
