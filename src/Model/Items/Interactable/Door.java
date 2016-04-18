package Model.Items.Interactable;

import Model.Entity.Character.Character;
import Model.Items.ItemStrategy.InteractableStrategy.DoorStrategy;

/**
 * Created by broskj on 4/7/16.
 */
public class Door extends Interactable {
    public Door(String name) {
        super(new DoorStrategy(), name);
    } // end constructor

    public void onInteract(Character character) {
        //s.onInteract(character.getInventory);
    } // end onInteract
} // end class Door
