package View.TerrainView;

import Model.Map.Location;
import Utilities.Settings;
import View.MapView.MapObjectView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
    //Not sure if what we need or not. Essentially a TileView will contain a set of viewable objects to paint
    public TileView(){
    }

    public void setPixels(int x, int y){
        xPixel = x;
        yPixel = y;
    }
    public void setLocation(int x, int y, int z){
        location = new Location(x,y,z);
    }
    public abstract void paintComponent(Graphics g);
}
