package View.EntityView;

import Utilities.Observers.EntityObserver;
import Model.Map.Location;
import Utilities.Settings;

import javax.swing.*;

/**
 * Created by dyeung on 4/6/16.
 */
public abstract class EntityView extends JComponent implements EntityObserver{
    private int x; // on the coordinate system
    private int y; // on the coordinate system
    private int tileWidth = Settings.TILEWIDTH;
    private int tileHeight = Settings.TILEHEIGHT;
    protected int xPixel; // on the map
    protected int yPixel; // on the map
    protected Location location;

    public EntityView(Location location){
        this.location = location;
        x = location.getX();
        y = location.getY();
        updateCoordinateToScreenPosition();
    }
    //Function will create the x/y position on the actual screen
    public void updateCoordinateToScreenPosition(){
        //Might need to delegate to another class
        xPixel = x*tileWidth - (x*tileWidth)/4;
        yPixel = y*tileHeight + (tileHeight*x)/2;
    }
    @Override
    public void updateMove(Location direction) {
        System.out.println("Before: " + x + "," + y + " : " + xPixel + "," + yPixel);

        x += direction.getX();
        y += direction.getY();
        updateCoordinateToScreenPosition();

        System.out.println("After: " + x + "," + y + " : " + xPixel + "," + yPixel);

    }
    public void updateCameraOffset (Location location){
        xPixel += location.getX();
        yPixel += location.getY();
    }
    public int getXPixel(){
        return xPixel;
    }
    public int getYPixel(){
        return yPixel;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public Location getEntityLocation(){
        return location;
    }
}
