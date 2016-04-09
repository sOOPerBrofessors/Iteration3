package Model.State.States;

import Controller.Controllers.GamePlayController;
import Model.Entity.Character.Avatar;
import Model.Map.Map;
import Model.Map.Tile.Tile;
import Model.State.GameState;

/**
 * Created by Wimberley on 4/6/16.
 */
public class ActiveGameState extends GameState {

    private GamePlayController activeGameController;

    public ActiveGameState(Map map, Avatar avatar){
        super(map,avatar);
    }


    // player commands from controller
    public void movePlayerN(){
        //System.out.println("ActiveGameState: move player N");
        avatar.moveNorth(map);
    }

    public void movePlayerNE(){
        avatar.moveNorthEast(map);
    }

    public void movePlayerSE(){
        avatar.moveSouthEast(map);
    }

    public void movePlayerS(){
        avatar.moveSouth(map);
    }

    public void movePlayerSW(){
        avatar.moveSouthWest(map);
    }

    public void movePlayerNW(){
        avatar.moveNorthWest(map);
    }

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
