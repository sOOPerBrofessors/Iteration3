package Controller;

import Controller.Controllers.GamePlayController;
import Controller.Controllers.InventoryController;
import Model.State.StateManager;
import Utilities.ErrorLevel;
import Utilities.MessageHandler;
import Utilities.PersonFilter;
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
    private GamePlayController gamePlayController;
    private InventoryController inventoryController;

    public ControllerManager(){
        gamePlayController = new GamePlayController(this);
        inventoryController = new InventoryController(this);
    }

    public void setActiveController(Controller gs){
        activeController = gs;
    }
    //End testing
    //
    public ControllerManager(ViewManager viewManager, StateManager stateManager){
        this.viewManager = viewManager;
        this.stateManager = stateManager;
        //Needs to set active controller
        //activeController = new GamePlayController()
    }

    public void setInventoryState(){
        activeController = inventoryController;
        stateManager.pauseGame(); // switches to pausedGameState
        viewManager.displayInventory();
        MessageHandler.println("ControllerManager.setInventoryState called" , ErrorLevel.NOTICE, PersonFilter.SAM);
    }

    public void setEquipmentState(){
        //viewManager.displayEquipment();
        stateManager.pauseGame();
        //activeController = equipmentController;
    }

    public void setPauseState(){
        //viewManager.displayPauseMenu();
        stateManager.pauseGame();
        //activeController = pauseController
    }

    public void setSkillsState(){
        //viewManager.displaySkills();
        stateManager.pauseGame();
        //activeController = skillsController
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(activeController != null) {
            activeController.keyPress(e.getKeyCode());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void switchGamePlay(){
        activeController = gamePlayController;
        stateManager.activeGame(); // makes Game state Active
        viewManager.closeInventory();
    }

    public void setViewManager(ViewManager viewManager){
        this.viewManager = viewManager;
    }

    public void setStateManager(StateManager stateManager){
        this.stateManager = stateManager;
    }

    public GamePlayController getGamePlayController(){
        return gamePlayController;
    }
}
