package Model.Items.Interactable;

import Model.Entity.Character.Character;
import Model.Items.ItemStrategy.InteractableStrategy.ChestStrategy;

/**
 * Created by broskj on 4/7/16.
 */
public class Chest extends Interactable {
    public Chest() {
        super(new ChestStrategy());
    } // end constructor

    public void onInteract(Character character) {
        s.onInteract(this, character);
    } // end onInteract
} // end class Chest
