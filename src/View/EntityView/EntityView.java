package View.EntityView;

import Model.Entity.Character.Character;
import Model.Entity.Entity;
import Model.Map.Orientation;
import Utilities.ErrorLevel;
import Utilities.MessageHandler;
import Utilities.Observers.EntityObserver;
import Model.Map.Location;
import Utilities.PersonFilter;
import Utilities.Settings;
import View.MapView.MapObjectView;

import java.awt.*;

/**
 * Created by dyeung on 4/6/16.
 */
public abstract class EntityView extends MapObjectView implements EntityObserver{
    //Honestly the x and y shouldn't matter, its only for printing on the coordinate system and testing
    protected int x; // on the coordinate system
    protected int y; // on the coordinate system

    protected OrientationView orientationView;
    protected int xPixel; // on the map
    protected int yPixel; // on the map
    protected Orientation orientation;

    /*Entity is private because it is only available to update its position and orientation.
    All the view rendering must be done by that specific class. This is to avoid specific items
    being rendered at wrong times (IE a projectile having a health bar). The projectile should have its own orientation view
    to render
    */
    protected Entity entity; //property that  is being observered


    public EntityView(Entity observerable){
        entity = observerable;
        observerable.addObserver(this);
        orientation = entity.getOrientation();
        x = entity.getX();
        y = entity.getY();
    }


    @Override
    public void updateMove() {
        //System.out.println("update move");
        updateLocation();
        updateOrientation();
    }
    public abstract void updateOrientation();

    private void updateLocation(){
        x = entity.getX();
        y = entity.getY();
    }

    @Override
    public void setPixels(int x, int y) {
        xPixel = x;
        yPixel = y;
        adjustHeight();
    }

    public void removeObservable(){
        entity.removeObserver(this);
    }
}
