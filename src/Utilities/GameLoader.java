package Utilities;

import Model.Entity.Character.Avatar;
import Model.Map.Location;
import Model.Map.Map;
import Model.Map.Tile.AirTile;
import Model.Map.Tile.GrassTile;
import Model.Map.Tile.Tile;
import Model.Map.Tile.WaterTile;
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
        avatar = Avatar.makeSmasher(new Location(5,5,0));
        initMap(avatar);
        activeGameState = new ActiveGameState(map,avatar);
    }
    //Map has to contain an avatar (might be unnecessary in the constructor though)
    public void initMap(Avatar avatar){
        System.out.println("GameLoader: Loading Map and Avatar and ActiveGameState");
        //Maybe for future
        //ArrayList< ArrayList<TileColumn> > tmpList = new ArrayList<>();


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
        tmpList[5][5].addMapObjects(avatar);
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
