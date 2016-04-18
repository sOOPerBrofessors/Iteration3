package Controller.AI_Controller;

import Controller.AI_Controller.VisualCortex.VisualCortex;
import Controller.AI_Controller.VisualCortex.VisualCortexMemoryInterface;
import Controller.AI_Controller.VisualCortex.VisualInformation.VisualInformation;
import Model.Entity.Entity;
import Model.Map.Location;
import Model.Map.Map;
import Model.Map.Orientation;
import Model.Map.TileColumn;
import Utilities.AIStuff.Pathfinding.AStarPathFind;
import Utilities.ErrorLevel;
import Utilities.InfluenceAreas.Planer.RadialEffect;
import Utilities.MessageHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by aseber on 4/9/16.
 */
public class AI_Controller {

    Map map;

    public void setMap(Map map) {

        this.map = map;

    }

    public boolean move(Entity entity, Orientation orientation) {

        if (map == null) {

            MessageHandler.println("AI_Controller: Map null in move method call", ErrorLevel.ERROR);
            throw new NullPointerException();

        }

        return entity.move(map, orientation);

    }

    public ArrayList<Orientation> findPath(Entity entity, Location location) {

        return AStarPathFind.getPath(map, entity, location);

    }

    public boolean canMove(Entity entity, Orientation orientation) {

        return entity.canMove(map, orientation);

    }

    public ArrayList<Orientation> moveableOrientations(Entity entity) {

        ArrayList<Orientation> orientations = new ArrayList<>();

        for (Orientation orientation : Orientation.values()) {

            if (canMove(entity, orientation)) {

                orientations.add(orientation);

            }

        }

        return orientations;

    }

    public HashMap<Location, TileColumn> getColumns(VisualCortexMemoryInterface memoryInterface) {

        HashMap<Location, TileColumn> columns = new HashMap<>();

        ArrayList<Location> locations = RadialEffect.getRadialArea(memoryInterface.getNPC().getLocation(), memoryInterface.getNPC().getRadiusVisibility());

        for (Location location : locations) {

            TileColumn column = map.getTileColumn(location.getX(), location.getY());

            if (column != null) {

                columns.put(location, column);

            }

        }

        return columns;

    }

}
