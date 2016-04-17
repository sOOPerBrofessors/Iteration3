package Utilities.AIStuff.Pathfinding;

import Model.Map.Location;
import Model.Map.Tile.Tile;

/**
 * Created by aseber on 4/16/16.
 */
public class TileLocationTuple {

    private Tile tile;
    private Location location;

    public TileLocationTuple(Tile tile, Location location) {

        this.tile = tile;
        this.location = location;

    }

    public Tile getTile() {

        return tile;

    }

    public Location getLocation() {

        return location;

    }

    public boolean equals(Object o) {

        if (o instanceof TileLocationTuple) {

            TileLocationTuple tuple = (TileLocationTuple) o;

            if (this.location.equals(tuple.location)) {

                return true;

            }

        }

        return false;

    }

}
