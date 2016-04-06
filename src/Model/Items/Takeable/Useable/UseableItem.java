package Model.Items.Takeable.Useable;

import Model.Items.ItemStrategy.UseableStrategy;
import Model.Items.Takeable.TakeableItem;

/**
 * Created by broskj on 4/6/16.
 *
 * Abstract class for items which may be used/consumed by a character.
 */
public abstract class UseableItem extends TakeableItem {
    protected UseableStrategy s;

    protected UseableItem(UseableStrategy s) {
        super();
        this.s = s;
    } // end protected constructor
} // end abstract class UseableItem
