package Utilities.AIStuff.Pathfinding;

import Utilities.MathUtilities;

import java.util.HashSet;

/**
 * Created by aseber on 4/16/16.
 */
public class RawAStarPathFinding extends Pathfind {

    public RawAStarPathFinding(TileNode startNode, TileNode endNode) {

        super(startNode, endNode, startNode.getG() + MathUtilities.euclideanDistance(startNode.box.getLocation(), endNode.box.getLocation()));
        startNode.setG(0);

    }

    // A-Star implementation of pathfinding

    public void searchForPath() {

        TileNode currentNode;

        synchronized (this) {

            System.out.println("pathing start");

            do {


                currentNode = open.poll();

                if (currentNode.box.equals(endNode.box)) {

                    break;

                }

                addNodeToClosed(currentNode);
                HashSet<TileNode> neighboringNodes = currentNode.findNeighboringNodes();
                expandedCounter++;
                System.out.println("expanded: " + expandedCounter);

                for (TileNode neighbor : neighboringNodes) {

                    if (!closed.contains(neighbor)) {

                        double tentitive_g = currentNode.getG() + MathUtilities.euclideanDistance(neighbor.box.getLocation(), currentNode.box.getLocation());

                        if (!open.contains(neighbor) | tentitive_g < neighbor.getG()) {

                            neighbor.setParent(currentNode);
                            neighbor.setG(tentitive_g);

                            if (!open.contains(neighbor)) {

                                addNodeToOpen(neighbor, neighbor.getG() + MathUtilities.euclideanDistance(neighbor.box.getLocation(), endNode.box.getLocation()));

                            }

                        }

                    }

                }

            }

            while (!open.isEmpty() && !isExpandedCounterExceeded() && running);

            if (currentNode.box.equals(endNode.box)) {

                pathFound = true;
                endOfPath = currentNode;
                System.out.println("Path found! Retracing our steps and highlighting the path.");

            } else if (isExpandedCounterExceeded()) {

                System.out.println("Path could not be produced as counter expanded past the hard cap.");

            } else {

                System.out.println("Path could not be produced as there are no more nodes to be searched.");

            }

            running = false;

        }

    }

}