package View;

import View.ViewUtilities.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by Wimberley on 3/23/16.
 */
public class View {

    private JPanel panel;
    private BufferStrategy bs;
    private Graphics g;

    public View(MainPanel mainPanel){
        panel = mainPanel.getPanel();
        mainPanel.setVisible(true);
    }

    public void update(float dt){

    }

}
