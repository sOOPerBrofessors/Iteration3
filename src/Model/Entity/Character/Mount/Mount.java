package Model.Entity.Character.Mount;

import Model.Entity.Character.Character;
import Model.Entity.Entity;
import Model.Map.Location;
import Model.Map.Tile.Terrain.Terrain;
import Model.Stats.EntityStats;
import Utilities.Navigation.Navigation;
import Utilities.Observers.Observer;
import Utilities.Observers.Subject;

/**
 * Created by Wimberley on 4/6/16.
 */

//For now this will only contain this stuff (might implement more later)
public abstract class Mount extends Entity implements Subject{

    protected Character passenger;
    final int delay;
    boolean canMove;
    private final EntityStats stats;
    private Observer observer;

    Mount(Navigation navigation, Location location){
        super(navigation, location);
        stats = new EntityStats(30);
        delay = 1500 / stats.getMovement();
        canMove = true;
    }

    public void addPassenger(Character passenger){
        this.passenger = passenger;
        alert();
        passenger.setLocation(location);
        passenger.alert();
    }

    public void removePassenger(){
        passenger.setLocation(location.getAdjacent(passenger.getOrientation()));
    }

    public boolean checkStrategy(Terrain terrain){
        return navigation.canMove(terrain);
    }

    @Override
    public void addObserver(Observer observer){
        this.observer = observer;
    }

    @Override
    public void alert(){
        observer.update();
    }

    @Override
    public void removeObserver(Observer o) {
    }

    public Character getPassenger() {
        return passenger;
    }

    public abstract void levitate(int z);
}