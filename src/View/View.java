package View;

import Controller.ControllerManager;
import Utilities.Observers.Observer;
import View.ViewUtilities.MainFrame;
import Model.Model;
//import javafx.beans.InvalidationListener;
//import javafx.beans.Observable;

import javax.swing.JFrame;
import java.awt.*;

/**
 * Created by Wimberley on 4/7/16.
 */
public class View implements Runnable, Observer{

    private final JFrame mainFrame;
    private final ViewManager viewManager;
    private static Model gameLoop;

    public View(Model gameLoop){
        View.gameLoop = gameLoop;
        mainFrame = new MainFrame();
        viewManager = new ViewManager();
        viewManager.addObserver(this);
        mainFrame.add(viewManager.getActivePanel());
        update();
        mainFrame.setVisible(true);
    }

    @Override
    public void run() {

        long lastTime;
        double delta;

        while (true) {

            lastTime = System.currentTimeMillis();

            // adjust for changes in panel
            mainFrame.revalidate();
            mainFrame.repaint();

            delta = System.currentTimeMillis() - lastTime;

            if (delta < 50) {
                try {
                    Thread.sleep(((long) (50 - delta)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void start(){
        new Thread(this).start();
    }

    @Override
    public void update() {
        mainFrame.getContentPane().removeAll();
        mainFrame.add(viewManager.getActivePanel());
    }

    @Override
    public void remove() {

    }

    public void setKeyListener(ControllerManager controller){
        mainFrame.addKeyListener(controller);
        mainFrame.setFocusable(true);
    }

    public ViewManager getViewManager() {
        return viewManager;
    }

    public static void startGameLoop(){
        gameLoop.restart();
    }
}
