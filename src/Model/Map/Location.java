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

    //get adjacent locations, mainly used by InfluenceAreas
    public Location getAdjacentTop() {
        return new Location(x, y, z + 1);
    }

    public Location getAdjacentBottom() {
        return new Location(x, y, z - 1);
    }

    public Location getAdjacentNorth() {
        return new Location(x, y - 1, z);
    }

    public Location getAdjacentNorthEast() {
        return new Location(x + 1, y - 1, z);
    }

    public Location getAdjacentSouthEast() {
        return new Location(x + 1, y, z);
    }

    public Location getAdjacentSouth() {
        return new Location(x, y + 1, z);
    }

    public Location getAdjacentSouthWest() {
        return new Location(x - 1, y + 1, z);
    }

    public Location getAdjacentNorthWest() {
        return new Location(x - 1, y, z);
    }
}
