package Utilities.AIStuff.Pathfinding;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by aseber on 4/16/16.
 */

public abstract class Pathfind implements Runnable { // Abstract class that all of the pathfinding algorithms are based on

    private final TileNode startNode;
    final TileNode endNode;
    int expandedCounter;
    private final double EXPANDED_COUNTER_HARD_CAP = 1000;
    boolean running = false;
    boolean pathFound = false;
    private final BestPathComparator comparator = new BestPathComparator();
    final PriorityQueue<TileNode> open = new PriorityQueue<>(10, comparator);
    final PriorityQueue<TileNode> closed = new PriorityQueue<>(10, comparator);
    TileNode endOfPath = null;

    Pathfind(TileNode startNode, TileNode endNode, double f) {

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

    protected abstract void searchForPath();

    protected final boolean isRunning() {

        return running;

    }

    public final void end() {

        running = false;

    }

    final void addNodeToOpen(TileNode node, double f) {

        node.setF(f);
        open.add(node);

    }

    final void addNodeToClosed(TileNode node) {

        closed.add(node);

    }

    protected final void returnPath(TileNode endNode) {

        TileNode currentNode = endOfPath;

        do {

            currentNode = currentNode.parentNode;

        }

        while (!currentNode.box.equals(startNode.box));

    }

    private synchronized boolean isPathFound() {

        try {

            notifyAll();

        } catch (IllegalMonitorStateException e) {}

        return pathFound;

    }

    public final Node path() {

        if (pathFound) {

            return endOfPath;

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

    private double getExpandedCounter() {

        return expandedCounter;

    }

    final boolean isExpandedCounterExceeded() {

        return getExpandedCounter() > EXPANDED_COUNTER_HARD_CAP;

    }

}