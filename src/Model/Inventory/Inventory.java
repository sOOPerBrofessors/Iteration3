package Model.Inventory;

import Model.Items.Item;
import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.Equippable.Weapon;
import Utilities.ErrorLevel;
import Utilities.GameMessageQueue;
import Utilities.MessageHandler;
import Utilities.Observers.Observer;
import Utilities.Observers.Subject;

import java.util.ArrayList;

/**
 * Created by broskj on 4/8/16.
 */
public class Inventory implements Observer, Subject{
    private ArrayList<Observer> observers;
    private Pack pack;
    private Equipment equipment;

    public Inventory() {
        observers = new ArrayList<>();
        this.pack = new Pack();
        this.equipment = new Equipment();
        equipment.addObserver(this);
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
            GameMessageQueue.push("Inventory full, can't remove weapon.");
        }
    } // end unequipWeapon

    public void unequipArmor() {
        if(pack.hasRoom()) {
            pack.add(equipment.unequipArmor());         // add equipped armor to pack if room exists
        } else {
            GameMessageQueue.push("Inventory full, can't remove armor.");
        }
    } // end unequipArmor

    public int getWeaponValue() {
        return equipment.getWeaponValue();
    } // end getWeaponValue

    public int getArmorValue() {
        return equipment.getArmorValue();
    } // end getArmorValue

    public Pack getPack() { return pack;}

    public Equipment getEquipment(){return equipment;}

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

    @Override
    public void update() {
        alert();
    } // end update

    @Override
    public void remove() {

    } // end remove

    public void pickUpItem(Item item){
        pack.add(item);
        System.out.println("item added to pack, size is " + pack.size());
    }
} // end class Inventory
