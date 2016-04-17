package Controller;

import Controller.Controllers.*;
import Model.State.StateManager;
import Utilities.ErrorLevel;
import Utilities.MessageHandler;
import Utilities.PersonFilter;
import Utilities.Settings;
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
    private StatsController statsController;
    private PauseController pauseController;
    private SkillsController skillsController;
    private SettingsController settingsController;
    private TradeController tradeController;

    public ControllerManager(){
        gamePlayController = new GamePlayController(this);
        inventoryController = new InventoryController(this); //So not OCP
        statsController = new StatsController(this);
        pauseController = new PauseController(this);
        skillsController = new SkillsController(this);
        settingsController = new SettingsController(this);
        tradeController = new TradeController(this);
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

    //InventoryStats shows Equipment as well
//    public void setEquipmentState(){
//        //viewManager.displayEquipment();
//        stateManager.pauseGame();
//        //activeController = equipmentController;
//    }

    public void setStatsState(){
        activeController = statsController;
        stateManager.pauseGame(); // switches to pausedGameState
        viewManager.displayStats();
    }

    public void setPauseState(){
        activeController = pauseController;
        stateManager.pauseGame();
        viewManager.displayPauseScreen();
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
        //viewManager.closeInventory();
        viewManager.closeAll();
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

    public ViewManager getViewManager(){return viewManager;}
}
