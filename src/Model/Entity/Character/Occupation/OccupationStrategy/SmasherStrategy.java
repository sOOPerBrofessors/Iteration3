package Model.Entity.Character.Occupation.OccupationStrategy;

import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.Equippable.Weapon;
import Model.Entity.Character.Character;

/**
 * Created by broskj on 4/6/16.
 *
 * Class to handle equipping Smasher items and using Smasher abilities.  Overrides
 *  default error printing from superclass.
 */
public class SmasherStrategy extends OccupationStrategy {

    public void equipSmasherWeapon(Weapon weapon, Character character) {
        character.equipWeapon(weapon);
    } // end equipSmasherWeapon

    public void equipSmasherArmor(Armor armor, Character character) {
        character.equipArmor(armor);
    } // end equipSmasherArmor
} // end class SmasherStrategy
