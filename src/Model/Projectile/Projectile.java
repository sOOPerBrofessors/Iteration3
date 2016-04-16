package Model.Projectile;

import Model.Entity.Entity;
import Model.Map.Location;
import Model.Map.Map;
import Model.Map.Orientation;
import Utilities.Navigation.Navigation;
import Utilities.Visitor.CharacterVisitor;

/**
 * Created by dyeung on 4/16/16.
 */
public class Projectile extends Entity {
    public Projectile(Navigation navigation, Location location) {
        super(navigation, location);
    }

    @Override
    public boolean move(Map map, Orientation orientation) {
        return false;
    }

}
