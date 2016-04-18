package Model.Items.ItemStrategy.EquippableStrategy;

import Model.Entity.Character.Character;
import Model.Items.Item;
import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.TakeableItem;

/**
 * Created by broskj on 4/6/16.
 *
 * Class to allow smashers to equip smasher armor
 */
public class SmasherArmorStrategy extends EquippableStrategy {
    public void onInteract(TakeableItem item, Character character) {
        character.equipSmasherArmor((Armor)item);
    } // end onInteract
} // end class SmasherArmorStrategy
