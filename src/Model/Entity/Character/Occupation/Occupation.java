package Model.Entity.Character.Occupation;

import Model.Entity.Character.Character;
import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.Equippable.Weapon;
import Model.Stats.CharacterStats;
import Utilities.ErrorLevel;
import Utilities.MessageHandler;

/**
 * Created by broskj on 4/6/16.
 *
 * Class designed to allow a Character access to certain skills, abilities, and items.
 */
public abstract class Occupation {

    public abstract CharacterStats initStats();

    public void equipSmasherWeapon(Weapon weapon, Character character) {
        MessageHandler.println("You cannot equip this weapon.", ErrorLevel.ERROR);
    } // end equipSmasherWeapon

    public void equipSmasherArmor(Armor armor, Character character) {
        MessageHandler.println("You cannot equip this armor.", ErrorLevel.ERROR);
    } // end equipSmasherArmor

    public void equipSneakWeapon(Weapon weapon, Character character) {
        MessageHandler.println("You cannot equip this weapon.", ErrorLevel.ERROR);
    } // end equipSneakWeapon

    public void equipSneakArmor(Armor armor, Character character) {
        MessageHandler.println("You cannot equip this armor.", ErrorLevel.ERROR);
    } // end equipSneakArmor

    public void equipSummonerWeapon(Weapon weapon, Character character) {
        MessageHandler.println("You cannot equip this weapon.", ErrorLevel.ERROR);
    } // end equipSummonerWeapon

    public void equipSummonerArmor(Armor armor, Character character) {
        MessageHandler.println("You cannot equip this armor.", ErrorLevel.ERROR);
    } // end equipSummonerArmor
} // end class Occupation
