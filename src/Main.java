import Model.Model;
import View.ViewManager;

/**
 * Created by Wimberley on 3/23/16.
 */
public class Main {

    public static void main(String[] args) {

        Model game = new Model();
        ViewManager view = new ViewManager();
        //Controller controller = new Controller();

        float prevTime; // time before update
        float currentTime = System.currentTimeMillis();
        float dt; // change in time after game loop (while loop below) runs through one iteration

        while (true) {

            prevTime = currentTime;
            currentTime = System.currentTimeMillis();
            dt = currentTime - prevTime;

            if (dt > 0.15f) {
                dt = 0.15f;
            }
            game.update(dt);
            view.update(dt);
        }

    }

}
