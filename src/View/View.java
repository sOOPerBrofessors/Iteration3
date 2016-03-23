package View;

import View.ViewUtilities.MainPanel;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by Wimberley on 3/23/16.
 */
public class View {

    private Canvas canvas;
    private BufferStrategy bs;
    private Graphics g;

    public View(MainPanel mainPanel){
        canvas = mainPanel.getCanvas();
        mainPanel.setVisible(true);
    }


}
