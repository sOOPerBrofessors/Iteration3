package View.ViewUtilities;

import Utilities.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * Created by Wimberley on 3/23/16.
 */
public class MainPanel extends JFrame{
    private String title;
    private int windowHeight, windowWidth;
    JPanel panel;

    public MainPanel() {
        this.title = Settings.TITLE;
        this.windowHeight = Settings.GAMEHEIGHT;
        this.windowWidth = Settings.GAMEWIDTH;
        setTitle(title);
        setSize(new Dimension(windowWidth, windowHeight));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);

        Dimension canvasDimension = new Dimension(windowWidth, windowHeight);
        setMinimumSize(canvasDimension);

        panel = new JPanel();
        panel.setPreferredSize(canvasDimension);
        panel.setMinimumSize(canvasDimension);
        panel.setFocusable(true);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);
        pack();


        this.getRootPane().addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                // This is only called when the user releases the mouse button.
                Settings.GAMEHEIGHT = windowHeight = getHeight();
                Settings.GAMEWIDTH = windowWidth = getWidth();

                panel.setPreferredSize(new Dimension(windowWidth, windowHeight));
                panel.setFocusable(true);
                repaint();

            }
        });

    }

    public JPanel getPanel() {
        return panel;
    }
}