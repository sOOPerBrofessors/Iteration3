package Utilities.AIStuff;

import Model.Entity.Entity;
import Model.Map.Location;
import Model.Map.Orientation;

import java.util.ArrayList;

/**
 * Created by aseber on 4/16/16.
 */
public class PathFind {

    // Returns an arraylist of orientations, those orientations describe the path that we need to take to move
    // from our current location to the endLocation
    public static final ArrayList<Orientation> getPath(Entity startEntity, Location endLocation) {

        ArrayList<Orientation> path = new ArrayList<>();



        return path;

    }

    public static final ArrayList<Orientation> getPath(Entity startEntity, Entity endEntity) {

        return getPath(startEntity, endEntity.getLocation());

    }

}
