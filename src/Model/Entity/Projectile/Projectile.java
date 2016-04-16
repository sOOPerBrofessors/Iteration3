package Model.Entity.Projectile;

import Model.Entity.Entity;
import Model.Map.Location;
import Model.Map.Map;
import Model.Map.Orientation;
import Utilities.Navigation.Navigation;
import Utilities.Tickable;

/**
 * Created by dyeung on 4/16/16.
 */
public class Projectile extends Entity implements Tickable{

    private Projectile(Navigation navigation, Location location) {
        super(navigation, location);
    }

    @Override
    public boolean move(Map map, Orientation orientation) {
        return false;
    }

    public static Projectile makeFireBall(Location location){
        return new Projectile(Navigation.makeProjectileNav(), location);
    }

    @Override
    public void tick() {

    }
}
