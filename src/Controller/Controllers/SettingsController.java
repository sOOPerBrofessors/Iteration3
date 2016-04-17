package Controller.Controllers;

import Controller.Controller;
import Controller.ControllerManager;
import Controller.ControllerUtility.Command;
import Utilities.Settings;
import View.InventoryView.SettingsView;
import View.ViewUtilities.Panels.GamePanel;

public class SettingsController extends Controller { //NOT VERY OOPY

    private static SettingsView settingsView;

    public SettingsController(ControllerManager controllerManager){
        super(controllerManager);
        initCommands();
    }
    public static void setSettingsView(GamePanel gamePanel){ settingsView = gamePanel.getSettingsView(); }

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

                //inventoryView.selectUp();
            }
        });

        commands.put(Settings.RIGHT_ARROW, new Command() {
            @Override
            public void execute() {

                //inventoryView.selectRight();
            }
        });

        commands.put(Settings.DOWN_ARROW, new Command() {
            @Override
            public void execute() {
                //inventoryView.selectDown();
            }
        });

        commands.put(Settings.LEFT_ARROW, new Command() {
            @Override
            public void execute() {
                //inventoryView.selectLeft();
            }
        });

        // interact key press
        commands.put(Settings.ENTER, new Command() {
            @Override
            public void execute() {
                //inventoryView.interactWithItem();
            }
        });

        // Exit InventoryView
        commands.put(Settings.ESC, new Command() {
            @Override
            public void execute() {
                controllerManager.switchGamePlay();
            }
        });

        // Exit InventoryView
        commands.put(Settings.SETTINGS, new Command() {
            @Override
            public void execute() {
                controllerManager.switchGamePlay();
            }
        });
    }
}
