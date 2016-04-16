package Utilities.AIStuff.Pathfinding;

import Model.Map.Tile.Tile;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Created by aseber on 4/16/16.
 */

public abstract class Pathfind implements Runnable { // Abstract class that all of the pathfinding algorithms are based on

    protected TileNode startNode;
    protected TileNode endNode;
    protected double expandedCounter;
    protected final double EXPANDED_COUNTER_HARD_CAP = 100000;
    protected boolean running = false;
    protected boolean pause = false;
    protected boolean pathFound = false;
    protected HashSet<Tile> allowedBoxes;
    protected BestPathComparator comparator = new BestPathComparator();
    protected PriorityQueue<TileNode> open = new PriorityQueue<TileNode>(10, comparator);
    protected PriorityQueue<TileNode> closed = new PriorityQueue<TileNode>(10, comparator);
    protected TileNode endOfPath = null;

    public Pathfind(TileNode startNode, TileNode endNode, double f) {

        this.startNode = startNode;
        this.endNode = endNode;
        addNodeToOpen(startNode, f);

    }

    //static abstract class BestPathComparator implements Comparator<Node> {};

    static class BestPathComparator implements Comparator<Node> {

        public int compare(Node node, Node node2) {

            return Double.compare(node.getF(), node2.getF());

        }

    }

    public final void run() {

        running = true;
        searchForPath();

    }

    public abstract void searchForPath();

    protected final boolean isRunning() {

        return running;

    }

    public final void end() {

        running = false;

    }

    protected final void addNodeToOpen(TileNode node, double f) {

        node.setF(f);
        open.add(node);

    }

    protected final void addNodeToClosed(TileNode node) {

        closed.add(node);

    }

    protected final void returnPath(TileNode endNode) {

        TileNode currentNode = endOfPath;

        do {

            currentNode = currentNode.parentNode;

        }

        while (!currentNode.box.equals(startNode.box));

    }

    protected synchronized final boolean isPathFound() {

        try {

            notifyAll();

        } catch (IllegalMonitorStateException e) {}

        return pathFound;

    }

    public final Node path() {

        if (pathFound) {

            return endNode;

        }

        return null;

    }

    public synchronized final void waitForFinish() {

        if (!isPathFound()) {

            try {

                wait();

            } catch (InterruptedException e) {}

        }

    }

    protected final double getExpandedCounter() {

        return expandedCounter;

    }

    protected final boolean isExpandedCounterExceeded() {

        return getExpandedCounter() > EXPANDED_COUNTER_HARD_CAP;

    }

}