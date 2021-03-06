package Model.Items.ItemStrategy.InteractableStrategy;

import Model.Entity.Character.Character;
import Model.Items.Takeable.Quest;
import Utilities.ErrorLevel;
import Utilities.MessageHandler;

/**
 * Created by broskj on 4/7/16.
 */
public class InteractableStrategy {

    Quest requiredItem;

    public boolean onInteract(Character character) {
        MessageHandler.println("You can't interact with this item.", ErrorLevel.ERROR);
        return false;
    } // end onInteract

} // end class InteractableStrategy
