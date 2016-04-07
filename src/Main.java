import Model.Model;
import View.ViewManager;
import View.View;

import Model.State.GameState;
import Utilities.GameLoader;

import Controller.Controller;
import Controller.GameController;
import View.ViewUtilities.MainPanel;
import View.GameView;

import java.awt.*;


/**
 * Created by Wimberley on 3/23/16.
 */
public class Main {

    public static void main(String[] args) {

        Model gameLoop = new Model();
        View view = new View();
        //initializeGame;
        //Controller controller = new Controller();


        /*EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                //Mike's stuff that I moved over
                Model game = new Model();
                //ViewManager view = new ViewManager();

                //Used to test the area view
//                GameLoader gL = new GameLoader();
//                GameState gs = gL.getGameState();
//
//                InputManager inputManager = new InputManager();
//                inputManager.setActiveController(new GameController(gs));
//                MainPanel mainPanel = new MainPanel();
//                GameView gv = new GameView(gs);
//
//                mainPanel.addView(gv);
//                mainPanel.addKeyListener(inputManager);
//
//                mainPanel.setVisible(true);
//                mainPanel.start();
            }
        });*/
        while(true){
            view.render();
        }
        //gameLoop.start();
        //view.start();
    }
}
