package Model.Items.ItemStrategy.EquippableStrategy;

import Model.Entity;
import Model.Items.Item;
import Model.Items.ItemStrategy.ItemStrategy;

/**
 * Created by broskj on 4/6/16.
 */
public class EquippableStrategy implements ItemStrategy {
    @Override
    public void onInteract(Item item, Entity entity) {
        //Utilities.printError("You cannot equip this item.");
    } // end onInteract
} // end class EquippableStrategy
