package Model.State.GameState;

import Model.Entity.Character.Avatar;
import Model.Entity.Entity;

import java.util.ArrayList;
import Model.Map.Map;
import Model.State.State;

/**
 * Created by Wimberley on 4/6/16.
 */
public abstract class GameState extends State {

    protected ArrayList<Entity> entities;
    protected Map map;
    protected Avatar avatar;

    public GameState(Map map, Avatar avatar){
        //This will be done in the gameLoader
        this.map = map;
        this.avatar = avatar;
    }

    //TEMP
    public Avatar getAvatar(){
        return avatar;
    }
    public Map getMap(){
        return map;
    }

    public void setAvatar(Avatar player){
        this.avatar = player;
    }

    public void setMap(Map map){
        this.map = map;
    }
}
