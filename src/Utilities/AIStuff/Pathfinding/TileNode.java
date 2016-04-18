package Utilities.AIStuff.Pathfinding;

import Model.Map.Location;
import Model.Map.Map;

import java.util.HashSet;

/**
 * Created by aseber on 4/16/16.
 */
public class TileNode extends Node { // Wrapper class for boxes that contains a reference to a parent node, used to traverse backwards once the endBox has been located

    protected TileLocationTuple box;
    public TileNode parentNode;
    protected Map map;

    public TileNode(TileLocationTuple current_Box, TileNode parent_Node, Map map) {

        this.box = current_Box;
        this.map = map;
        this.parentNode = parent_Node;

    }

    public HashSet<TileNode> findNeighboringNodes() {

        Location currLocation = this.box.getLocation();
        HashSet<TileLocationTuple> neighboringBoxes = map.getTileNeighbors(currLocation.getX(), currLocation.getY(), currLocation.getZ());
        HashSet<TileNode> neighboringNodes = new HashSet<>();

        for (TileLocationTuple neighboringBox : neighboringBoxes) {

            TileNode node = new TileNode(neighboringBox, this, this.map);
            neighboringNodes.add(node);

        }

        return neighboringNodes;

    }

    public void setParent(TileNode node) {

        this.parentNode = node;

    }

    @Override
    public boolean equals(Object o) {

        if (o instanceof TileNode) {

            TileNode node = (TileNode) o;

            if (this.box.equals(node.box)) {

                return true;

            }

        }

        return false;

    }

}
