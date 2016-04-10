package Model.State.GameState;

import Model.Entity.Character.Avatar;
import Model.Entity.Character.NPC.NPC;
import Model.Entity.Entity;
import Model.Map.Map;

import java.util.ArrayList;

/**
 * Created by sgl on 4/8/16.
 */
public class PausedGameState extends GameState {

    public PausedGameState(Map map, Avatar avatar, ArrayList<NPC> entities) {
        super(map, avatar, entities);
    }

    // ticks shopkeeper
    @Override
    public void tick() {

    }
}
