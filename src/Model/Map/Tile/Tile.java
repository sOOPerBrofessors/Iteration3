package Model.Map.Tile;

import Model.Entity.Entity;
import Model.Items.Item;
import Utilities.ErrorLevel;
import Utilities.MessageHandler;
import Utilities.Observers.TileObservable;
import Utilities.Observers.TileObserver;
import Utilities.Visitor.TileVisitable;

import java.util.ArrayList;

/**
 * Created by sgl on 4/5/16.
 */
public abstract class Tile implements TileVisitable, TileObservable{
    private ArrayList<TileObserver> observers;

    public Tile(){
        observers = new ArrayList<>();
    }

    public boolean moveAvian(Entity entity){
        MessageHandler.println("You cannot move to this tile.", ErrorLevel.NOTICE);
        return false;
    }

    public boolean moveAquatic(Entity entity){
        MessageHandler.println("You cannot move to this tile.", ErrorLevel.NOTICE);
        return false;
    }

    public boolean moveBoat(Entity entity){
        MessageHandler.println("You cannot move to this tile.", ErrorLevel.NOTICE);
        return false;
    }

    public boolean moveChar(Entity entity){
        MessageHandler.println("You cannot move to this tile.", ErrorLevel.NOTICE);
        return false;
    }

    public boolean moveProjectile(Entity entity){
        MessageHandler.println("You cannot move to this tile.", ErrorLevel.NOTICE);
        return false;
    }

    public boolean moveVehicle(Entity entity){
        MessageHandler.println("You cannot move to this tile.", ErrorLevel.NOTICE);
        return false;
    }

    public boolean canMoveAvian(){
        return false;
    }

    public boolean canMoveAquatic(){
        return false;
    }

    public boolean canMoveBoat(){
        return false;

    }

    public boolean canMoveChar(){
        return false;
    }

    public boolean canMoveProjectile(){
        return false;
    }

    public boolean canMoveVehicle(){
        return false;
    }

    public abstract Entity getEntity();
    public abstract void addEntity(Entity entity);
    public abstract void removeEntity();
    public abstract boolean hasEntity();

    @Override
    public void notifyObservers() {
        for(TileObserver tileObserver : observers){
            tileObserver.update();
        }
    }

    @Override
    public void acceptTileObserver(TileObserver tileObserver) {
        observers.add(tileObserver);
    }

}
