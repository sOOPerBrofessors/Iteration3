package Model.Items.ItemStrategy.EquippableStrategy;

import Model.Items.Item;
import Model.Entity.Character.Character;
import Model.Items.Takeable.Equippable.Weapon.Weapon;

/**
 * Created by broskj on 4/6/16.
 *
 * Class to allow smashers to equip smasher weapons
 */
public class SmasherWeaponStrategy extends EquippableStrategy {
    public void onInteract(Item item, Character character) {
        character.equipSmasherWeapon((Weapon)item);
    } // end onInteract
} // end class SmasherWeaponStrategy
