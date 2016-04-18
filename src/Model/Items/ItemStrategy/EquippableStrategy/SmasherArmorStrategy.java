package Model.Items.ItemStrategy.EquippableStrategy;

import Model.Entity.Character.Character;
import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.TakeableItem;

/**
 * Created by broskj on 4/6/16.
 *
 * Class to allow smashers to equip smasher armor
 */
public class SmasherArmorStrategy extends EquippableStrategy {
    public boolean onInteract(TakeableItem item, Character character) {
        character.equipSmasherArmor((Armor)item);
        return true;
    } // end onInteract
} // end class SmasherArmorStrategy
