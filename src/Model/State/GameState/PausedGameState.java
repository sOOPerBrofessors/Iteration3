package Model.State.GameState;

import Model.Entity.Character.Avatar;
import Model.Map.Map;

/**
 * Created by sgl on 4/8/16.
 */
public class PausedGameState extends GameState {
    public PausedGameState(Map map, Avatar avatar) {
        super(map, avatar);
    }

    /*public PausedGameState(){

    }*/

    // ticks shopkeeper
    @Override
    public void tick() {

    }
}
