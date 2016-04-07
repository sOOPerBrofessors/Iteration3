package Utilities;

import Model.Entity.Avatar;
import Model.Map.Map;
import Model.Map.Tile.AirTile;
import Model.Map.Tile.GrassTile;
import Model.Map.Tile.Tile;
import Model.Map.TileColumn;
import Model.State.GameState;
import Model.State.States.ActiveGameState;
import View.EntityView.EntityView;

import java.util.ArrayList;

/**
 * Created by dyeung on 4/6/16.
 */
public class GameLoader {
    int startAvatarX = 5;
    int startAvatarY = 5;

    int maxTileRow = 15;
    int maxTileCol = 15;

    Map map;
    Avatar avatar;
    GameState gameState;
    public GameLoader(){
        initMap();
        avatar = new Avatar();
        gameState = new ActiveGameState(map,avatar);
    }
    public void initMap(){
        //Maybe for future
        //ArrayList< ArrayList<TileColumn> > tmpList = new ArrayList<>();

        TileColumn[][] tmpList = new TileColumn[maxTileRow][maxTileCol];
        for (int i = 0; i < maxTileRow; i++){
            for (int j = 0; j < maxTileCol; j++){
                for (int k = 0; k < 10; k++){
                    TileColumn tC = new TileColumn();
                    Tile tile;
                    if (k < 1) {
                        tile = new GrassTile();
                    }else {
                        tile = new AirTile();
                    }
                    tC.addTiles(tile);

                }
            }
        }
        map = new Map(tmpList);
    }
    public Map getMap(){
        return map;
    }
    public Avatar getAvatar(){
        return avatar;
    }
    public GameState getGameState(){
        return gameState;
    }
}
