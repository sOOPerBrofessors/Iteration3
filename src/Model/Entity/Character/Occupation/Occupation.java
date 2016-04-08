package Model.Entity.Character.Occupation;

import Utilities.MessageHandler;

/**
 * Created by broskj on 4/6/16.
 *
 * Class designed to allow a Character access to certain skills, abilities, and items.
 */
public abstract class Occupation {
    public void equipSmasherWeapon() {
        MessageHandler.printError("You cannot equip this weapon.");
    } // end equipSmasherWeapon

    public void equipSmasherArmor() {
        MessageHandler.printError("You cannot equip this armor.");
    } // end equipSmasherArmor

    public void equipSneakWeapon() {
        MessageHandler.printError("You cannot equip this item.");
    } // end equipSneakWeapon

    public void equipSneakArmor() {
        MessageHandler.printError("You cannot equip this armor.");
    } // end equipSneakArmor

    public void equipSummonerWeapon() {
        MessageHandler.printError("You cannot equip this item.");
    } // end equipSummonerWeapon

    public void equipSummonerArmor() {
        MessageHandler.printError("You cannot equip this armor.");
    } // end equipSummonerArmor
} // end class Occupation
