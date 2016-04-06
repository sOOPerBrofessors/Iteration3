import Model.Model;
import Model.States.GameState;
import Utilities.GameLoader;
import View.View;
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

        //USED FOR TESTING THE AREA VIEWPORT

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GameLoader gL = new GameLoader();
                GameState gs = gL.getGameState();

                InputManager inputManager = new InputManager();
                inputManager.setActiveController(new GameController(gs));
                MainPanel mainPanel = new MainPanel();
                GameView gv = new GameView(gs);

                mainPanel.addView(gv);
                mainPanel.addKeyListener(inputManager);

                mainPanel.setVisible(true);
                mainPanel.start();
            }
        });
        //MIKES STUFF

//        Model game = new Model();
//        MainPanel mainPanel = new MainPanel();
//        View view = new View(mainPanel);
//        Controller controller = new GameController();

//        float prevTime; // time before update
//        float currentTime = System.currentTimeMillis();
//        float dt; // change in time after game loop (while loop below) runs through one iteration

//        while (true) {
//
//            prevTime = currentTime;
//            currentTime = System.currentTimeMillis();
//            dt = currentTime - prevTime;
//
//            if (dt > 0.15f) {
//                dt = 0.15f;
//            }
//            game.update(dt);
//            //view.update(dt);
//        }

    }

}
