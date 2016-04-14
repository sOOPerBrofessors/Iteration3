package Controller.Controllers;

import Model.State.GameState.ActiveGameState;
import Controller.Controller;
import Controller.ControllerManager;
import Controller.ControllerUtility.Command;
import Model.State.GameState.PausedGameState;
import Utilities.Settings;
import View.InventoryView.InventoryView;
import View.ViewUtilities.Panels.GamePanel;

/**
 * Created by sgl on 4/9/16. //Essentially copying Mike's GameplayController
 */
public class InventoryController extends Controller {

    private PausedGameState state; //does it need a handle to PausedGameState???
    private GamePanel gamePanel;
    private InventoryView inventoryView; //Needs handle to inventoryView

    public InventoryController(ControllerManager controllerManager){
        super(controllerManager);
    }

    @Override
    public void keyPress(Integer key){
        if(commands.containsKey(key)) {
            commands.get(key).execute();
        }
    }

    private void initCommands(){

        commands.put(Settings.UP_ARROW, new Command() {
            @Override
            public void execute() {
                inventoryView.selectUp();
            }
        });

        commands.put(Settings.RIGHT_ARROW, new Command() {
            @Override
            public void execute() {
                inventoryView.selectRight();
            }
        });

        commands.put(Settings.DOWN_ARROW, new Command() {
            @Override
            public void execute() { inventoryView.selectDown(); }
        });

        commands.put(Settings.LEFT_ARROW, new Command() {
            @Override
            public void execute() { inventoryView.selectLeft();}
        });

        // interact key press
        commands.put(Settings.ENTER, new Command() {
            @Override
            public void execute() {
                inventoryView.interactWithItem();
            }
        });

        // Exit InventoryView
        commands.put(Settings.ESC, new Command() {
            @Override
            public void execute() {
                //TODO: Change to active state!
                //TODO: TELL GAMEPANEL TO remove INVENTORY PANEL
                //TODO: switch back to inventory Controller
            }
        });


    }

    public void setState(PausedGameState state) {
        this.state = state;
        initCommands();
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
}

