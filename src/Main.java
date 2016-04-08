import Model.Model;
import Model.State.StateManager;
import View.ViewManager;

import Model.State.GameState;
import Utilities.GameLoader;

import Controller.ControllerManager;
import Controller.GameController;
import View.ViewUtilities.MainPanel;
import View.GameView;

import java.awt.*;


/**
 * Created by Wimberley on 3/23/16.
 */
public class Main {

    public static void main(String[] args) {

        //Controller controller = new Controller();


        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                //Mike's stuff that I moved over
                Model game = new Model();
                ViewManager view = new ViewManager();

                //Used to test the area view
                GameLoader gL = new GameLoader();
                GameState gs = gL.getGameState();
                //StateManager state = new StateManager();
                ControllerManager inputManager = new ControllerManager();
                inputManager.setActiveController(new GameController(inputManager,gs));



                MainPanel mainPanel = new MainPanel();
                GameView gv = new GameView(gs);

                mainPanel.addView(gv);
                mainPanel.addKeyListener(inputManager);

                mainPanel.setVisible(true);
                mainPanel.start();
            }
        });

    }

}
