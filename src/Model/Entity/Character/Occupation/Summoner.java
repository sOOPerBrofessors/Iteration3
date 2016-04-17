package Model.Entity.Character.Occupation;

import Model.Entity.Character.Character;
import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.Equippable.Weapon.Weapon;
import Model.Map.Orientation;
import Model.Stats.CharacterStats;
import Utilities.Visitor.OccupationVisitor;

/**
 * Created by broskj on 4/6/16.
 *
 * Class to allow a character access to only summoner equippables, skills, and abilities.
 */
public class Summoner extends Occupation {

    @Override
    public void equipSummonerWeapon(Weapon weapon, Character character) {
        character.equipWeapon(weapon);
    } // end equipSummonerWeapon

    @Override
    public void equipSummonerArmor(Armor armor, Character character) {
        character.equipArmor(armor);
    } // end equipSummonerArmor

    @Override
    public CharacterStats initStats() {
        return CharacterStats.makeSummonerStats();
    } // end initStats

    @Override
    public void acceptOccupationVistor(OccupationVisitor occupationViewVisitor, Orientation orientation) {
        occupationViewVisitor.visitSummoner(orientation);
    }
} // end class Summoner
