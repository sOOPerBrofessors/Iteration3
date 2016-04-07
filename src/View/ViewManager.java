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

    private JPanel activePanel;

    // all views that need to be swapped between
    private JPanel introPanel;

    private Graphics g;

    public ViewManager(){
        InitPanels.initialize(this);
        // set intro screen panel
        introPanel = IntroPanel.getIntroPanel();

        displayIntro();
    }

    public void displayIntro(){
        activePanel = introPanel;
    }

    public void displayInventory(){
        //activePanel = inventoryPanel;
    }

    public void displayEquipment(){
        //activePanel = equipmentPanel;
    }

    public void displayPauseMenu(){
        //activePanel = pausePanel;
    }

    public void displaySkills(){
        //activePanel = skillsPanel;
    }

    public JPanel getActivePanel(){
        return activePanel;
    }
}
