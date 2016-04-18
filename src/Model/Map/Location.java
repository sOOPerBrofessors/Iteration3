package Model.Map;

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
    public Location getAdjacent (Orientation orientation) {
        return new Location(x + orientation.x, y + orientation.y, z);
    }

    public Location getAdjacentTop() {
        return new Location(x, y, z + 1);
    }

    public Location getAdjacentBottom() {
        return new Location(x, y, z - 1);
    }

    public String toString(){
        return x+","+y+","+z;
    }
}