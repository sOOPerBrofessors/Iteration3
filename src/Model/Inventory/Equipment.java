package Model.Inventory;

import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.Equippable.Weapon.Weapon;
import Utilities.Observers.Observer;
import Utilities.Observers.Subject;

import java.util.ArrayList;

/**
 * Created by broskj on 4/8/16.
 */
public class Equipment implements Subject{
    private final ArrayList<Observer> observers;
    private Armor armor;
    private Weapon weapon;

    public Equipment() {
        observers = new ArrayList<>();
        this.armor = null;
        this.weapon = null;
    } // end default constructor

    /*
    handle equipping items
    only called by Characters whose occupation allows items of that type to be equipped
     */
    public Weapon equipWeapon(Weapon weapon) {
        Weapon currentWeapon = this.weapon;
        this.weapon = weapon;
        //GameMessageQueue.push("You equipped a " + weapon.getName());
        alert();
        return currentWeapon;
    } // end equipWeapon

    public Armor equipArmor(Armor armor) {
        Armor currentArmor = this.armor;
        this.armor = armor;
        //GameMessageQueue.push("You equipped " + armor.getName());
        alert();
        return currentArmor;
    } // end equipArmor

    public Weapon unequipWeapon() {
        if (this.weapon!=null){ //optimization, needs check for GameMessageQueue regardless
            Weapon currentWeapon = this.weapon;
            this.weapon = null;
            //GameMessageQueue.push("You unequipped your weapon.");
            alert();
            return currentWeapon;
        }
        return null;
    } // end unequipWeapon

    public Armor unequipArmor() {
        if (this.armor!=null) { //optimization, needs check for GameMessageQueue regardless
            Armor currentArmor = this.armor;
            this.armor = null;
            //GameMessageQueue.push("You unequipped your armor.");
            alert();
            return currentArmor;
        }
        return null;
    } // end unequipArmor

    public int getArmorValue() { return armor != null ? armor.getArmorValue() : 0; }
    public int getWeaponValue() { return weapon != null ? weapon.getWeaponValue() : 0; }

    public Armor getArmor() {return armor;}

    public Weapon getWeapon() {return weapon;}

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    } // end addObserver

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    } // end removeObserver

    @Override
    public void alert() {
        observers.forEach(Observer::update);
    } // end alert
} // end class Equipment
