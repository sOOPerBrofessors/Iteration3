package Model.Items.Takeable.Useable;

import Model.Effect.Effect;
import Model.Entity.Character.Character;
import Model.Items.Takeable.TakeableItem;

/**
 * Created by broskj on 4/6/16.
 *
 * Abstract class for items which may be used/consumed by a character.
 */
public abstract class UseableItem extends TakeableItem {

    protected Effect e;
    protected int amount;

    protected UseableItem() {
        super();
    } // end protected constructor

    // apply effect to passed in character
    protected void utilize(Character character){e.execute(character, amount);};
} // end abstract class UseableItem
