package Model.Inventory;

import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.Equippable.Weapon.Weapon;
import Model.Items.Takeable.TakeableItem;
import Model.Items.Takeable.Useable.Money;
import Utilities.GameMessageQueue;
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

    public TakeableItem dropItem(int index){
        TakeableItem temp = pack.remove(index);
        alert();
        return temp;
    }

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
            GameMessageQueue.push("Your inventory is full, can't remove weapon.");
        }
    } // end unequipWeapon

    public void unequipArmor() {
        if(pack.hasRoom()) {
            pack.add(equipment.unequipArmor());         // add equipped armor to pack if room exists
        } else {
            GameMessageQueue.push("Inventory full, can't remove armor.");
        }
    } // end unequipArmor

    public boolean removeItem(TakeableItem item) { //NEEDS ALERT
        return pack.remove(item);
    } // end removeItem

//    public TakeableItem removeItem(int index) { //NEEDS ALERT
//        TakeableItem temp = pack.remove(index);
//        alert();
//        return temp;
//    }

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

    public void pickUpItem(TakeableItem item){
        pack.add(item);
    }

    public void pickUpMoney(Money money) {
        pack.addMoney(money);
    }

} // end class Inventory
