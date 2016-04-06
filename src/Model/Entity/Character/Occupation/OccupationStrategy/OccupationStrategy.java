package Model.Entity.Character.Occupation.OccupationStrategy;

import Utilities.MessageHandler;

/**
 * Created by broskj on 4/6/16.
 *
 * Abstract class to provide default error printing for equipping weapons and armor.  Methods are to be overridden
 *  by subclasses to explicitly allow equipping of certain items based on occupation.
 */
public abstract class OccupationStrategy {
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
} // end class OccupationStrategy
