package Model.Items.ItemStrategy.EquippableStrategy;

import Model.Entity.Character.Character;
import Model.Items.Item;
import Model.Items.ItemStrategy.ItemStrategy;
import Utilities.ErrorLevel;
import Utilities.GameMessageQueue;
import Utilities.MessageHandler;

/**
 * Created by broskj on 4/6/16.
 *
 * Strategy class to provide default error message for equipping an item; will be
 *  overridden with more specific implementations
 */
public class EquippableStrategy implements ItemStrategy {

    @Override
    public void onInteract(Item item, Character character) {
        GameMessageQueue.push("You can't equip the " + item.name);
    } // end onInteract
} // end class EquippableStrategy
