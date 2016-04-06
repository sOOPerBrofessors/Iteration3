package Utilities.Navigation;

import Utilities.Navigation.NavStrategy.*;

/**
 * Created by broskj on 4/5/16.
 *
 * Navigation class used by all Entities.  Handles movement based on implemented
 *  movement strategy.
 */
public class Navigation {
    NavStrategy s;

    /*
    private constructor to be called by factory methods
     */
    private Navigation(NavStrategy s) {
        this.s = s;
    } // end private constructor

    /*
    factory methods which return new specific implementations of a Navigation object
     */
    public Navigation makeAvianNav() {
        return new Navigation(new AvianStrategy());
    } // end makeAvianNav

    public Navigation makeAquaticNav() {
        return new Navigation(new AquaticStrategy());
    } // end makeAquaticNav

    public Navigation makeBoatNav() {
        return new Navigation(new BoatStrategy());
    } // end makeBoatNav

    public Navigation makeCharNav() {
        return new Navigation(new CharStrategy());
    } // end makeCharNav

    public Navigation makeProjectileNav() {
        return new Navigation(new ProjectileStrategy());
    } // end makeProjectileNav

    public Navigation makeVehicleNav() {
        return new Navigation(new VehicleStrategy());
    } // end makeVehicleNav

    /*
    on each movement call from the controller, this method is called with the
     entity requesting to move and its target tile.

    the local NavStrategy handles calling the target tile's move operation which
     either allows or disallows the entity to move.
     */
    public void move(Tile targetTile, Entity entity) {
        if(s != null)
            s.move(targetTile, entity);
    } // end move
} // end class Navigation
