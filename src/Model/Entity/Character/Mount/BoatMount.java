package Model.Entity.Character.Mount;

import Model.Entity.Character.Character;
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
    public void move(Map map, Orientation orientation) {

    }
}
