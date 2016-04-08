package Model.Entity.Character.Occupation;

import Model.Entity.Character.Character;
import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.Equippable.Weapon;
import Model.Stats.CharacterStats;

/**
 * Created by broskj on 4/6/16.
 *
 * Class to allow a character access to only sneak equippables, skills, and abilities.
 */
public class Sneak extends Occupation {

    public void equipSneakWeapon(Weapon weapon, Character character) {
        character.equipWeapon(weapon);
    } // end equipSneakWeapon

    public void equipSneakArmor(Armor armor, Character character) {
        character.equipArmor(armor);
    } // end equipSneakArmor

    public static CharacterStats initStats() {
        return CharacterStats.makeSneakStats();
    } // end initStats
} // end class Sneak
