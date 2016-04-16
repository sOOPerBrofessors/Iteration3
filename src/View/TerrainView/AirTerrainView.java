package View.TerrainView;

import Model.Map.Tile.Tile;

import java.awt.*;

/**
 * Created by dyeung on 4/9/16.
 */
public class AirTerrainView extends TerrainView {
    public AirTerrainView() {
        super(null);
    }

    @Override
    public void paintComponent(Graphics g) {
        //Doesn't paint anything but the entity
    }

    @Override
    public void renderDebug(Graphics g, int xLocation, int yLocation) {
        //Don't do anything
    }
}
