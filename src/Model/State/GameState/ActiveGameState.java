package Model.State.GameState;

import Controller.Controllers.GamePlayController;
import Model.Entity.Character.Avatar;
import Model.Map.Map;
import Model.State.GameState.GameState;

/**
 * Created by Wimberley on 4/6/16.
 */
public class ActiveGameState extends GameState {

    private GamePlayController activeGameController;

    public ActiveGameState(Map map, Avatar avatar){
        super(map,avatar);
    }

    //The ActiveGameState is never creating any models. It is being created within the GameLoader and then passed in through
    // a constructor
//    public ActiveGameState(){
//        avatar = Avatar.makeSmasher();
//
//    }

    @Override
    public void tick(){

    }

    // player commands from controller

    public void movePlayerN(){
        avatar.moveNorth();
    }

    public void movePlayerNE(){
        avatar.moveNorthEast();
    }

    public void movePlayerSE(){
        avatar.moveSouthEast();
    }

    public void movePlayerS(){
        avatar.moveSouth();
    }

    public void movePlayerSW(){
        avatar.moveSouthWest();
    }

    public void movePlayerNW(){
        avatar.moveNorthWest();
    }

    public void playerAttack(){}

    public void playerFirstSkill(){

    }

    public void playerSecondSkill(){}

    public void playerInteract(){}

    public void setActiveGameController(GamePlayController activeGameController) {
        this.activeGameController = activeGameController;
    }
}
