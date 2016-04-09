package Model.State.GameState;

import Controller.AI_Controller.Brain;
import Controller.Controllers.GamePlayController;
import Model.Entity.Character.Avatar;
import Model.Map.Map;

import Model.Map.Orientation;
import Model.Map.Tile.Tile;
import Model.State.GameState.GameState;
/**
 * Created by Wimberley on 4/6/16.
 */

public class ActiveGameState extends GameState {

    private GamePlayController activeGameController;
    private Brain brain;

    public ActiveGameState(Map map, Avatar avatar){
        super(map,avatar);

        //Instantiate Brain
        //brain = new Brain()
    }


    @Override
    public void tick(){
        // TODO: Brain needs to be instantiated with entity and personality
        //brain.tick(); //ticks AI
        //possibly need to tick human input if can be inputted too fast
        //need to tick rivers???
    }

    // player commands from controller
    public void movePlayerN(){
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

    public void setPlayer(Avatar player) {
        this.player = player;
    }
}
