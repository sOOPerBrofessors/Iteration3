package View;

import View.ViewUtilities.InitPanels;
import View.ViewUtilities.IntroPanel;
import View.ViewUtilities.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

/**
 * Created by Wimberley on 3/23/16.
 */
public class ViewManager {

    private JFrame mainFrame;
    private JPanel activePanel;

    // all views that need to be swapped between
    private JPanel introPanel;

    private BufferStrategy bs;
    private Graphics g;

    public ViewManager(){
        mainFrame = new MainFrame();
        mainFrame.setLayout(new BorderLayout());
        InitPanels.initialize();
        // set intro screen panel
        introPanel = IntroPanel.getIntroPanel();

        displayIntro();
        mainFrame.setVisible(true);
    }

    public void update(float dt){

    }

    public void displayIntro(){
        mainFrame.add(introPanel);
    }
}
