import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Controller.Controller;
import Controller.GameController;
/**
 * Created by dyeung on 4/5/16.
 */
public class InputManager extends ComponentAdapter implements KeyListener {
    private Controller activeController;

    public void setActiveController(Controller e){
        System.out.println("Active controller being set");
        activeController = e;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println(e.getKeyChar());
        activeController.handleKeyPressed(e);

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
