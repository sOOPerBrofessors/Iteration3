package Utilities;

import Model.Entity.Avatar;
import Model.Map.Map;
import Model.States.GameState;
import View.EntityView.EntityView;

/**
 * Created by dyeung on 4/6/16.
 */
public class GameLoader {
    int startX = 5;
    int startY = 5;
    Map map;
    Avatar avatar;
    GameState gameState;
    public GameLoader(){
        map = new Map();
        avatar = new Avatar();
        gameState = new GameState(map,avatar);
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
