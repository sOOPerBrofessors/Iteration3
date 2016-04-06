package Model.States;


import Model.Entity.Avatar;
import Model.Map.Map;


/*
 * Created by dyeung on 4/5/16.
 */
public class GameState {
    Map map;
    Avatar avatar;

    public GameState(Map map, Avatar avatar){
        //This will be done in the gameloader thing
        this.map = map;
        this.avatar = avatar;
    }
    public void moveUp(){
        avatar.moveUp();
    }

    //TEMP (maybe?)
    public Avatar getAvatar(){
        return avatar;
    }
}
