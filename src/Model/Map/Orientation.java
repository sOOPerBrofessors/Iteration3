package Model.Map;

/**
 * Created by dyeung on 4/8/16.
 */
public enum Orientation {

    NORTH(0,-1),
    NORTHEAST(1,-1),
    SOUTHEAST(1,0),
    SOUTH(0,1),
    SOUTHWEST(-1,1),
    NORTHWEST(-1,0);

    //Since this is a structure we can have it public
    public int x;
    public int y;

    Orientation(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

