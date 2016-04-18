package Controller.Controllers;

import Controller.Controller;
import Controller.ControllerManager;
import Utilities.Settings;
import View.MenuViews.TradeView;
import View.ViewUtilities.Panels.GamePanel;


public class TradeController extends Controller { //NOT VERY OOPY

    public TradeController(ControllerManager controllerManager){
        super(controllerManager);
        initCommands();
    }

    @Override
    public void keyPress(Integer key){
        if(commands.containsKey(key)) {
            commands.get(key).execute();
        }
    }
    public static void setTradeView(GamePanel gamePanel){
        TradeView tradeView = gamePanel.getTradeView();
    }

    private void initCommands(){

        // Exit TradeView
        commands.put(Settings.ESC, controllerManager::switchGamePlay);
    }
}
