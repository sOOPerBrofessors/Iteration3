package Model.State.States;

import Controller.ControllerManager;
import Model.Entity.Character.Avatar;
import Model.Map.Map;
import Model.State.GameState;

/**
 * Created by Wimberley on 4/6/16.
 */
public class ActiveGameState extends GameState {

    public ActiveGameState(Map map, Avatar avatar){
        super(map,avatar);
    }

    //The ActiveGameState is never creating any models. It is being created within the GameLoader and then passed in through
    // a constructor
//    public ActiveGameState(){
//        avatar = Avatar.makeSmasher();
//
//    }


    // player commands from controller

    public void movePlayerN(){
        avatar.moveNorth(map.getTile(avatar.getLocation()));
    }

    public void movePlayerNE(){
        avatar.moveNorthEast(map.getTile(avatar.getLocation()));
    }

    public void movePlayerSE(){
        avatar.moveSouthEast(map.getTile(avatar.getLocation()));
    }

    public void movePlayerS(){
        avatar.moveSouth(map.getTile(avatar.getLocation()));
    }

    public void movePlayerSW(){
        avatar.moveSouthWest(map.getTile(avatar.getLocation()));
    }

    public void movePlayerNW(){
        avatar.moveNorthWest(map.getTile(avatar.getLocation()));
    }

    public void playerAttack(){}

    public void playerFirstSkill(){

    }

    public void playerSecondSkill(){}

    public void playerInteract(){}

    @Override
    public void tick(){}

    public void setPlayer(Avatar player){
        this.player = player;
    }
}
