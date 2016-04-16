package Controller.Controllers;

import Controller.Controller;
import Controller.ControllerManager;
import Controller.ControllerUtility.Command;
import Utilities.Settings;
import View.InventoryView.StatsView;
import View.ViewManager;
import View.ViewUtilities.Panels.GamePanel;

/**
 * Created by sgl on 4/15/16.
 */

//StatsController just lets you exit Stats
public class StatsController extends Controller {


    private GamePanel gamePanel;
    private ViewManager viewManager;
    private static StatsView statsView; //Needs handle to inventoryView

    public StatsController(ControllerManager controllerManager){
        super(controllerManager);
        //viewManager = controllerManager.getViewManager();
        //gamePanel = viewManager.getGamePanel();
        //inventoryView = controllerManager.getViewManager().getGamePanel().getInventoryView();
        initCommands();
    }

    public static void setInventoryView(GamePanel gamePanel){
        statsView = gamePanel.getStatsView();
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

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
}

