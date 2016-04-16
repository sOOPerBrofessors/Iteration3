package Model.Map;

/**
 * Created by dyeung on 4/8/16.
 */
public enum Orientation {

    NORTH(0,-1,0),
    NORTHEAST(1,-1,0),
    SOUTHEAST(1,0,0),
    SOUTH(0,1,0),
    SOUTHWEST(-1,1,0),
    NORTHWEST(-1,0,0),
    UP(0,0,1),
    DOWN(0,0,-1);
    //Since this is a structure we can have it public
    public int x;
    public int y;
    public int z;
    Orientation(int x, int y, int z) {
        this.x = x;
        this.y = y;
    }

}

