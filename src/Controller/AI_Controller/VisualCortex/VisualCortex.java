package Controller.AI_Controller.VisualCortex;

import Controller.AI_Controller.VisualCortex.VisualInformation.VisualInformation;
import Model.Map.Location;
import Model.Map.Tile.Tile;
import Model.Map.TileColumn;
import Utilities.MathUtilities;
import Utilities.Tickable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by aseber on 4/6/16.
 */
public class VisualCortex implements Tickable {

    private VisualCortexMemoryInterface memory;

    public VisualCortex(VisualCortexMemoryInterface memory) {

        this.memory = memory;

    }

    public void tick() {

        VisualInformation newVisualInformation = new VisualInformation();
        HashMap<Location, TileColumn> columns = memory.getNPC().getController().getColumns(memory);

        for (Map.Entry<Location, TileColumn> entry : columns.entrySet()) {

            for (int i = 0; i < entry.getValue().getMaxSize(); ++i) {

                Tile tile = entry.getValue().getTileAt(i);

                if (tile.hasCharacter()) {

                    double distance = MathUtilities.euclideanDistance(memory.getNPC().getLocation(), entry.getKey());
                    newVisualInformation.addEntityVisualInformation(tile.getCharacter(), distance);

                }

            }

        }

        memory.setVisualInformation(newVisualInformation);
    }
}
