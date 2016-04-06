package Controller;

import Model.State.StateManager;
import View.ViewManager;

/**
 * Created by Wimberley on 3/25/16.
 */
public class ControllerManager {

    private ViewManager viewManager;
    private StateManager stateManager;
    private Controller activeController;

    public ControllerManager(ViewManager viewManager, StateManager stateManager){
        this.viewManager = viewManager;
        this.stateManager = stateManager;
    }

    public void inventory(){
        viewManager.displayInventory();
        stateManager.pauseGame();
        //activeController = inventoryController;
    }

    public void equipment(){
        viewManager.displayEquipment();
        stateManager.pauseGame();
        //activeController = equipmentController;
    }

    public void pause(){
        viewManager.displayPauseMenu();
        stateManager.pauseGame();
        //activeController = pauseController
    }

    public void skills(){
        viewManager.displaySkills();
        stateManager.pauseGame();
        //activeController = skillsController
    }
}
