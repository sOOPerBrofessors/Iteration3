import Model.Model;
import View.View;
import Controller.Controller;
import Controller.GameController;
import View.ViewUtilities.MainPanel;
import View.GameView;
import java.awt.EventQueue;

/**
 * Created by Wimberley on 3/23/16.
 */
public class Main {

    public static void main(String[] args) {

//        Model game = new Model();
//        MainPanel mainPanel = new MainPanel();
//        View view = new View(mainPanel);
//        Controller controller = new GameController();

        float prevTime; // time before update
        float currentTime = System.currentTimeMillis();
        float dt; // change in time after game loop (while loop below) runs through one iteration

        //USED FOR TESTING THE AREA VIEWPORT

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainPanel mainPanel = new MainPanel();
                GameView gv = new GameView();
                mainPanel.addView(gv);
                mainPanel.setVisible(true);
                mainPanel.start();
            }
        });


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
