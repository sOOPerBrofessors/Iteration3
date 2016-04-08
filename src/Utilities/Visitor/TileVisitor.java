package Utilities.Visitor;

import Model.Map.Location;
import View.TerrainView.TileView;

/**
 * Created by dyeung on 4/7/16.
 */
public interface TileVisitor {
    TileView createWaterTile(Location location);
    TileView createGrassTile(Location location);
    TileView createAirTile(Location location);
    TileView createRiverTile(Location location);
}
