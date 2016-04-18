package Controller.Controllers;

import Controller.Controller;
import Controller.ControllerManager;
import Controller.ControllerUtility.Command;
import Utilities.Settings;
import View.MenuViews.PauseView;
import View.ViewUtilities.Panels.GamePanel;

public class PauseController extends Controller { //NOT VERY OOPY

    private static PauseView pauseView;

    public PauseController(ControllerManager controllerManager){
        super(controllerManager);
        initCommands();
    }

    public static void setPauseView(GamePanel gamePanel){ pauseView = gamePanel.getPauseView(); }

    @Override
    public void keyPress(Integer key){
        if(commands.containsKey(key)) {
            commands.get(key).execute();
        }
    }

    private void initCommands(){

        commands.put(Settings.UP_ARROW, new Command() {
            @Override
            public void execute() { pauseView.selectUp(); }
        });

        commands.put(Settings.DOWN_ARROW, new Command() {
            @Override
            public void execute() { pauseView.selectDown(); }
        });

        // interact key press
        commands.put(Settings.ENTER, new Command() {
            @Override
            public void execute() { pauseView.select(); }
        });

        // Exit PauseView
        commands.put(Settings.ESC, new Command() {
            @Override
            public void execute() {
                controllerManager.switchGamePlay();
            }
        });
    }
}
