package View.EntityView;

import Model.Map.Orientation;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dyeung on 4/14/16.
 */
public class OrientationView {
    private Image currentDirectionImage;
    private Image north;
    private Image northWest;
    private Image northEast;
    private Image south;
    private Image southWest;
    private Image southEast;

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
        commands.put(Orientation.NORTH, () -> setNorth());
        commands.put(Orientation.NORTHWEST, () -> setNorthWest());
        commands.put(Orientation.NORTHEAST, () -> setNorthEast());
        commands.put(Orientation.SOUTH, () -> setSouth());
        commands.put(Orientation.SOUTHWEST, () -> setSouthWest());
        commands.put(Orientation.SOUTHEAST, () -> setSouthEast());
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
