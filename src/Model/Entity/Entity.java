package Model.Entity;

import java.util.ArrayList;

import Model.Map.*;
import Model.Map.Tile.Tile;
import Utilities.Navigation.Navigation;
import Utilities.Observers.EntityObservable;
import Utilities.Observers.EntityObserver;
import Utilities.Visitor.CharacterVisitable;


/**
 * Created by dyeung on 4/6/16.
 *
 */

//All entities are able now Observables for a specific model view

public abstract class Entity implements EntityObservable, MapObject {
    protected Location location;
    protected Navigation navigation;
    protected Orientation orientation;

    private ArrayList<EntityObserver> observers;

    public Entity(Navigation navigation, Location location){
        this.navigation = navigation;
        this.location = location;
        observers = new ArrayList<>();
        orientation = Orientation.SOUTH;
    }

    @Override
    public void notifyObserverMove() {
        for (EntityObserver entityObserver : observers){
            entityObserver.updateMove();
        }
    }


    @Override
    public void addObserver(EntityObserver entityObserver) {
        observers.add(entityObserver);
    }

    @Override
    public void removeObserver(EntityObserver entityObserver) {
        observers.remove(entityObserver);
    }

    //TODO: question: should getNextTile and getNextTileColumn handled by map instead of entity?
    private Tile getNextTile(Map map, Orientation orientation){
        int newX = location.getX() + orientation.x;
        int newY = location.getY() + orientation.y;
        return map.getTopTile(newX,newY);
    }

    //Because the movement for projectiles is very different from Character, I decided to switch this here
    public abstract boolean move(Map map, Orientation orientation);


    public boolean canMove(Map map, Orientation orientation) {

        Tile nextTile = getNextTile(map, orientation);

        if (nextTile == null) {

            return false;

        }

        return navigation.canMove(nextTile);

    }

    public Location getLocation() {
        return location;
    }
    public Orientation getOrientation() {
        return orientation;
    }
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
        //Should be a notify observer orientation change
        notifyObserverMove();

    }
    public void updateLocation(Location location){
        int newX = location.getX();
        int newY = location.getY();
        int newZ = location.getZ();
        this.location.setNewLocation(newX, newY, newZ);
        notifyObserverMove();
    }

    public void setLocation(Location location) {
        this.location = location;
    } // end setLocation

    public int getX(){
        return location.getX();
    }
    public int getY(){
        return location.getY();
    }
    public int getZ(){
        return location.getZ();
    }


}


