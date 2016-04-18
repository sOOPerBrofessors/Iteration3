package Model.Entity.Character.Mount;

import Model.Map.Location;
import Model.Map.Map;
import Model.Map.Orientation;
import Utilities.Navigation.Navigation;
import Utilities.Observers.Observer;
import Utilities.Timer.TimedEvent;

/**
 * Created by Wimberley on 4/17/16.
 */
public class TheRealMount extends Mount {

    public TheRealMount(Navigation navigation, Location location){
        super(navigation, location);
    }

    @Override
    public boolean move(Map map, Orientation orientation) {
        if (this.orientation.equals(orientation) && canMove) {
            int x = location.getX() + orientation.x;
            int y = location.getY() + orientation.y;
            //z is zero here. Since it is a character it will move based on the next possible height
            Location newLocation = new Location(x,y,0);
            delayMovement();
            return map.moveMount(this, newLocation);
        }else {
            setOrientation(orientation);
            return false;
        }
    }

    public void delayMovement() {
        /*
        starts a timer of duration 'delay'; the beginning of which toggles the userCanMakeInput
         value to false, and after finishing execution toggles it back to true
         */
        new TimedEvent(delay, () -> canMove = false, e -> canMove = true).start();
    } // end delayMovement
}