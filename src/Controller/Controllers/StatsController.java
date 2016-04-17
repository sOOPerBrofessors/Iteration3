package Controller.Controllers;

import Controller.Controller;
import Controller.ControllerManager;
import Controller.ControllerUtility.Command;
import Utilities.Settings;

//StatsController just lets you exit Stats
public class StatsController extends Controller { //NOT VERY OOPY

    public StatsController(ControllerManager controllerManager){
        super(controllerManager);
        initCommands();
    }

    @Override
    public void keyPress(Integer key){
        if(commands.containsKey(key)) {
            commands.get(key).execute();
        }
    }

    private void initCommands(){

        // Exit InventoryView
        commands.put(Settings.ESC, new Command() {
            @Override
            public void execute() {
                controllerManager.switchGamePlay();
            }
        });

        // Exit InventoryView
        commands.put(Settings.STATS, new Command() {
            @Override
            public void execute() {
                controllerManager.switchGamePlay();
            }
        });
    }

}

