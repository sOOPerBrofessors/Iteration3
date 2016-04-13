package Model.Map;

import Utilities.ErrorLevel;
import Utilities.MessageHandler;
import Utilities.PersonFilter;

/**
 * Created by sgl on 4/5/16.
 */

//simple location class for 3D World
    //equals --> just like String.equals(passedInString)
    //setNewLocation --> location is set to new Location (works with Location or x,y,z)
public class Location {
    private int x,y,z;

    public Location (int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public boolean equals(Location location){
        if (location.x != this.x) return false;
        if (location.y != this.y) return false;
        if (location.z != this.z) return false;
        return true;
    }

    public void setNewLocation(Location location){
        this.x = location.x;
        this.y = location.y;
        this.z = location.z;
    }

    public void setNewLocation(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    //Added in
    public int getZ(){
        return z;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    //get adjacent locations
    public Location getAdjacentTop() {
        //TODO: check limit
        return new Location(x, y, z + 1);
    }

    public Location getAdjacentBottom() {
        if (z > 0)
            return new Location(x, y, z - 1);
        else {
            MessageHandler.println("Location: you are trying to reach out of map", ErrorLevel.NOTICE, PersonFilter.ANDY);
            return this;
        }
    }

    public Location getAdjacentNorth() {
        if (y > 0)
            return new Location(x, y - 1, z);
        else {
            MessageHandler.println("Location: you are trying to reach out of map", ErrorLevel.NOTICE, PersonFilter.ANDY);
            return this;
        }
    }

    public Location getAdjacentNorthEast() {
        if (y > 0) //TODO: check x limit
            return new Location(x + 1, y - 1, z);
        else {
            MessageHandler.println("Location: you are trying to reach out of map", ErrorLevel.NOTICE, PersonFilter.ANDY);
            return this;
        }
    }

    public Location getAdjacentSouthEast() {
        //TODO:check x and y limits
        return new Location(x + 1, y, z);
    }

    public Location getAdjacentSouth() {
        if (y < 100) //TODO: update y limit
            return new Location(x, y + 1, z);
        else {
            MessageHandler.println("Location: you are trying to reach out of map", ErrorLevel.NOTICE, PersonFilter.ANDY);
            return this;
        }
    }

    public Location getAdjacentSouthWest() {
        if (x > 0) //TODO: check y limit
            return new Location(x - 1, y + 1, z);
        else {
            MessageHandler.println("Location: you are trying to reach out of map", ErrorLevel.NOTICE, PersonFilter.ANDY);
            return this;
        }
    }

    public Location getAdjacentNorthWest() {
        if (x > 0 )
            return new Location(x - 1, y, z);
        else {
            MessageHandler.println("Location: you are trying to reach out of map", ErrorLevel.NOTICE, PersonFilter.ANDY);
            return this;
        }
    }
}
