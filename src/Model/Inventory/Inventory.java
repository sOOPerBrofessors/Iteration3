package Model.Inventory;

import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.Equippable.Weapon;
import Utilities.MessageHandler;

/**
 * Created by broskj on 4/8/16.
 */
public class Inventory {
    private Pack pack;
    private Equipment equipment;

    public Inventory() {
        this.pack = new Pack();
        this.equipment = new Equipment();
    } // end default constructor

    public void equipWeapon(Weapon weapon) {
        if (pack.remove(weapon)) {
            pack.add(equipment.equipWeapon(weapon));    // add currently equipped weapon to pack; remove from pack
        }
    } // end equipWeapon

    public void equipArmor(Armor armor) {
        if (pack.remove(armor)) {
            pack.add(equipment.equipArmor(armor));      // add currently equipped armor to pack; remove from pack
        }
    } // end equipArmor

    public void unequipWeapon() {
        if(pack.hasRoom()) {
            pack.add(equipment.unequipWeapon());        // add equipped weapon to pack if room exists
        } else {
            MessageHandler.printError("Inventory full.");
        }
    } // end unequipWeapon

    public void unequipArmor() {
        if(pack.hasRoom()) {
            pack.add(equipment.unequipArmor());         // add equipped armor to pack if room exists
        } else {
            MessageHandler.printError("Inventory full.");
        }
    } // end unequipArmor

} // end class Inventory
