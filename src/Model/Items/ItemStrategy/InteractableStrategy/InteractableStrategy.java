package Model.Items.ItemStrategy.InteractableStrategy;

import Model.Entity.Character.Character;
import Model.Items.Item;
import Model.Items.ItemStrategy.ItemStrategy;
import Utilities.MessageHandler;

/**
 * Created by broskj on 4/7/16.
 */
public class InteractableStrategy implements ItemStrategy {
    @Override
    public void onInteract(Item item, Character character) {
        MessageHandler.printError("You can't interact with this item.");
    } // end onInteract
} // end class InteractableStrategy
