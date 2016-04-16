package View.ItemView;

import Model.Map.Location;
import Utilities.ErrorLevel;
import Utilities.MessageHandler;
import Utilities.PersonFilter;
import Utilities.Settings;
import View.MapView.MapObjectView;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dyeung on 4/9/16.
 */
public abstract class ItemView  extends MapObjectView {

    protected Image image;
    protected int itemWidth;
    protected int itemHeight;
    protected int x;
    protected int y;
    protected int xPixel; // on the map
    protected int yPixel; // on the map

    @Override
    public void paintComponent(Graphics2D g2d){
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //g2d.drawImage(image, xPixel, yPixel, itemWidth, itemHeight, null);
//        g2d.setColor(Color.blue);
//        g2d.drawRect(xPixel, yPixel, 50, 50);
//        g2d.drawString(x +"," + y, xPixel, yPixel);
        g2d.drawImage(image,xPixel*Settings.SCALEFACTOR,yPixel*Settings.SCALEFACTOR,itemWidth*Settings.SCALEFACTOR,itemHeight*Settings.SCALEFACTOR, null);
        g2d.dispose();
    }

    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }


    public void setPixels(int xPixel, int yPixel){
        this.xPixel = xPixel;
        this.yPixel = yPixel;
        adjustHeight();
    }
    @Override
    protected void adjustHeight(){

    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}