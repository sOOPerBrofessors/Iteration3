package Model.State.States;

import Controller.Controllers.GamePlayController;
import Model.Entity.Character.Avatar;
import Model.Map.Map;
import Model.State.GameState;

/**
 * Created by Wimberley on 4/6/16.
 */
public class ActiveGameState extends GameState {

    private GamePlayController activeGameController;

    public ActiveGameState(Map map, Avatar avatar){
        super(map,avatar);
    }

    public ActiveGameState(){
        avatar = Avatar.makeSmasher();

    }

    // player commands from controller

    public void movePlayerN(){

    }

    public void movePlayerNE(){}

    public void movePlayerSE(){

    }

    public void movePlayerS(){}

    public void movePlayerSW(){

    }

    public void movePlayerNW(){}

    public void playerAttack(){}

    public void playerFirstSkill(){

    }

    public void playerSecondSkill(){}

    public void playerInteract(){}

    @Override
    public void tick(){}

    public void setActiveGameController(GamePlayController activeGameController) {
        this.activeGameController = activeGameController;
    }
}
