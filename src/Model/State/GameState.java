package Model.State;

import Model.Entity.Avatar;
import Model.Entity.Entity;

import java.util.ArrayList;
import Model.Map.Map;

/**
 * Created by Wimberley on 4/6/16.
 */
public abstract class GameState extends State{
    protected ArrayList<Entity> entities;
    //protected ArrayList<Item> items;
    protected Map map;
    protected Avatar avatar;

    public GameState(Map map, Avatar avatar){
        //This will be done in the gameloader thing
        this.map = map;
        this.avatar = avatar;
    }

    //TEMP (maybe?)
    public Avatar getAvatar(){
        return avatar;
    }
    public Model.Map.Map getMap(){
        return map;
    }
}
