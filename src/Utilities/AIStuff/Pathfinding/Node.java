package Utilities.AIStuff.Pathfinding;

/**
 * Created by aseber on 4/16/16.
 */

public abstract class Node { // Abstract class for RegionNode and BoxNode

    protected Node parentNode;
    private double f, g;

    public Node(Node parent_Node) {

        this.parentNode = parent_Node;

    }

    public final void setF(double f) {

        this.f = f;

    }

    public final double getF() {

        return this.f;

    }

    public final void setG(double g) { // Cost from current to beginning. Necessary for A*

        this.g = g;

    }

    public final double getG() {

        return this.g;

    }

    public void setParent(Node node) {

        this.parentNode = node;

    }

}