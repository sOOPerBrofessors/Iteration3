package Model.Entity.Character.Occupation;

import Model.Entity.Character.Avatar;
import Model.Entity.Character.Character;
import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.Equippable.Weapon.Weapon;
import Model.Map.Orientation;
import Model.Skills.BindWounds;
import Model.Skills.CombatSkills.StaffSkill;
import Model.Skills.RangedSkills.*;
import Model.Skills.Skill;
import Model.Skills.SkillsWithDuration.Boon;
import Model.Stats.CharacterStats;
import Utilities.Visitor.OccupationVisitor;

import java.util.ArrayList;

/**
 * Created by broskj on 4/6/16.
 *
 * Class to allow a character access to only summoner equippables, skills, and abilities.
 */
public class Summoner extends Occupation {

    @Override
    public boolean equipSummonerWeapon(Weapon weapon, Character character) {
        character.equipWeapon(weapon);
        return true;
    } // end equipSummonerWeapon

    @Override
    public boolean equipSummonerArmor(Armor armor, Character character) {
        character.equipArmor(armor);
        return true;
    } // end equipSummonerArmor

    @Override
    public CharacterStats initStats() {
        return CharacterStats.makeSummonerStats();
    } // end initStats

    @Override
    public void acceptOccupationVistor(OccupationVisitor occupationViewVisitor, Orientation orientation) {
        occupationViewVisitor.visitSummoner(orientation);
    }

    @Override
    public String toString() {
        return "summoner";
    }

    public ArrayList<Skill> getSkillList(Avatar avatar) {
        skillList.add(new BindWounds(avatar));
        skillList.add(new Observation(avatar));
        skillList.add(new Enchantment(avatar));
        skillList.add(new Boon(avatar));
        skillList.add(new Bane(avatar));
        skillList.add(new Fireball(avatar));
        skillList.add(new StaffSkill(avatar));
        skillList.add(new ArcaneExplosion(avatar));

        return skillList;
    }
} // end class Summoner
