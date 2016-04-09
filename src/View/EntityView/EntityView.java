package View.EntityView;

import Model.Entity.Entity;
import Model.Map.Orientation;
import Utilities.Observers.EntityObserver;
import Model.Map.Location;
import Utilities.Settings;
import View.MapView.MapObjectView;

import java.awt.*;

/**
 * Created by dyeung on 4/6/16.
 */
public abstract class EntityView extends MapObjectView implements EntityObserver{
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
        x = location.getX();
        y = location.getY();
        System.out.println("EntityView: " + x + "," + y + " : " + xPixel + "," + yPixel);
    }


    @Override
    public void setPixels(int x, int y, int z) {
        //System.out.println("EntityView: Updates pixels to:" + x +","+ y);
        xPixel = x;
        yPixel = y;
        //eventually z will offset yPixel by a certain amount
    }
}
