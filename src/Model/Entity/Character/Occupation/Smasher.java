package Model.Entity.Character.Occupation;

import Model.Entity.Character.Character;
import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.Equippable.Weapon;
import Model.Map.Orientation;
import Model.Stats.CharacterStats;
import Utilities.Visitor.OccupationViewVisitor;

/**
 * Created by broskj on 4/6/16.
 *
 * Class to allow a character access to only smasher equippables, skills, and abilities.
 */
public class Smasher extends Occupation {

    @Override
    public void equipSmasherWeapon(Weapon weapon, Character character) {
        character.equipWeapon(weapon);
    } // end equipSmasherWeapon

    @Override
    public void equipSmasherArmor(Armor armor, Character character) {
        character.equipArmor(armor);
    } // end equipSmasherArmor

    @Override
    public CharacterStats initStats() {
        return CharacterStats.makeSmasherStats();
    } // end initStats

    @Override
    public void acceptOccupationViewVistor(OccupationViewVisitor occupationViewVisitor, Orientation orientation) {
        occupationViewVisitor.createSmasherView(orientation);
    }
} // end class Smasher
