package View.TerrainView;

import Model.Map.Tile.Tile;

import java.awt.*;

/**
 * Created by dyeung on 4/9/16.
 */
public class AirTileView extends TileView {
    public AirTileView(Tile tile) {
        super(tile);
    }

    @Override
    public void paintComponent(Graphics g) {
        //Doesn't paint anything but the entity
    }
}
