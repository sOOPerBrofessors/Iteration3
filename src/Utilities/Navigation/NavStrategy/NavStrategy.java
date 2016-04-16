package Utilities.Navigation.NavStrategy;

import Model.Entity.Entity;
import Model.Map.Tile.Terrain.Terrain;
import Model.Map.Tile.Tile;
import Utilities.Visitor.TerrainVisitor;

/**
 * Created by broskj on 4/5/16.
 *
 * NavStrategy interface to be implemented by different movement strategy classes.
 *  Overridden methods will specify which 'targetTile.move(entityType)' method to
 *  call, which handle tile movement different for certain entity types.
 */
public abstract class NavStrategy implements TerrainVisitor {
    protected boolean canMoveFlag;
    public boolean canMove(Terrain terrain){
        terrain.acceptTerrainVisitor(this);
        return canMoveFlag;
    }
    public abstract boolean move(Tile targetTile, Entity entity);

    //For this to be true you have to set canMoveFlag to true
    @Override
    public void visitWaterTerrain() {
        //Do nothing
        canMoveFlag = false;
    }

    @Override
    public void visitGrassTerrain() {
        //Do nothing
        canMoveFlag = false;
    }

    @Override
    public void visitAirTerrain() {
        //Do nothing
        canMoveFlag = false;
    }

    @Override
    public void visitRiverTerrain() {
        //Do nothing
        canMoveFlag = false;
    }

    @Override
    public void visitDirtTerrain() {
        //Do nothing
        canMoveFlag = false;
    }
} // end interface NavStrategy
