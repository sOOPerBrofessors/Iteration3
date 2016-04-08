package Controller;

import Model.State.GameState.GameState;

import java.awt.event.KeyEvent;

/**
 * Created by dyeung on 4/5/16.
 */
public class GameController extends Controller {
    GameState gameState;
    public GameController(ControllerManager controllerManager, GameState gs){ //GameState might have to be passed in in order to get correct information from load menu
        super(controllerManager);
        gameState = gs;
    }

    @Override
    public void keyPress(KeyEvent e) {
        //BASIC TESTING STUFF FOR NOW
        //System.out.println(e);
        if (e.getKeyCode() == KeyEvent.VK_W) {
            gameState.getAvatar().moveNorth();
        }else
        if (e.getKeyCode() == KeyEvent.VK_S) {
            gameState.getAvatar().moveSouth();
        }else
        if (e.getKeyCode() == KeyEvent.VK_Q) {
            gameState.getAvatar().moveNorthWest();
        }else
        if (e.getKeyCode() == KeyEvent.VK_E) {
            gameState.getAvatar().moveNorthEast();
        }else
        if (e.getKeyCode() == KeyEvent.VK_A) {
            gameState.getAvatar().moveSouthWest();
        }else
        if (e.getKeyCode() == KeyEvent.VK_D) {
            gameState.getAvatar().moveSouthEast();
        }
    }

}
