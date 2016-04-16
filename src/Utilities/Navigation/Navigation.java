package Utilities.Navigation;

import Model.Map.Tile.Terrain.Terrain;
import Model.Map.Tile.Tile;
import Model.Entity.Entity;

import Utilities.Navigation.NavStrategy.*;

/**
 * Created by broskj on 4/5/16.
 *
 * Navigation class used by all Entities.  Handles movement based on implemented
 *  movement strategy.
 */
public class Navigation {

    NavStrategy s;

    //private constructor to be called by factory methods

    private Navigation(NavStrategy s) {
        this.s = s;
    } // end private constructor


    //factory methods which return new specific implementations of a Navigation object

    public static Navigation makeAvianNav() {
        return new Navigation(new AvianStrategy());
    } // end makeAvianNav

    public static Navigation makeAquaticNav() {
        return new Navigation(new AquaticStrategy());
    } // end makeAquaticNav

    public static Navigation makeBoatNav() {
        return new Navigation(new BoatStrategy());
    } // end makeBoatNav

    public static Navigation makeCharNav() {
        return new Navigation(new CharStrategy());
    } // end makeCharNav

    public static Navigation makeProjectileNav() {
        return new Navigation(new ProjectileStrategy());
    } // end makeProjectileNav

    public static Navigation makeVehicleNav() {
        return new Navigation(new VehicleStrategy());
    } // end makeVehicleNav

    /*
    on each movement call from the controller, this method is called with the
     entity requesting to move and its target tile.

    the local NavStrategy handles calling the target tile's move operation which
     either allows or disallows the entity to move.*/

    public boolean move(Tile targetTile, Entity entity) {
       // System.out.println("Navigation: target position:" + entity.getLocation().getX() + "," + entity.getLocation().getY());
        if (targetTile == null) return false;
        if(s != null)
            return s.move(targetTile, entity);
        return false;
    } // end move

    public boolean canMove(Terrain terrain) {

        return s.canMove(terrain);

    }
    public boolean canMove(Tile tile) {

        return s.canMove(tile.getTerrain());

    }

    public void move(Terrain terrain, Entity entity){
        //s.move(terrain,entity);

    }

} // end class Navigation
