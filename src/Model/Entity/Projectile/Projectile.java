package Model.Entity.Projectile;

import Model.Effect.Effect;
import Model.Entity.Entity;
import Model.Map.Location;
import Model.Map.Map;
import Model.Map.Orientation;
import Utilities.Navigation.Navigation;
import Utilities.Observers.Observer;
import Utilities.Observers.Subject;
import Utilities.Tickable;
import View.EntityView.ProjectileView;

/**
 * Created by dyeung on 4/16/16.
 */
public class Projectile extends Entity implements Tickable, Subject {

    private Observer observer;

    private Effect effect;
    private Orientation orientation;

    private Projectile(Navigation navigation, Location location, Orientation orientation) {
        super(navigation, location);
        this.orientation = orientation;
    }

    @Override
    public boolean move(Map map, Orientation orientation) {
        return false;
    }

    public static Projectile makeFireBall(Location location, Orientation orientation){
        return new Projectile(Navigation.makeProjectileNav(), location, orientation);
    }

    @Override
    public void tick() {

    }

    @Override
    public void addObserver(Observer o) {
        observer = o;
    }

    @Override
    public void removeObserver(Observer o) {
        observer = null;
    }

    @Override
    public void alert() {
        observer.update();
    }

    @Override
    public Orientation getOrientation() {
        return orientation;
    }
}