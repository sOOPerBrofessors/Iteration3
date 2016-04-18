package View.EntityView;

import Model.Map.Orientation;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dyeung on 4/14/16.
 */
public class OrientationView {
    private Image currentDirectionImage;
    private final Image north;
    private final Image northWest;
    private final Image northEast;
    private final Image south;
    private final Image southWest;
    private final Image southEast;

    private Map<Orientation, Runnable> commands;

    public OrientationView(Orientation orientation, Image north, Image northWest, Image northEast, Image south, Image southEast, Image southWest){
        this.north = north;
        this.northWest = northWest;
        this.northEast = northEast;
        this.south = south;
        this.southWest = southWest;
        this.southEast = southEast;
        initCommands();
        commands.get(orientation).run();
    }
    private void initCommands(){
        commands = new HashMap<>();
        commands.put(Orientation.NORTH, this::setNorth);
        commands.put(Orientation.NORTHWEST, this::setNorthWest);
        commands.put(Orientation.NORTHEAST, this::setNorthEast);
        commands.put(Orientation.SOUTH, this::setSouth);
        commands.put(Orientation.SOUTHWEST, this::setSouthWest);
        commands.put(Orientation.SOUTHEAST, this::setSouthEast);
    }
    public void setDirection(Orientation orientation){
        commands.get(orientation).run();
    }
    public Image getCurrentDirectionImage(){
        return currentDirectionImage;
    }
    private void setNorth(){
        currentDirectionImage = north;
    }
    private void setNorthWest(){
        currentDirectionImage = northWest;
    }
    private void setNorthEast(){
        currentDirectionImage = northEast;
    }
    private void setSouth(){
        currentDirectionImage = south;
    }
    private void setSouthWest(){
        currentDirectionImage = southWest;
    }
    private void setSouthEast(){
        currentDirectionImage = southEast;
    }
}