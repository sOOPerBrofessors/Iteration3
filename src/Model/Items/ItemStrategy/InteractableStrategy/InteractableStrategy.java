package Model.Items.ItemStrategy.InteractableStrategy;

import Model.Inventory.Inventory;
import Model.Items.Takeable.Quest;
import Utilities.ErrorLevel;
import Utilities.MessageHandler;

/**
 * Created by broskj on 4/7/16.
 */
public class InteractableStrategy {

    protected Quest requiredItem;

    public boolean onInteract(Inventory inventory) {
        MessageHandler.println("You can't interact with this item.", ErrorLevel.ERROR);
        return false;
    } // end onInteract

} // end class InteractableStrategy
