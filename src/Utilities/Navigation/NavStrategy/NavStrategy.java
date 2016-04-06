package Utilities.Navigation.NavStrategy;

import Model.Entity.Entity;

import Model.Map.Tile.Tile;

/**
 * Created by broskj on 4/5/16.
 *
 * NavStrategy interface to be implemented by different movement strategy classes.
 *  Overridden methods will specify which 'targetTile.move(entityType)' method to
 *  call, which handle tile movement different for certain entity types.
 */
public interface NavStrategy {
    public void move(Tile targetTile, Entity entity);
} // end interface NavStrategy
