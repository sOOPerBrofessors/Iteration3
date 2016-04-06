package Model.Entity;

import Model.Entity.Entity;

/**
 * Created by dyeung on 4/6/16.
 */
public class Avatar extends Entity {
    public Avatar(){

    }

    public void moveUp(){
        //TODO: add moveup stuff
        System.out.println("Avatar: moving up");
        //For testing purposes 0 == up
        notifyObserverMove(0); //this is an inherited class from entity
    }
}
