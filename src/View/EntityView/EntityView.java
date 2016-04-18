package View.EntityView;

import Model.Entity.Entity;
import Model.Map.Orientation;
import Utilities.Observers.EntityObserver;
import View.MapView.MapObjectView;

/**
 * Created by dyeung on 4/6/16.
 */
public abstract class EntityView extends MapObjectView implements EntityObserver{
    //Honestly the x and y shouldn't matter, its only for printing on the coordinate system and testing
    private int x; // on the coordinate system
    private int y; // on the coordinate system

    OrientationView orientationView;
    int xPixel; // on the map
    int yPixel; // on the map
    Orientation orientation;

    /*Entity is private because it is only available to update its position and orientation.
    All the view rendering must be done by that specific class. This is to avoid specific items
    being rendered at wrong times (IE a projectile having a health bar). The projectile should have its own orientation view
    to render
    */
    private final Entity entity; //property that  is being observered


    EntityView(Entity observerable){
        entity = observerable;
        observerable.addObserver(this);
        orientation = entity.getOrientation();
        x = entity.getX();
        y = entity.getY();
    }

    @Override
    public void updateMove() {
        updateLocation();
        updateOrientation();
    }
    protected abstract void updateOrientation();

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