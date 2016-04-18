package Utilities.AIStuff.Pathfinding;

import Utilities.ErrorLevel;
import Utilities.MathUtilities;
import Utilities.MessageHandler;
import Utilities.PersonFilter;

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

            do {


                currentNode = open.poll();

                if (currentNode.box.equals(endNode.box)) {

                    break;

                }

                addNodeToClosed(currentNode);
                HashSet<TileNode> neighboringNodes = currentNode.findNeighboringNodes();
                expandedCounter++;

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
                MessageHandler.println("Path found! Retracing our steps and highlighting the path.", ErrorLevel.NOTICE, PersonFilter.AUSTIN);

            } else if (isExpandedCounterExceeded()) {

                MessageHandler.println("Path could not be produced as counter expanded past the hard cap.", ErrorLevel.NOTICE, PersonFilter.AUSTIN);

            } else {

                MessageHandler.println("Path could not be produced as there are no more nodes to be searched.", ErrorLevel.NOTICE, PersonFilter.AUSTIN);

            }

            running = false;
            notifyAll();

        }

    }

}