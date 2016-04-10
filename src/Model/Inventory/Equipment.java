package Model.Inventory;

import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.Equippable.Weapon;
import Utilities.Observer;
import Utilities.Subject;

import java.util.ArrayList;

/**
 * Created by broskj on 4/8/16.
 */
public class Equipment implements Subject{
    private ArrayList<Observer> observers;
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
        alert();
        return currentWeapon;
    } // end equipWeapon

    public Armor equipArmor(Armor armor) {
        Armor currentArmor = this.armor;
        this.armor = armor;
        alert();
        return currentArmor;
    } // end equipArmor

    public Weapon unequipWeapon() {
        Weapon currentWeapon = this.weapon;
        this.weapon = null;
        alert();
        return currentWeapon;
    } // end unequipWeapon

    public Armor unequipArmor() {
        Armor currentArmor = this.armor;
        this.armor = null;
        alert();
        return currentArmor;
    } // end unequipArmor

    public int getArmorValue() { return armor.getArmorValue(); }
    public int getWeaponValue() { return weapon.getWeaponValue(); }

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
