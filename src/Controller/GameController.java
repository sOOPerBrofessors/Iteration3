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
            System.out.println("up");
            gameState.moveUp();
        }
        if (e.getKeyChar() == 's') {
            System.out.println("down");
        }
        if (e.getKeyChar() == 'a') {
            System.out.println("left");
        }
        if (e.getKeyChar() == 'd') {
            System.out.println("right");
        }
    }

}
