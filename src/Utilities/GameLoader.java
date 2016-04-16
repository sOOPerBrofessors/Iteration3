package Utilities;

import Controller.AI_Controller.AI_Controller;
import Model.Entity.Character.Avatar;
import Model.Entity.Character.NPC.NPC;
import Model.Map.AreaEffect.HealDamageAOE;
import Model.Map.AreaEffect.TakeDamageAOE;
import Model.Map.Location;
import Model.Map.Map;
import Model.State.GameState.ActiveGameState;
import Model.State.GameState.PausedGameState;
import Utilities.AIStuff.NPCFactory;
import Utilities.GameFactory.MapFactory;
import Utilities.ItemStuff.ItemFactory.ItemFactory;
import Utilities.ItemStuff.ItemManager;
import View.ViewUtilities.Sprites.ImageAssets;

import java.util.ArrayList;

/**
 * Created by dyeung on 4/6/16.
 */
public class GameLoader {

    private Map map;
    private Avatar avatar;
    private ActiveGameState activeGameState;
    private PausedGameState pausedGameState;
    private ArrayList<NPC> entities;
    private ItemManager itemManager;

    //Needs a constructor in order to create what type of occupation it is
    public GameLoader(Avatar player) {
        ImageAssets.init();
        entities = new ArrayList<>();
        avatar = player;
        initMap();
        //initNPC();
        initPlayer();
        initItems();
        itemManager = new ItemManager(ItemFactory.getTakableItems(), ItemFactory.getInteractableItems(), ItemFactory.getItemViews());
        initAreaEffect();
        activeGameState = new ActiveGameState(map, player, entities, itemManager);
        pausedGameState = new PausedGameState(map, player, entities, itemManager);
    }

    //Map has to contain an avatar (might be unnecessary in the constructor though)
    public void initMap() {
        MessageHandler.println("GameLoader: Loading Map and Avatar and ActiveGameState", ErrorLevel.NOTICE);
        int maxRow = 15;
        int maxCol = 15;
        MapFactory mapFactory = new MapFactory(maxRow, maxCol);
        //This would be the original map
        //map = mapFactory.createNewMap();
        //This is the testing map with rivers
        map = mapFactory.createNewMapRiver();
    }

    private void initItems() {
        ItemFactory.init(map);
    }

    private void initPlayer() {
        map.addCharacter(avatar); //(This doesn't have to worry about 3d things)
    }

    private void initNPC() {


        entities = NPCFactory.init();

        AI_Controller controller = new AI_Controller();

        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).setController(controller);
            map.addEntity(entities.get(i));
        }

        controller.setMap(map);
    }

    private void initAreaEffect(){
        map.addAOE(new HealDamageAOE(5), new Location(1,1,0));
        map.addAOE(new TakeDamageAOE(10), new Location(3,1,0));
    }

    public Map getMap() {
        return map;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public ActiveGameState getActiveGameState() {
        return activeGameState;
    }

    public PausedGameState getPausedGameState() {
        return pausedGameState;
    }
}