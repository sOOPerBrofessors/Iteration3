package Utilities.GameLoaderSaver;

import Model.Entity.Character.Avatar;
import Model.Map.Map;
import Model.State.GameState.GameState;
import Utilities.GameLoaderSaver.Save.SaveVisitor;

/**
 * Created by dyeung on 4/16/16.
 */
public class GameSaver {

    private final SaveVisitor saveVisitor;

    public GameSaver(GameState gameState){
        GameState gameState1 = gameState;
        String testFileName = "SaveFile1.xml";
        String path = "./res/SaveFile/";
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
