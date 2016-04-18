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
import Model.Skills.RangedSkills.*;
import Model.Skills.Skill;
import Model.Skills.SkillsWithDuration.Creep;
import Model.Stats.CharacterStats;
import Utilities.Visitor.OccupationVisitor;

import java.util.ArrayList;

/**
 * Created by broskj on 4/6/16.
 *
 * Class to allow a character access to only sneak equippables, skills, and abilities.
 */
public class Sneak extends Occupation {

    @Override
    public boolean equipSneakWeapon(Weapon weapon, Character character) {
        character.equipWeapon(weapon);
        return true;
    } // end equipSneakWeapon

    @Override
    public boolean equipSneakArmor(Armor armor, Character character) {
        character.equipArmor(armor);
        return true;
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
    public ArrayList<Skill> getSkillList(Avatar avatar) {
        skillList.add(new BindWounds(avatar));
        skillList.add(new Observation(avatar));
        skillList.add(new PickPocket(avatar));
        skillList.add(new DetectTrap(avatar));
        skillList.add(new RemoveTrap(avatar));
        skillList.add(new Creep(avatar));
        skillList.add(new RangedWeapon(avatar));

        return skillList;

    }
} // end class Sneak
