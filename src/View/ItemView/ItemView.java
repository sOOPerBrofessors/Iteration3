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
        g2d.drawImage(image,xPixel* Settings.SCALEFACTOR,yPixel*Settings.SCALEFACTOR,itemWidth*Settings.SCALEFACTOR,itemHeight* Settings.SCALEFACTOR,null);
        g2d.dispose();
    };

    public void setLocation(int x, int y){
        xPixel = x*itemWidth - (x*(itemWidth))/4;
        yPixel = y*(itemHeight - 5) + ((itemHeight-7)*x)/2;
    }

    private void updateCoordinateToScreenPosition(int xOffset, int yOffset){
        xPixel =+ xOffset;
        yPixel =+ yOffset;
    }
}