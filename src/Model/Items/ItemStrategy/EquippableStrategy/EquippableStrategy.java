package Model.Items.ItemStrategy.EquippableStrategy;

import Model.Entity.Character.Character;
import Model.Items.ItemStrategy.ItemStrategy;
import Model.Items.Takeable.TakeableItem;
import Utilities.GameMessageQueue;

/**
 * Created by broskj on 4/6/16.
 *
 * Strategy class to provide default error message for equipping an item; will be
 *  overridden with more specific implementations
 */
public class EquippableStrategy implements ItemStrategy {

    @Override
    public boolean onInteract(TakeableItem item, Character character) {
        GameMessageQueue.push   ("You can't equip the " + item.getName());
        return false;
    } // end onInteract
} // end class EquippableStrategy
