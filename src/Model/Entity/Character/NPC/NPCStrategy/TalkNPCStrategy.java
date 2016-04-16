package Model.Entity.Character.NPC.NPCStrategy;

import Utilities.GameMessageQueue;

import java.util.ArrayList;

/**
 * Created by dyeung on 4/16/16.
 */
public class TalkNPCStrategy extends NPCStrategy {
    ArrayList<String> dialogue;
    public TalkNPCStrategy(String ... text){
        dialogue = new ArrayList<>();
        for (String textLine : text){
            dialogue.add(textLine);
        }
    }
    @Override
    public void onInteract() {
        for (String text : dialogue){
            GameMessageQueue.push(text);
        }
    }
}
