package Model.Items.ItemStrategy.InteractableStrategy;

import Model.Entity.Character.Character;
import Model.Inventory.Inventory;
import Model.Items.Item;
import Model.Items.Takeable.Quest;

/**
 * Created by broskj on 4/7/16.
 */
public class ChestStrategy extends InteractableStrategy {

    public ChestStrategy(Quest requiredItem){
        this.requiredItem = requiredItem;
    }

    public boolean onInteract(Inventory inventory) {
        for(Item item : inventory.getPack().getItems()){
            if(item == requiredItem){

            }
        }
        return false;
    } // end onInteract
} // end class ChestStrategy
