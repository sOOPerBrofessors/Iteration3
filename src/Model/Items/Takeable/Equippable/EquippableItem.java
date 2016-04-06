package Model.Items.Takeable.Equippable;

import Model.Items.ItemStrategy.EquippableStrategy.EquippableStrategy;
import Model.Items.Takeable.TakeableItem;

/**
 * Created by broskj on 4/6/16.
 *
 * Abstract class for items which may be equipped by a character.
 */
public abstract class EquippableItem extends TakeableItem {
    protected EquippableStrategy s;

    protected EquippableItem(EquippableStrategy s) {
        super();
        this.s = s;
    } // end protected constructor
} // end abstract class EquippableItem
