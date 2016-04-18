package Model.Items.ItemStrategy.InteractableStrategy;

import Model.Entity.Character.Character;
import Model.Items.Takeable.Quest;
import Model.Items.Takeable.TakeableItem;
import Utilities.GameMessageQueue;

/**
 * Created by broskj on 4/7/16.
 */
public class ChestStrategy extends InteractableStrategy {

    private TakeableItem treasure;

    public ChestStrategy(Quest requiredItem, TakeableItem treasure){
        this.requiredItem = requiredItem;
        this.treasure = treasure;
    }

    public boolean onInteract(Character character) {
        // lod like crazy
        if (treasure == null) {
            GameMessageQueue.push("The chest is empty.");
            return false;
        }
        for(TakeableItem item : character.getInventory().getPack().getItems()){
            if(item == requiredItem){
                GameMessageQueue.push("You unlock the chest...");
                treasure.onInteract(character);
                //character.pickUpItem(treasure);
                treasure = null;
                character.removeItem(item);
                return true;
            }
        }
        GameMessageQueue.push("You need a key to unlock this chest.");
        return false;
    } // end onInteract
} // end class ChestStrategy