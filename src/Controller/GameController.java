package Controller;

import Model.States.GameState;

import java.awt.event.KeyEvent;

/**
 * Created by dyeung on 4/5/16.
 */
public class GameController extends Controller {
    GameState gameState;
    public GameController(GameState gs){ //GameState might have to be passed in in order to get correct information from load menu
        gameState = gs;
    }

    @Override
    public void handleKeyPressed(KeyEvent e) {
        //BASIC TESTING STUFF FOR NOW
        //System.out.println(e);
        if (e.getKeyCode() == KeyEvent.VK_W) {
            gameState.getAvatar().moveNorth();
        }
        if (e.getKeyChar() == 's') {
            gameState.getAvatar().moveSouth();
        }
        if (e.getKeyChar() == 'a') {
            gameState.getAvatar().moveEast();
        }
        if (e.getKeyChar() == 'd') {
            gameState.getAvatar().moveWest();

        }
    }

}
