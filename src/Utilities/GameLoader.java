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
    private int startAvatarX = 5;
    private int startAvatarY = 5;

    private int maxTileRow = 15;
    private int maxTileCol = 15;

    Map map;
    Avatar avatar;
    ActiveGameState activeGameState;
    public GameLoader(){

        initMap();
        avatar = new Avatar();
        activeGameState = new ActiveGameState(map,avatar);
    }
    public void initMap(){
        System.out.println("GameLoader: Loading Map and Avatar and ActiveGameState");
        //Maybe for future
        //ArrayList< ArrayList<TileColumn> > tmpList = new ArrayList<>();

        TileColumn[][] tmpList = new TileColumn[15][15];
        for (int i = 0; i < maxTileRow; i++){
            for (int j = 0; j < maxTileCol; j++){
                tmpList[i][j] = new TileColumn();
                for (int k = 0; k < 10; k++){

                    TileColumn tC = tmpList[i][j];
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
    public ActiveGameState getActiveGameState(){
        return activeGameState;
    }
}
