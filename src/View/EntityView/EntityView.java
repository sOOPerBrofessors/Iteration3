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

    private int x; // on the coordinate system
    private int y; // on the coordinate system

    protected OrientationView orientationView;
    protected int entityWidth = Settings.ENTITYWIDTH;
    protected int entityHeight = Settings.ENTITYHEIGHT;
    protected int xPixel; // on the map
    protected int yPixel; // on the map
    protected Location location;
    protected Orientation orientation;
    protected Character entity; //property that  is being observered


    public EntityView(Character observerable){
        entity = observerable;
        observerable.addObserver(this);
        location = entity.getLocation();
        orientation = entity.getOrientation();
        x = location.getX();
        y = location.getY();
    }


    @Override
    public void updateMove() {
        //System.out.println("update move");
        updateLocation();
        updateOrientation();
    }
    public abstract void updateOrientation();

    private void updateLocation(){
        x = location.getX();
        y = location.getY();
        //System.out.println("EntityView: " + x + "," + y + " : " + xPixel + "," + yPixel);
    }

    @Override
    public void setPixels(int x, int y) {
        xPixel = x;
        yPixel = y;
    }

    public void removeObservable(){
        entity.removeObserver(this);
    }
}
