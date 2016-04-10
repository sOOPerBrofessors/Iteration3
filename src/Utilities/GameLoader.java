package Utilities;

import Model.Entity.Character.Avatar;
import Model.Map.Location;
import Model.Map.Map;
import Model.Map.Tile.*;
import Model.Map.TileColumn;
import Model.State.GameState.ActiveGameState;

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

    //Needs a constructor in order to create what type of occupation it is
    public GameLoader(Avatar player) {
        avatar = player;
        initMap();
        initEntities();
        activeGameState = new ActiveGameState(map, player);
    }

    //Map has to contain an avatar (might be unnecessary in the constructor though)
    public void initMap(){
        TileColumn[][] tmpList = new TileColumn[maxTileRow][maxTileCol];
        for (int i = 0; i < maxTileRow; i++){
            for (int j = 0; j < maxTileCol; j++){
                tmpList[i][j] = new TileColumn();
                for (int k = 0; k < 10; k++){
                    TileColumn tC = tmpList[i][j];
                    if (k < 1) {
                        if ((i == 2 || i == 1)&& (j>2 && j < 6)){
                            WaterTile tile = new WaterTile();
                            tC.createWaterTile(tile);
                        }else{
                            tC.createGrassTile(new GrassTile());
                        }
                    }else {
                        if (j == 8 && (i >= 2 && i <= 9) && k < (i)) {
                            tC.createGrassTile(new GrassTile());
                        }else {
                            tC.createAirTile(new AirTile());
                        }
                    }

                }
            }
        }
        map = new Map(tmpList);
    }
    public void initItems(){

    }
    public void initEntities(){
        //Temporary
        //map.addEntity(avatar);
        map.addCharacter(avatar); //(This doesn't have to worry about 3d things)
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
