package Model.Entity.Character.Occupation;

import Model.Entity.Character.Character;
import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.Equippable.Weapon;
import Model.Stats.CharacterStats;
import Utilities.MessageHandler;

/**
 * Created by broskj on 4/6/16.
 *
 * Class designed to allow a Character access to certain skills, abilities, and items.
 */
public abstract class Occupation {

    public abstract CharacterStats initStats();

    public void equipSmasherWeapon(Weapon weapon, Character character) {
        MessageHandler.printError("You cannot equip this weapon.");
    } // end equipSmasherWeapon

    public void equipSmasherArmor(Armor armor, Character character) {
        MessageHandler.printError("You cannot equip this armor.");
    } // end equipSmasherArmor

    public void equipSneakWeapon(Weapon weapon, Character character) {
        MessageHandler.printError("You cannot equip this item.");
    } // end equipSneakWeapon

    public void equipSneakArmor(Armor armor, Character character) {
        MessageHandler.printError("You cannot equip this armor.");
    } // end equipSneakArmor

    public void equipSummonerWeapon(Weapon weapon, Character character) {
        MessageHandler.printError("You cannot equip this item.");
    } // end equipSummonerWeapon

    public void equipSummonerArmor(Armor armor, Character character) {
        MessageHandler.printError("You cannot equip this armor.");
    } // end equipSummonerArmor
} // end class Occupation
