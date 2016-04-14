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
import Utilities.ItemStuff.ItemFactory;
import Utilities.ItemStuff.ItemManager;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dyeung on 4/6/16.
 */
public class GameLoader {
    
    private int maxTileRow = 15;
    private int maxTileCol = 15;

    Map map;
    Avatar avatar;
    ActiveGameState activeGameState;
    PausedGameState pausedGameState;
    ArrayList<NPC> entities;

    //Needs a constructor in order to create what type of occupation it is
    public GameLoader(Avatar player) {
        avatar = player;
        initMap(avatar);
        initEntities();
        initItems();
        activeGameState = new ActiveGameState(map, player, entities);
        pausedGameState = new PausedGameState(map, player, entities);
    }

    //Map has to contain an avatar (might be unnecessary in the constructor though)
    public void initMap(Avatar avatar) {
        MessageHandler.println("GameLoader: Loading Map and Avatar and ActiveGameState", ErrorLevel.NOTICE);

        TileColumn[][] tmpList = new TileColumn[maxTileRow][maxTileCol];
        for (int i = 0; i < maxTileRow; i++) {
            for (int j = 0; j < maxTileCol; j++) {
                tmpList[i][j] = new TileColumn();
                for (int k = 0; k < 10; k++) {
                    TileColumn tC = tmpList[i][j];
                    if (k < 1) {
                        if ((i == 2 || i == 1) && (j > 2 && j < 6)) {
                            WaterTile tile = new WaterTile();
                            tC.createWaterTile(tile);
                        } else {
                            tC.createGrassTile(new GrassTile());
                        }
                    } else {
                        if (j == 8 && (i >= 2 && i <= 9) && k < (i)) {
                            tC.createGrassTile(new GrassTile());
                        } else {
                            tC.createAirTile(new AirTile());
                        }
                    }
                }
            }
        }
        map = new Map(tmpList);
    }

    private void initItems() {
        ItemFactory.init();
        ItemManager.setItems(ItemFactory.getItems());
        ItemManager.setItemViews(ItemFactory.getItemViews());
    }

    private void initEntities() {
        map.addCharacter(avatar); //(This doesn't have to worry about 3d things)

        entities = NPCFactory.init();

        AI_Controller controller = new AI_Controller();

        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).setController(controller);
            map.addEntity(entities.get(i));
        }

        controller.setMap(map);
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