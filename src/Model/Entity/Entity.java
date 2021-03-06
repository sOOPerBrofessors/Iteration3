package Model.Entity;

import java.util.ArrayList;

import Model.Map.*;
import Model.Map.Tile.Tile;
import Utilities.Navigation.Navigation;
import Utilities.Observers.EntityObservable;
import Utilities.Observers.EntityObserver;

/**
 * Created by dyeung on 4/6/16.
 *
 */

//All npcs are able now Observables for a specific model view

public abstract class Entity implements EntityObservable, MapObject {
    protected Location location;
    protected Navigation navigation;
    protected Orientation orientation;

    private final ArrayList<EntityObserver> observers;

    protected Entity(Navigation navigation, Location location){
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

    private TileColumn getNextTileColumn(Map map, Orientation orientation){
        int newX = location.getX() + orientation.x;
        int newY = location.getY() + orientation.y;
        return map.getTileColumn(newX,newY);
    }

    //Because the movement for projectiles is very different from Character, I decided to switch this here
    public abstract boolean move(Map map, Orientation orientation);

    public boolean canMove(Map map, Orientation orientation) {

        TileColumn nextTileColumn = getNextTileColumn(map, orientation);

        if (nextTileColumn == null) {

            return false;

        }

        int nextZ = nextTileColumn.getTopPosition() - 1;
        int difference = nextZ - location.getZ();
        if (difference > 1) { //Allows fall to happen, probably need some check to account if <0

            return false;

        }

        return canMove(nextTileColumn.getTopTile());

    }

    private boolean canMove(Tile tile) {

        return navigation.canMove(tile);

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