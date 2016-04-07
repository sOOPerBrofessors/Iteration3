package View;

import View.ViewUtilities.MainFrame;
import View.ViewUtilities.Panels.InitPanels;
import View.ViewUtilities.Panels.IntroPanel;

import javax.swing.JFrame;

/**
 * Created by Wimberley on 4/7/16.
 */
public class View implements Runnable{

    private JFrame mainFrame;
    private ViewManager viewManager;
    private IntroPanel introPanel;

    public View(){
        mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        viewManager = new ViewManager();
        introPanel = new IntroPanel(viewManager);
    }

    public void render(){
        mainFrame.add(introPanel.titlePanel(viewManager));
    }

    @Override
    public void run() {

        long lastTime;
        double delta;

        while (true) {

            lastTime = System.currentTimeMillis();

            mainFrame.add(viewManager.getActivePanel());
            // update to active panel from view manager
            //updateView();
            // calls paint method stored in active JPanel in ViewManager
            //viewManager.getActivePanel().repaint();

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

    private void updateView(){
        mainFrame.getContentPane().removeAll();
        mainFrame.add(viewManager.getActivePanel());
    }
}
