package Model.Entity.Character.Occupation;

import Model.Entity.Character.Avatar;
import Model.Entity.Character.Character;
import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.Equippable.Weapon.Weapon;
import Model.Map.Location;
import Model.Map.Orientation;
import Model.Skills.BindWounds;
import Model.Skills.CombatSkills.BrawlingSkill;
import Model.Skills.CombatSkills.OneHandedWeaponSkill;
import Model.Skills.CombatSkills.TwoHandedWeaponSkill;
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
    public void acceptOccupationVistor(OccupationVisitor occupationViewVisitor, Orientation orientation) {
        occupationViewVisitor.visitSmasher(orientation);
    }

    public ArrayList<Skill> getSkillList(Avatar avatar) {
        skillList.add(new BindWounds(avatar));
        skillList.add(new Observation(avatar));
        skillList.add(new OneHandedWeaponSkill(avatar));
        skillList.add(new TwoHandedWeaponSkill(avatar));
        skillList.add(new BrawlingSkill(avatar));

        return skillList;
    }

} // end class Smasher
