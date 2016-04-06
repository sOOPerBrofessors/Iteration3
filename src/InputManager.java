import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Controller.Controller;
import Controller.GameController;
/**
 * Created by dyeung on 4/5/16.
 */
public class InputManager implements KeyListener {
    private Controller activeController;

    public void setActiveController(Controller e){
        activeController = e;
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        activeController.handleKeyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
