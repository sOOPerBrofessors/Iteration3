package View.EntityView;

import Model.Entity.Entity;
import Model.Map.Orientation;
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
    protected Orientation orientation;
    protected Entity entity; //property that  is being observered
    public EntityView(Entity observerable){
        entity = observerable;
        location = entity.getLocation();
        orientation = entity.getOrientation();
        x = location.getX();
        y = location.getY();
        updateCoordinateToScreenPosition();
        //System.out.println("EntityView: initial: " + x + "," + y );
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
    public void updateMove() {
        updateLocation();
    }

    public void updateOrientation(){
        orientation = entity.getOrientation();
    }
    private void updateLocation(){
        updateOrientation();
        System.out.println("EntityView: Before: " + x + "," + y + " : " + xPixel + "," + yPixel);

        x = location.getX();
        y = location.getY();
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
    public Location getEntityViewLocation(){
        return location;
    }

    //I MIGHT ONLY NEED ONE BUT I DONT WANT TO DELETE IN CASE I FUCK UP LATER
//    @Override
//    public void updateMoveN() {
//        updateLocation();
//    }
//
//    @Override
//    public void updateMoveNW() {
//        updateLocation();
//    }
//
//    @Override
//    public void updateMoveNE() {
//        updateLocation();
//    }
//
//    @Override
//    public void updateMoveS() {
//        updateLocation();
//    }
//
//    @Override
//    public void updateMoveSW() {
//        updateLocation();
//
//    }
//
//    @Override
//    public void updateMoveSE() {
//        updateLocation();
//
//    }
}
