package Utilities.GameLoaderSaver;

import Controller.AI_Controller.AI_Controller;
import Model.Entity.Character.Avatar;
import Model.Entity.Character.Mount.Mount;
import Model.Entity.Character.NPC.NPC;
import Model.Map.AreaEffect.*;

import Model.Map.Location;
import Model.Map.Map;
import Model.State.GameState.ActiveGameState;
import Model.State.GameState.MountGameState;
import Model.State.GameState.PausedGameState;
import Model.State.StateManager;
import Utilities.AIStuff.NPCFactory;
import Utilities.ErrorLevel;
import Utilities.GameFactory.MapFactory;
import Utilities.GameLoaderSaver.Load.LoadParser;
import Utilities.ItemStuff.ItemFactory.ItemFactory;
import Utilities.ItemStuff.ItemManager;
import Utilities.MessageHandler;
import Utilities.MovementCalculations.ViewCalculations;
import View.ViewUtilities.Sprites.ImageAssets;

import java.util.ArrayList;

/**
 * Created by dyeung on 4/6/16.
 */
public class GameLoader {

    private Map map;
    private final Avatar avatar;
    private final ActiveGameState activeGameState;
    private final PausedGameState pausedGameState;
    private final MountGameState mountGameState;
    private ArrayList<NPC> entities;
    private ArrayList<Mount> mounts;

    //Needs a constructor in order to create what type of occupation it is
    public GameLoader(Avatar player, StateManager stateManager) {
        ImageAssets.init();
        ViewCalculations.initPixels();
        entities = new ArrayList<>();
        avatar = player;
        initMap();
        ItemFactory.initHashMaps();
        initNPC();
        ItemManager itemManager = new ItemManager(ItemFactory.getTakableItems(), ItemFactory.getInteractableItems(), ItemFactory.getAllItemViews(), ItemFactory.getMapItemViews());
        initAreaEffect();
        activeGameState = new ActiveGameState(map, player, entities, mounts, itemManager);
        pausedGameState = new PausedGameState(map, player, entities, mounts, itemManager);
        mountGameState = new MountGameState(map, player, entities, mounts, itemManager);
        stateManager.setActiveGameState(activeGameState);
        stateManager.setPausedGameState(pausedGameState);
        stateManager.setMountGameState(mountGameState);
    }
    public void loadGame(){
        addPlayerToMap(); //load game is done earlier
        //loadItems();
        initItems();
        initAreaEffect();
    }
    public void createNewGame(){
        addPlayerToMap();
        initItems();
        initAreaEffect();
    }

    private void loadItems(){
        LoadParser loadParser = new LoadParser();
        loadParser.loadItems();
    }
    //Map has to contain an avatar (might be unnecessary in the constructor though)
    private void initMap() {
        MessageHandler.println("GameLoader: Loading Map and Avatar and ActiveGameState", ErrorLevel.NOTICE);
        int maxRow = 15;
        int maxCol = 15;
        MapFactory mapFactory = new MapFactory(maxRow, maxCol);
        //This would be the original map
        //map = mapFactory.createNewMap();
        //This is the testing map with rivers
        //map = mapFactory.createNewMapRiver();
        map = mapFactory.createSeparateMap();
    }

    private void initItems() {
        ItemFactory.init(map);
    }

    private void addPlayerToMap() {
        map.addCharacter(avatar); //(This doesn't have to worry about 3d things)
    }

    private void initNPC() {
        NPCFactory.init(map);

        entities = NPCFactory.getNPCS();
        mounts = NPCFactory.getMounts();

        AI_Controller controller = new AI_Controller();

        for (int i = 0; i < entities.size(); i++) {

            entities.get(i).setController(controller);

            map.addCharacter(entities.get(i));
        }
        controller.setMap(map);
    }

    private void initAreaEffect(){
        map.addAOE(new HealDamageAOE(), new Location(8,12,0));
        map.addAOE(new TakeDamageAOE(-5), new Location(8,13,0));
        map.addAOE(new InstantDeathAOE(), new Location(8,14,0));
        map.addAOE(new LevelUpAOE(), new Location(9,12,0));
        map.addAOE(new TeleportAOE(new Location(10,10,0), map), new Location(3,1,0));
        map.addAOE(new TeleportAOE(new Location(5,5,0), map), new Location(11,11,0));
        map.addAOE(new Trap(), new Location(6,3,0));

    }

    public ActiveGameState getActiveGameState() {
        return activeGameState;
    }

    public PausedGameState getPausedGameState() {
        return pausedGameState;
    }

    public MountGameState getMountGameState() {
        return mountGameState;
    }
}