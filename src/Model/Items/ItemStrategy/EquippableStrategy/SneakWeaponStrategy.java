package Model.Items.ItemStrategy.EquippableStrategy;

import Model.Entity.Character.Character;
import Model.Items.Item;
import Model.Items.Takeable.Equippable.Weapon.Weapon;

/**
 * Created by broskj on 4/6/16.
 *
 * Class to allow sneaks to equip sneak weapons
 */
public class SneakWeaponStrategy extends EquippableStrategy {
    public void onInteract(Item item, Character character) {
        character.equipSneakWeapon((Weapon)item);
    } // end onInteract
} // end class SneakWeaponStrategy
