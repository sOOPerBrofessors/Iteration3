package Utilities.GameLoaderSaver;

import Model.Entity.Character.Avatar;
import Model.Map.Map;
import Model.State.GameState.ActiveGameState;
import Model.State.GameState.GameState;
import Utilities.GameLoaderSaver.Save.SaveVisitor;

/**
 * Created by dyeung on 4/16/16.
 */
public class GameSaver {

    private final String path = "./res/SaveFile/";
    private String testFileName = "SaveFile1.xml";
    private SaveVisitor saveVisitor;
    private GameState gameState;
    public GameSaver(GameState gameState){
        this.gameState = gameState;
        saveVisitor = new SaveVisitor(path + testFileName, gameState);
    }

    public void startSave(){
        saveVisitor.save();
        //saveAvatar(activeGameState.getAvatar());
    }

    private void saveAvatar(Avatar avatar){
        //avatar.acceptCharacterVisitor(saveVisitor);
    }
    private void saveMap(Map map){

    }
}
