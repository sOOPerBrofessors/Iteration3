package Model.Items.Takeable.Equippable;

import Model.Entity.Character.Character;
import Model.Items.ItemStrategy.EquippableStrategy.EquippableStrategy;
import Model.Items.Takeable.TakeableItem;

/**
 * Created by broskj on 4/6/16.
 *
 * Abstract class for items which may be equipped by a character.
 */
public abstract class EquippableItem extends TakeableItem {

    protected EquippableStrategy s;

    protected EquippableItem(String name, String description, EquippableStrategy s, int value) {
        super(name,description, value);
        this.s = s;
    } // end protected constructor

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void utilize(Character character) {
        s.onInteract(this, character);
    } // end onInteract
} // end abstract class EquippableItem
