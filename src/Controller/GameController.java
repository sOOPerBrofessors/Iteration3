package Controller;

import Model.States.GameState;

import java.awt.event.KeyEvent;

/**
 * Created by dyeung on 4/5/16.
 */
public class GameController extends Controller {
    GameState gameState;
    public GameController(){ //GameState might have to be passed in in order to get correct information from load menu
        gameState = new GameState();
    }

    @Override
    public void handleKeyPressed(KeyEvent e) {

    }

}
