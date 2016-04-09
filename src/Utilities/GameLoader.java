package Utilities;

import Model.Entity.Character.Avatar;
import Model.Entity.Character.NPC.NPC;
import Model.Entity.Entity;
import Model.Map.Location;
import Model.Map.Map;
import Model.Map.Tile.AirTile;
import Model.Map.Tile.GrassTile;
import Model.Map.Tile.Tile;
import Model.Map.Tile.WaterTile;
import Model.Map.TileColumn;
import Model.State.GameState.ActiveGameState;
import Utilities.AIStuff.NPCFactory;

import java.util.ArrayList;

/**
 * Created by dyeung on 4/6/16.
 */
public class GameLoader {
    private int startAvatarX = 5;
    private int startAvatarY = 5;

    private int maxTileRow = 15;
    private int maxTileCol = 15;

    Map map;
    Avatar avatar;
    ActiveGameState activeGameState;
    ArrayList<Entity> entities;



    //Needs a constructor in order to create what type of occupation it is
    public GameLoader(Avatar player) {
        initMap(player);
        activeGameState = new ActiveGameState(map, player, entities);
    }

    //Map has to contain an avatar (might be unnecessary in the constructor though)
    public void initMap(Avatar avatar){
        System.out.println("GameLoader: Loading Map and Avatar and ActiveGameState");

        TileColumn[][] tmpList = new TileColumn[15][15];
        for (int i = 0; i < maxTileRow; i++){
            for (int j = 0; j < maxTileCol; j++){
                tmpList[i][j] = new TileColumn();
                for (int k = 0; k < 10; k++){

                    TileColumn tC = tmpList[i][j];

                    if (k < 1) {
                        if (i == 2 && (j>2 && j < 5)){
                            WaterTile tile = new WaterTile();
                            tC.addTiles(tile);
                        }else{
                            GrassTile tile = new GrassTile();
                            tC.addTiles(tile);

                        }
                    }else {
                        AirTile tile = new AirTile();
                        tC.addTiles(tile);
                    }
                }
            }
        }
        //Initial location of the avatar
        entities = NPCFactory.init();
        for(int i = 0; i < entities.size(); i++){
            tmpList[entities.get(i).getLocation().getX()][entities.get(i).getLocation().getY()].addMapObjects(entities.get(i));
        }
        tmpList[avatar.getLocation().getX()][avatar.getLocation().getY()].addMapObjects(avatar);
        map = new Map(tmpList);
    }

    public Map getMap(){
        return map;
    }
    public Avatar getAvatar(){
        return avatar;
    }
    public ActiveGameState getActiveGameState(){
        return activeGameState;
    }
}
