package View.ItemView;

import Model.Map.Location;
import Utilities.ErrorLevel;
import Utilities.MessageHandler;
import Utilities.PersonFilter;
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

    public void paintComponent(Graphics2D g2d){
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //System.out.println(image.toString());
        g2d.drawImage(image,xPixel*Settings.SCALEFACTOR,yPixel*Settings.SCALEFACTOR,itemWidth*Settings.SCALEFACTOR,itemHeight*Settings.SCALEFACTOR, null);
        g2d.dispose();
    }

    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setPixels(int xPixel, int yPixel){
        this.xPixel = xPixel + 30;
        this.yPixel = yPixel + 10;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}