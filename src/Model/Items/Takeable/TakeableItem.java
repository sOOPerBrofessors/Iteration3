package Model.Items.Takeable;

import Model.Entity.Character.Character;
import Model.Items.Item;

/**
 * Created by broskj on 4/6/16.
 *
 * Abstract class for items which may be picked up from the map by a character.
 */
public abstract class TakeableItem extends Item {

    // if character interacts with item on map
    public void onInteract(Character character) {
        character.pickUpItem(this);
    } // end onInteract

    protected abstract void utilize(Character character); // either apply item's effect or equip
}