package View;

import View.ViewUtilities.Panels.InitPanels;
import View.ViewUtilities.Panels.IntroPanel;
import View.ViewUtilities.MainFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

/**
 * Created by Wimberley on 3/23/16.
 */
public class ViewManager {

    private JFrame mainFrame;
    private JPanel activePanel;

    // all views that need to be swapped between
    private JPanel introPanel;

    private Graphics g;

    public ViewManager(){
        mainFrame = new MainFrame();
        InitPanels.initialize(this);
        // set intro screen panel
        introPanel = IntroPanel.getIntroPanel();

        displayIntro();
        updateView();
        mainFrame.setVisible(true);
    }

    public void update(float dt){
    }

    public void updateView(){
        mainFrame.add(activePanel);
    }

    public void displayIntro(){
        activePanel = introPanel;
    }

    public void exitGame(){
        System.exit(0);
    }
}
