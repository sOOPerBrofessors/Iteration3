package Controller.Controllers;

import Controller.Controller;
import Controller.ControllerManager;
import Controller.ControllerUtility.Command;
import Utilities.Settings;
import View.MenuViews.SettingsView;
import View.ViewUtilities.Panels.GamePanel;

public class SettingsController extends Controller { //NOT VERY OOPY

    private static SettingsView settingsView;

    private int lastKeypressed, secondLast;

    public SettingsController(ControllerManager controllerManager){
        super(controllerManager);
        initCommands();
    }
    public static void setSettingsView(GamePanel gamePanel){ settingsView = gamePanel.getSettingsView(); }

    @Override
    public void keyPress(Integer key){
        secondLast = lastKeypressed;
        lastKeypressed = key;
        if(commands.containsKey(key)) {
            commands.get(key).execute();
        }
    }

    private void initCommands(){

        commands.put(Settings.UP_ARROW, new Command() {
            @Override
            public void execute() { settingsView.selectUp();}
        });
        commands.put(Settings.DOWN_ARROW, new Command() {
            @Override
            public void execute() { settingsView.selectDown(); }
        });
        // interact key press
        commands.put(Settings.ENTER, new Command() {
            @Override
            public void execute() {
                settingsView.select(secondLast);
                controllerManager.initGameplayController();
            }
        });

        // Exit SettingsView
        commands.put(Settings.ESC, new Command() {
            @Override
            public void execute() {
                controllerManager.switchGamePlay();
            }
        });

        // Exit SettingsView
        commands.put(Settings.SETTINGS, new Command() {
            @Override
            public void execute() {
                controllerManager.switchGamePlay();
            }
        });
    }
}
