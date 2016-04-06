package Model.Entity.Character.Occupation.OccupationStrategy;

import Model.Entity.Character.Character;
import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.Equippable.Weapon;

/**
 * Created by broskj on 4/6/16.
 *
 * Class to handle equipping Sneak items and using Sneak abilities.  Overrides
 *  default error printing from superclass.
 */
public class SneakStrategy extends OccupationStrategy {

    public void equipSneakWeapon(Weapon weapon, Character character) {
        character.equipWeapon(weapon);
    } // end equipSneakWeapon

    public void equipSneakArmor(Armor armor, Character character) {
        character.equipArmor(armor);
    } // end equipSneakArmor
} // end class SneakStrategy
