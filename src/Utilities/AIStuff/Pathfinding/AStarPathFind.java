package Utilities.AIStuff.Pathfinding;

import Model.Entity.Entity;
import Model.Map.Location;
import Model.Map.Map;
import Model.Map.Orientation;
import Utilities.MathUtilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by aseber on 4/16/16.
 */
public class AStarPathFind {

    // Returns an arraylist of orientations, those orientations describe the path that we need to take to move
    // from our current location to the endLocation
    public static final ArrayList<Orientation> getPath(Map map, Entity startEntity, Location endLocation) {

        Location startLocation = startEntity.getLocation();
        TileLocationTuple startTuple = new TileLocationTuple(map.getTile(startLocation), startLocation);
        TileNode startNode = new TileNode(startTuple, null, map);

        TileLocationTuple endTuple = new TileLocationTuple(map.getTile(endLocation), endLocation);
        TileNode endNode = new TileNode(endTuple, null, map);

        RawAStarPathFinding pathing = new RawAStarPathFinding(startNode, endNode);
        pathing.run();

        if (!pathing.pathFound) {

            return new ArrayList<>();

        }

        return convertNodeToOrientation((TileNode) pathing.path(), startNode);

    }

    public static final ArrayList<Orientation> getPath(Map map, Entity startEntity, Entity endEntity) {

        return getPath(map, startEntity, endEntity.getLocation());

    }

    private static final ArrayList<Orientation> convertNodeToOrientation(TileNode endPathNode, TileNode startNode) {

        ArrayList<Orientation> orientations = new ArrayList<>();

        TileNode lastNode;
        TileNode currentNode = endPathNode;

        while (!currentNode.equals(startNode)) {

            lastNode = currentNode;
            currentNode = currentNode.parentNode;
            Orientation orientation = getTileOrientationRelationship(currentNode.box.getLocation(), lastNode.box.getLocation());
            orientations.add(0, orientation);

        }

        return orientations;

    }

    private static final Orientation getTileOrientationRelationship(Location beginning, Location end) {

        Location subtraction = MathUtilities.subtractLocations(end, beginning);
        int x = (int) Math.signum(subtraction.getX());
        int y = (int) Math.signum(subtraction.getY());
        return Orientation.getOrientation(x, y);

    }

}
