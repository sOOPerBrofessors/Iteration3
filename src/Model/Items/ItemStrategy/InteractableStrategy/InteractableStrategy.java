package Model.Items.ItemStrategy.InteractableStrategy;

import Model.Entity.Character.Character;
import Model.Items.Item;
import Model.Items.ItemStrategy.ItemStrategy;
import Utilities.ErrorLevel;
import Utilities.MessageHandler;

/**
 * Created by broskj on 4/7/16.
 */
public class InteractableStrategy implements ItemStrategy {
    @Override
    public void onInteract(Item item, Character character) {
        MessageHandler.println("You can't interact with this item.", ErrorLevel.ERROR);
    } // end onInteract
} // end class InteractableStrategy
