package View.ItemView;

import Model.Map.Location;
import Utilities.Settings;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dyeung on 4/9/16.
 */
public abstract class ItemView extends JComponent{

    protected Image image;
    protected int itemWidth;
    protected int itemHeight;
    protected int x;
    protected int y;
    protected int xPixel; // on the map
    protected int yPixel; // on the map

    public void paintComponent(Graphics g, Location offset){
        updateCoordinateToScreenPosition(offset.getX(), offset.getY());
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //System.out.println(image.toString());
        g2d.drawImage(image,xPixel*Settings.SCALEFACTOR,yPixel*Settings.SCALEFACTOR,itemWidth*Settings.SCALEFACTOR,itemHeight*Settings.SCALEFACTOR, null);
        g2d.dispose();
    }

    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }

    protected abstract void updateCoordinateToScreenPosition(int xOffset, int yOffset);
}