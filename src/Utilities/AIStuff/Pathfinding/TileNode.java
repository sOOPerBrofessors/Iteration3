package Utilities.AIStuff.Pathfinding;

import Model.Map.Location;
import Model.Map.Map;
import Model.Map.Tile.Tile;

import java.util.HashSet;

/**
 * Created by aseber on 4/16/16.
 */
public class TileNode extends Node { // Wrapper class for boxes that contains a reference to a parent node, used to traverse backwards once the endBox has been located

    protected TileLocationTuple box;
    protected TileNode parentNode;
    protected Map map;

    public TileNode(TileLocationTuple current_Box, TileNode parent_Node, Map map) {

        super(parent_Node);
        this.box = current_Box;
        this.map = map;

    }

    public HashSet<TileNode> findNeighboringNodes(Location location) { // simply converts valid boxes to valid nodes

        HashSet<TileLocationTuple> neighboringBoxes = map.getTileNeighbors(location.getX(), location.getY(), location.getZ());
        HashSet<TileNode> neighboringNodes = new HashSet<TileNode>();

        for (TileLocationTuple neighboringBox : neighboringBoxes) {

            neighboringNodes.add(new TileNode(neighboringBox, this, this.map));

        }

        return neighboringNodes;

    }

    public void setParent(TileNode node) {

        this.parentNode = node;

    }

    @Override
    public boolean equals(Object o) {

        TileNode node = (TileNode) o;

        if (this.box.equals(node.box)) {// && this.parentNode.box.equals(node.parentNode.box) && this.pathCost == node.pathCost) {

            return true;

        }

        return false;

    }

}
