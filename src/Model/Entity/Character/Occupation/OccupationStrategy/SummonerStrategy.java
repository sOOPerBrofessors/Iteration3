package Model.Entity.Character.Occupation.OccupationStrategy;

import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.Equippable.Weapon;
import Model.Entity.Character.Character;

/**
 * Created by broskj on 4/6/16.
 *
 * Class to handle equipping Summoner items and using Summoner abilities.  Overrides
 *  default error printing from superclass.
 */
public class SummonerStrategy extends OccupationStrategy {

    public void equipSummonerWeapon(Weapon weapon, Character character) {
        character.equipWeapon(weapon);
    } // end equipSummonerWeapon

    public void equipSummonerArmor(Armor armor, Character character) {
        character.equipArmor(armor);
    } // end equipSummonerArmor
} // end class SummonerStrategy
