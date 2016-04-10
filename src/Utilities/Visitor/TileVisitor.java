package Utilities.Visitor;

import Model.Entity.Entity;
import Model.Map.Location;
import Model.Map.Tile.Tile;
import View.TerrainView.TileView;

/**
 * Created by dyeung on 4/7/16.
 */
public interface TileVisitor {
    void createWaterTile(Tile tile);
    void createGrassTile(Tile tile);
    void createAirTile(Tile tile);
    void createRiverTile(Tile tile);
    void createDirtTile(Tile tile);
}
