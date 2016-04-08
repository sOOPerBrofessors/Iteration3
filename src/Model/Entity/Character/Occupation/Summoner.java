package Model.Entity.Character.Occupation;

import Model.Entity.Character.Character;
import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.Equippable.Weapon;
import Model.Stats.CharacterStats;

/**
 * Created by broskj on 4/6/16.
 *
 * Class to allow a character access to only summoner equippables, skills, and abilities.
 */
public class Summoner extends Occupation {

    public void equipSummonerWeapon(Weapon weapon, Character character) {
        character.equipWeapon(weapon);
    } // end equipSummonerWeapon

    public void equipSummonerArmor(Armor armor, Character character) {
        character.equipArmor(armor);
    } // end equipSummonerArmor

    public static CharacterStats initStats() {
        return CharacterStats.makeSummonerStats();
    } // end initStats
} // end class Summoner
