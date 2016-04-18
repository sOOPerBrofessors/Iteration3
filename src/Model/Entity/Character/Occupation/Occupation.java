package Model.Entity.Character.Occupation;

import Model.Entity.Character.Avatar;
import Model.Entity.Character.Character;
import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.Equippable.Weapon.Weapon;
import Model.Skills.Skill;
import Model.Stats.CharacterStats;
import Utilities.ErrorLevel;
import Utilities.MessageHandler;
import Utilities.Visitor.OccupationVisitable;

import java.util.ArrayList;

/**
 * Created by broskj on 4/6/16.
 *
 * Class designed to allow a Character access to certain skills, abilities, and items.
 */
public abstract class Occupation implements OccupationVisitable {

    final ArrayList<Skill> skillList = new ArrayList<>();

    public abstract CharacterStats initStats();
    public abstract String toString();

    public boolean equipSmasherWeapon(Weapon weapon, Character character) {
        MessageHandler.println("You cannot equip this weapon.", ErrorLevel.ERROR);
        return false;
    } // end equipSmasherWeapon

    public boolean equipSmasherArmor(Armor armor, Character character) {
        MessageHandler.println("You cannot equip this armor.", ErrorLevel.ERROR);
        return false;
    } // end equipSmasherArmor

    public boolean equipSneakWeapon(Weapon weapon, Character character) {
        MessageHandler.println("You cannot equip this weapon.", ErrorLevel.ERROR);
        return false;
    } // end equipSneakWeapon

    public boolean equipSneakArmor(Armor armor, Character character) {
        MessageHandler.println("You cannot equip this armor.", ErrorLevel.ERROR);
        return false;
    } // end equipSneakArmor

    public boolean equipSummonerWeapon(Weapon weapon, Character character) {
        MessageHandler.println("You cannot equip this weapon.", ErrorLevel.ERROR);
        return false;
    } // end equipSummonerWeapon

    public boolean equipSummonerArmor(Armor armor, Character character) {
        MessageHandler.println("You cannot equip this armor.", ErrorLevel.ERROR);
        return false;
    } // end equipSummonerArmor

    public abstract ArrayList<Skill> getSkillList(Avatar avatar);
} // end class Occupation
