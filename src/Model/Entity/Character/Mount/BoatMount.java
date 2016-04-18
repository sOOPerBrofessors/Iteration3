package Model.Entity.Character.Mount;

import Model.Map.Location;
import Model.Map.Map;
import Model.Map.Orientation;
import Utilities.Navigation.Navigation;

/**
 * Created by dyeung on 4/15/16.
 */
public class BoatMount extends Mount {

    public BoatMount(Location location) {
        super(Navigation.makeBoatNav(), location);
    }

    @Override
    public boolean move(Map map, Orientation orientation) {
        //The move functionality for Mount might be different from character or projectile
        return false;
    }

    @Override
    public void levitate() {

    }
}
