package View.ViewUtilities;

import Utilities.Settings;

import javax.swing.JFrame;
import java.awt.*;

/**
 * Created by Wimberley on 3/23/16.
 */
public class MainFrame extends JFrame{

    public MainFrame() {
        // set game popup screen properties
        super(Settings.TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLayout(new BorderLayout());

        // dimensions of game screen initially
        Dimension panelDimension = new Dimension(Settings.GAMEWIDTH, Settings.GAMEHEIGHT);
        setSize(panelDimension);
        setMinimumSize(panelDimension);
        setLocationRelativeTo(null);

        // canvas used to paint images onto frame

        getContentPane().setLayout(new BorderLayout());
        // move to View manager?
        pack();
    }

}