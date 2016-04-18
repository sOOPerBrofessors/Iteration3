package Model.Items.Interactable;

import Model.Entity.Character.Character;
import Model.Items.ItemStrategy.InteractableStrategy.ChestStrategy;
import Model.Items.Takeable.Quest;
import Model.Items.Takeable.TakeableItem;

/**
 * Created by broskj on 4/7/16.
 */
public class Chest extends Interactable {

    public Chest(Quest requiredItem, TakeableItem treasure) {
        super(new ChestStrategy(requiredItem, treasure), "ClosedChest");
        success = false;
    } // end constructor

    public void onInteract(Character character) {
        updateSuccess(s.onInteract(character));
    } // end onInteract

    // improve if have time
    private void updateSuccess(boolean success){
        this.success = success;
    }
} // end class Chest