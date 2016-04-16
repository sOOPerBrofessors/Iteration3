package Model.Items.Interactable;

import Model.Entity.Character.Character;
import Model.Items.ItemStrategy.InteractableStrategy.ChestStrategy;
import Model.Items.Takeable.Quest;

/**
 * Created by broskj on 4/7/16.
 */
public class Chest extends Interactable {
    public Chest(Quest requiredItem) {
        super(new ChestStrategy(requiredItem));
    } // end constructor

    public void onInteract(Character character) {
        s.onInteract(character.getInventory());
    } // end onInteract
} // end class Chest