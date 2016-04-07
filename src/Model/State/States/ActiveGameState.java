package Model.State.States;

import Model.Entity.Avatar;
import Model.Map.Map;
import Model.State.GameState;

/**
 * Created by Wimberley on 4/6/16.
 */
public class ActiveGameState extends GameState {


    public ActiveGameState(Map map, Avatar avatar){
        super(map,avatar);
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
}
