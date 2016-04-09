package View.TerrainView;

import Model.Map.Location;
import Utilities.Settings;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dyeung on 4/7/16.
 */
public abstract class TileView extends JComponent{
    protected Location location;
    protected int tileWidth = Settings.TILEWIDTH;
    protected int tileHeight = Settings.TILEHEIGHT;
    protected int xPixel; // on the map
    protected int yPixel; // on the map
    protected Image image;

    public TileView(Location location){
        this.location = location;
        updateCoordinateToScreenPosition();
    }


    protected void updateCoordinateToScreenPosition(){
        int x = location.getX();
        int y = location.getY();
        int xCenter = tileWidth/2;
        int yCenter = tileHeight/2;
        xPixel = xCenter + x*tileWidth - (x*(tileWidth))/4;
        //yPixel = y*tileHeight + (tileHeight*x)/2;
        yPixel = yCenter + y*(tileHeight - 5) + ((tileHeight-7)*x)/2;
    }

    public void updateCameraOffset(Location location){
        updateCoordinateToScreenPosition();
        xPixel += location.getX();
        yPixel += location.getY();
    }
    public abstract void paintComponent(Graphics g);
}
