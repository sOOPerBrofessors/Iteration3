package Model.Items.ItemStrategy.EquippableStrategy;

import Model.Entity.Character.Character;
import Model.Items.Item;
import Model.Items.Takeable.Equippable.Weapon.Weapon;
import Model.Items.Takeable.TakeableItem;

/**
 * Created by broskj on 4/6/16.
 *
 * Class to allow sneaks to equip sneak weapons
 */
public class SneakWeaponStrategy extends EquippableStrategy {
    public boolean onInteract(TakeableItem item, Character character) {
        character.equipSneakWeapon((Weapon)item);
        System.out.println("sneak weapon equipped");
        return true;
    } // end onInteract
} // end class SneakWeaponStrategy
