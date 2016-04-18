package Model.State;

import Controller.ControllerManager;
import Model.State.GameState.ActiveGameState;
import Model.State.GameState.PausedGameState;
import Utilities.Tickable;
import Model.Model;

/**
 * Created by Wimberley on 4/6/16.
 */
public class StateManager implements Tickable {

    private Model model;

    // controller manager used to issue commands when controller needs to be changed
    private ControllerManager controllerManager;

    private State activeState;
    private ActiveGameState activeGameState;
    private PausedGameState pausedGameState;

    public StateManager(Model model){
        this.model=model;
    }

    public void stopThread(){
        model.terminate();
    }

    public void pauseGame(){
        activeState = pausedGameState;
    }

    public void activeGame(){
        activeState = activeGameState;
    }

    public void setActiveGameState(ActiveGameState activeGameState){
        this.activeGameState = activeGameState;
        activeState = activeGameState;
    }

    public void setControllerManager(ControllerManager controllerManager) {
        this.controllerManager = controllerManager;
    }

    public void setPausedGameState(PausedGameState pausedGameState){
        this.pausedGameState = pausedGameState;
    }

    @Override
    public void tick() {
        activeState.tick();
    }
}