package Model.Entity.Projectile;

import Model.Effect.Effect;
import Model.Entity.Character.Character;
import Model.Entity.Entity;
import Model.Map.Location;
import Model.Map.Map;
import Model.Map.Orientation;
import Model.Map.Tile.Terrain.Terrain;
import Utilities.Navigation.Navigation;
import Utilities.Observers.Observer;
import Utilities.Observers.Subject;

/**
 * Created by dyeung on 4/16/16.
 */
public class Projectile extends Entity implements Subject, Effect {

    private Observer observer;

    private Orientation orientation;
    private boolean viewDone;
    private int effect;

    private Projectile(Navigation navigation, Location location, Orientation orientation, int effect) {
        super(navigation, location);
        this.orientation = orientation;
        viewDone = true;
        this.effect = effect;
    }

    @Override
    public boolean move(Map map, Orientation orientation) {
        if (viewDone) {
            viewDone = false;
            int x = location.getX() + orientation.x;
            int y = location.getY() + orientation.y;
            //z is zero here. Since it is a character it will move based on the next possible height
            Location newLocation = new Location(x,y,0);
            //delayMovement();
            return map.moveProjectile(this, newLocation);
        }
        return false;
    }

    public static Projectile makeFireBall(Location location, Orientation orientation){
        return new Projectile(Navigation.makeProjectileNav(), location, orientation, -2);
    }

    public static Projectile makeFireBall(Location location, Orientation orientation, int damange){
        return new Projectile(Navigation.makeProjectileNav(), location, orientation, -damange);
    }

    public static Projectile makeArrow(Location location, Orientation orientation, int damange){
        return new Projectile(Navigation.makeProjectileNav(), location, orientation, -damange);
    }

    public void tick(Map map) {
        move(map, orientation);
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

    public void ViewDone(){
        viewDone = true;
    }

    public boolean checkStrategy(Terrain terrain){
        return navigation.canMove(terrain);
    }

    @Override
    public void execute(Character character, int amount) {
        character.healthEffect(amount);
    }

    public int getEffect(){
        return effect;
    }
}