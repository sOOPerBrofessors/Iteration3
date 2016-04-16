package Model.Items.ItemStrategy.InteractableStrategy;

import Model.Entity.Character.Character;
import Model.Inventory.Inventory;
import Model.Items.Item;
import Model.Items.Takeable.Quest;
import Model.Items.Takeable.TakeableItem;

/**
 * Created by broskj on 4/7/16.
 */
public class ChestStrategy extends InteractableStrategy {

    private TakeableItem treasure;

    public ChestStrategy(Quest requiredItem, TakeableItem treasure){
        this.requiredItem = requiredItem;
        this.treasure = treasure;
    }

    public boolean onInteract(Inventory inventory) {
        for(Item item : inventory.getPack().getItems()){
            if(item == requiredItem){
                inventory.pickUpItem(treasure);
                treasure = null;
                return true;
            }
        }
        return false;
    } // end onInteract
} // end class ChestStrategy
