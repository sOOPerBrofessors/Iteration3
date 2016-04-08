package Model.Entity.Character.Occupation;

import Model.Entity.Character.Character;
import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.Equippable.Weapon;
import Model.Stats.CharacterStats;

/**
 * Created by broskj on 4/6/16.
 *
 * Class to allow a character access to only smasher equippables, skills, and abilities.
 */
public class Smasher extends Occupation {

    public void equipSmasherWeapon(Weapon weapon, Character character) {
        character.equipWeapon(weapon);
    } // end equipSmasherWeapon

    public void equipSmasherArmor(Armor armor, Character character) {
        character.equipArmor(armor);
    } // end equipSmasherArmor

    public static CharacterStats initStats() {
        return CharacterStats.makeSmasherStats();
    } // end initStats
} // end class Smasher
