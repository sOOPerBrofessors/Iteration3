package Utilities.Visitor;

import Model.Entity.Entity;
import Model.Map.Location;
import Model.Map.Tile.Tile;
import View.TerrainView.TileView;

/**
 * Created by dyeung on 4/7/16.
 */
public interface TileVisitor {
    void visitWaterTile(Tile tile);
    void visitGrassTile(Tile tile);
    void visitAirTile(Tile tile);
    void visitRiverTile(Tile tile);
    void visitDirtTile(Tile tile);
}
