package Model.State.States;

import Controller.Controllers.GamePlayController;
import Model.Entity.Character.Avatar;
import Model.Map.Map;
import Model.Map.Orientation;
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
        avatar.move(map, Orientation.NORTH);
    }

    public void movePlayerNE(){
        avatar.move(map, Orientation.NORTHEAST);
    }

    public void movePlayerSE(){
        avatar.move(map, Orientation.SOUTHEAST);
    }

    public void movePlayerS(){
        avatar.move(map, Orientation.SOUTH);
    }

    public void movePlayerSW(){
        avatar.move(map, Orientation.SOUTHWEST);
    }

    public void movePlayerNW(){
        avatar.move(map, Orientation.NORTHWEST);
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
