package View.MenuViews;

import Utilities.Observers.Observer;

import java.awt.*;

/**
 * Created by sgl on 4/16/16.
 */
public class SettingsView extends VertPanel implements Observer {
    @Override
    public void update() {

    }

    @Override
    public void remove() {

    }

    @Override
    public void selectUp() {

    }

    @Override
    public void selectDown() {

    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g.create();
        drawBackground(g2d);

        g2d.setColor(new Color(166, 0, 4, 255));
        g2d.setFont(new Font("Courier New", 1, 48));
        g2d.drawString("Settings", xBorderOffset*3+35, yBorderOffset+70);

        g2d.dispose();
    }


}
