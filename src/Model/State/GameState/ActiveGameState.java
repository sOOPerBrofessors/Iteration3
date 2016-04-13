package Model.State.GameState;

import Model.Entity.Character.Avatar;
import Model.Entity.Character.NPC.NPC;
import Model.Map.Map;

import Model.Map.Orientation;

import java.util.ArrayList;

/**
 * Created by Wimberley on 4/6/16.
 */

public class ActiveGameState extends GameState {

    public ActiveGameState(Map map, Avatar avatar, ArrayList<NPC> entities){
        super(map,avatar, entities);
    }


    @Override
    public void tick(){
        for(int i = 0; i < entities.size(); i++){
            entities.get(i).tick();
        }
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
