package Model.State.GameState;

import Controller.Controllers.GamePlayController;
import Model.Entity.Character.Avatar;
import Model.Entity.Character.Mount.Mount;
import Model.Entity.Character.NPC.NPC;
import Model.Map.Map;
import Utilities.ItemStuff.ItemManager;

import java.util.ArrayList;

/**
 * Created by sgl on 4/8/16.
 */
public class PausedGameState extends GameState {

    public PausedGameState(Map map, Avatar avatar, ArrayList<NPC> entities, ArrayList<Mount> mount, ItemManager itemManager) {
        super(map, avatar, entities, mount, itemManager);
    }

    // ticks shopkeeper
    @Override
    public void tick() {

    }
}
