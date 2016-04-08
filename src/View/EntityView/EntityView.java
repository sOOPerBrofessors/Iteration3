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
    protected int entityWidth = 30;
    protected int entityHeight = 48;
    protected int xPixel; // on the map
    protected int yPixel; // on the map
    protected Location location;

    public EntityView(Location location){
        this.location = location;
        x = location.getX();
        y = location.getY();
        updateCoordinateToScreenPosition();
        System.out.println("EntityView: initial: " + x + "," + y );
    }
    //Function will create the x/y position on the actual screen
    public void updateCoordinateToScreenPosition(){
        //Might need to delegate to another class
        int xCenter = entityWidth/2;
        int yCenter = entityHeight/2;
        xPixel = xCenter + x*tileWidth - (x*(tileWidth-5))/4;
        yPixel = yCenter + y*(tileHeight - 7) + ((tileHeight-12)*x)/2;
    }
    @Override
    public void updateMove(Location direction) {
        System.out.println("EntityView: Before: " + x + "," + y + " : " + xPixel + "," + yPixel);

        x += direction.getX();
        y += direction.getY();
        updateCoordinateToScreenPosition();

        System.out.println("EntityView: After: " + x + "," + y + " : " + xPixel + "," + yPixel);

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
