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
 * Class to allow a character access to only sneak equippables, skills, and abilities.
 */
public class Sneak extends Occupation {

    @Override
    public void equipSneakWeapon(Weapon weapon, Character character) {
        character.equipWeapon(weapon);
    } // end equipSneakWeapon

    @Override
    public void equipSneakArmor(Armor armor, Character character) {
        character.equipArmor(armor);
    } // end equipSneakArmor

    @Override
    public CharacterStats initStats() {
        return CharacterStats.makeSneakStats();
    } // end initStats

    @Override
    public void acceptOccupationVistor(OccupationVisitor occupationViewVisitor, Orientation orientation) {
        occupationViewVisitor.visitSneak(orientation);
    }

    @Override
    public String toString() {
        return "sneak";
    }
} // end class Sneak
