package Model.Items.ItemStrategy.InteractableStrategy;

import Model.Entity.Character.Character;
import Model.Inventory.Inventory;
import Model.Items.Item;

/**
 * Created by broskj on 4/7/16.
 */
public class ChestStrategy extends InteractableStrategy {

    public boolean onInteract(Inventory inventory) {
        // take in a key and give items to the character
        return false;
    } // end onInteract
} // end class ChestStrategy
