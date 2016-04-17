package Utilities;

import Controller.AI_Controller.AI_Controller;
import Model.Entity.Character.Avatar;
import Model.Entity.Character.NPC.NPC;
import Model.Items.Item;
import Model.Map.Location;
import Model.Map.Map;
import Model.Map.Tile.AirTile;
import Model.Map.Tile.GrassTile;
import Model.Map.Tile.WaterTile;
import Model.Map.TileColumn;
import Model.State.GameState.ActiveGameState;
import Model.State.GameState.PausedGameState;
import Utilities.AIStuff.NPCFactory;
import Utilities.GameFactory.MapFactory;
import Utilities.ItemStuff.ItemFactory;
import Utilities.ItemStuff.ItemManager;
import View.ViewUtilities.ImageAssets;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dyeung on 4/6/16.
 */
public class GameLoader {

    Map map;
    Avatar avatar;
    ActiveGameState activeGameState;
    PausedGameState pausedGameState;
    ArrayList<NPC> entities;

    //Needs a constructor in order to create what type of occupation it is
    public GameLoader(Avatar player) {
        ImageAssets.init();
        avatar = player;
        initMap();
        initNPC();
        initPlayer();
        initItems();
        activeGameState = new ActiveGameState(map, player, entities);
        pausedGameState = new PausedGameState(map, player, entities);
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
        ItemFactory.init();
        ItemManager.setItems(ItemFactory.getItems());
        ItemManager.setItemViews(ItemFactory.getItemViews());
    }
    private void initPlayer(){
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

        controller.findPath(entities.get(0), new Location(8, 2, 1));

    }

    private void initAreaEffect(){

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