package Utilities.Visitor;


/**
 * Created by dyeung on 4/7/16.
 */
public interface TerrainVisitor {
    void visitWaterTerrain();
    void visitGrassTerrain();
    void visitAirTerrain();
    void visitRiverTerrain();
    void visitDirtTerrain();

}
