package View;

import Controller.ControllerManager;
import Model.State.StateManager;
import Utilities.Observer;
import View.ViewUtilities.MainFrame;

import javax.swing.JFrame;

/**
 * Created by Wimberley on 4/7/16.
 */
public class View implements Runnable, Observer{

    private JFrame mainFrame;
    private ViewManager viewManager;

    private StateManager stateManager;
    private ControllerManager controllerManager;

    public View(){
        mainFrame = new MainFrame();
        viewManager = new ViewManager();
        viewManager.addObserver(this);
        mainFrame.add(viewManager.getActivePanel());
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

    public ViewManager getViewManager() {
        return viewManager;
    }

    public void setStateManager(StateManager stateManager) {
        this.stateManager = stateManager;
    }
}
