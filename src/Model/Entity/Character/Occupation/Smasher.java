package Model.Entity.Character.Occupation;

import Model.Entity.Character.Avatar;
import Model.Entity.Character.Character;
import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.Equippable.Weapon.Weapon;
import Model.Map.Orientation;
import Model.Skills.BindWounds;
import Model.Skills.CombatSkills.BrawlingSkill;
import Model.Skills.CombatSkills.OneHandedWeaponSkill;
import Model.Skills.CombatSkills.TwoHandedWeaponSkill;
import Model.Skills.RangedSkills.Cleave;
import Model.Skills.RangedSkills.EarthShake;
import Model.Skills.RangedSkills.Observation;
import Model.Skills.Skill;
import Model.Stats.CharacterStats;
import Utilities.Visitor.OccupationVisitor;

import java.util.ArrayList;

/**
 * Created by broskj on 4/6/16.
 *
 * Class to allow a character access to only smasher equippables, skills, and abilities.
 */
public class Smasher extends Occupation {

    @Override
    public boolean equipSmasherWeapon(Weapon weapon, Character character) {
        character.equipWeapon(weapon);
        return true;
    } // end equipSmasherWeapon

    @Override
    public boolean equipSmasherArmor(Armor armor, Character character) {
        character.equipArmor(armor);
        return true;
    } // end equipSmasherArmor

    @Override
    public CharacterStats initStats() {
        return CharacterStats.makeSmasherStats();
    } // end initStats

    @Override
    public void acceptOccupationVistor(OccupationVisitor occupationViewVisitor, Orientation orientation) {
        occupationViewVisitor.visitSmasher(orientation);
    }

    @Override
    public String toString() {
        return "smasher";
    }

    public ArrayList<Skill> getSkillList(Avatar avatar) {
        skillList.add(new BindWounds(avatar));
        skillList.add(new Observation(avatar));
        skillList.add(new OneHandedWeaponSkill(avatar));
        skillList.add(new TwoHandedWeaponSkill(avatar));
        skillList.add(new BrawlingSkill(avatar));
        skillList.add(new EarthShake(avatar));
        skillList.add(new Cleave(avatar));

        return skillList;
    }

} // end class Smasher
