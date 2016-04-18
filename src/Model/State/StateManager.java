package Model.State;

import Controller.ControllerManager;
import Model.State.GameState.ActiveGameState;
import Model.State.GameState.GameState;
import Model.State.GameState.MountGameState;
import Model.State.GameState.PausedGameState;
import Utilities.Tickable;
import Model.Model;

/**
 * Created by Wimberley on 4/6/16.
 */
public class StateManager implements Tickable {

    private final Model model;

    private State activeState;
    private ActiveGameState activeGameState;
    private PausedGameState pausedGameState;
    private MountGameState mountGameState;

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

    public void activeMount(){
        mountGameState.setActiveMount(activeGameState.getActiveMount());
        activeState = mountGameState;
    }

    public void setActiveGameState(ActiveGameState activeGameState){
        this.activeGameState = activeGameState;
        this.activeGameState.setStateManager(this);
        activeState = activeGameState;
    }

    public void setControllerManager(ControllerManager controllerManager) {
        ControllerManager controllerManager1 = controllerManager;
    }

    public void setPausedGameState(PausedGameState pausedGameState){
        this.pausedGameState = pausedGameState;
    }

    public void setMountGameState(MountGameState mountGameState){
        this.mountGameState = mountGameState;
    }

    @Override
    public void tick() {
        if(activeState != null) {
            activeState.tick();
        }
    }

    public GameState getGameState(){
        return activeGameState;
    }
}