package View.InventoryView;

import Utilities.Observers.Observer;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sgl on 4/16/16.
 */
public class PauseView extends VertPanel {

    private int sel = 0;

    @Override
    public void selectUp() {

    }

    @Override
    public void selectDown() {

    }

    public void select(){

    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g.create();
        drawBackground(g2d);

        g2d.setColor(new Color(166, 0, 4, 255));
        g2d.setFont(new Font("Courier New", 1, 48));
        g2d.drawString("Pause Menu", xBorderOffset*3, yBorderOffset+50);

        g2d.dispose();
    }


}
