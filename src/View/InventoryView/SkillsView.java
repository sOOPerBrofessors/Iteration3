package View.InventoryView;

import Utilities.Observers.Observer;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sgl on 4/16/16.
 */
public class SkillsView extends ViewPanel implements Observer {
    @Override
    public void update() {

    }

    @Override
    public void remove() {

    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g.create();
        drawBackground(g2d);
        g2d.dispose();
    }
}
