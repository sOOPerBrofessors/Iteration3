package Model.State.GameState;

import Controller.AI_Controller.Brain;
import Controller.Controllers.GamePlayController;
import Model.Entity.Character.Avatar;
import Model.Map.Map;

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

    //The ActiveGameState is never creating any models. It is being created within the GameLoader and then passed in through
    // a constructor
//    public ActiveGameState(){
//        avatar = Avatar.makeSmasher();
//
//    }

    @Override
    public void tick(){
        // TODO: Brain needs to be instantiated with entity and personality
        //brain.tick(); //ticks AI
        //possibly need to tick human input if can be inputted too fast
        //need to tick rivers???
    }

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

    public void setPlayer(Avatar player) {
        this.player = player;
    }
}
