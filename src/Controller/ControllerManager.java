package Controller;

import Controller.Controllers.ActiveGameController;
import Model.State.StateManager;
import View.ViewManager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Wimberley on 3/25/16.
 */

//Note that this is the Input Manager now
public class ControllerManager implements KeyListener {

    private ViewManager viewManager;
    private StateManager stateManager;
    private Controller activeController;

    public ControllerManager(ViewManager viewManager, StateManager stateManager){
        this.viewManager = viewManager;
        this.stateManager = stateManager;
        //Needs to set active controller
        //activeController = new ActiveGameController()
    }

    public void setInventoryState(){
        viewManager.displayInventory();
        stateManager.pauseGame();
        //activeController = inventoryController;
    }

    public void setEquipmentState(){
        viewManager.displayEquipment();
        stateManager.pauseGame();
        //activeController = equipmentController;
    }

    public void setPauseState(){
        viewManager.displayPauseMenu();
        stateManager.pauseGame();
        //activeController = pauseController
    }

    public void setSkillsState(){
        viewManager.displaySkills();
        stateManager.pauseGame();
        //activeController = skillsController
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        activeController.keyPress(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
