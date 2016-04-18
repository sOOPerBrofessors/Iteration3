package Model.Map;

/**
 * Created by dyeung on 4/8/16.
 */
public enum Orientation {

    NORTH(0,-1,0, "north"),
    NORTHEAST(1,-1,0, "northEast"),
    SOUTHEAST(1,0,0, "southEast"),
    SOUTH(0,1,0, "south"),
    SOUTHWEST(-1,1,0, "southWest"),
    NORTHWEST(-1,0,0, "northWest");
//    UP(0,0,1),
//    DOWN(0,0,-1);
    //Since this is a structure we can have it public
    public int x;
    public int y;
    public int z;
    private String name;
    Orientation(int x, int y, int z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    //This is needed for load save
    public String toString(){
        return name;
    }

}

