package Model.Items.ItemStrategy.EquippableStrategy;

import Model.Entity.Character.Character;
import Model.Items.Item;
import Model.Items.Takeable.Equippable.Armor;

/**
 * Created by broskj on 4/6/16.
 *
 * Class to allow sneaks to equip sneak armor
 */
public class SneakArmorStrategy extends EquippableStrategy {
    public void onInteract(Item item, Character character) {
        character.equipSneakArmor((Armor)item);
    } // end onInteract
} // end class SneakArmorStrategy
