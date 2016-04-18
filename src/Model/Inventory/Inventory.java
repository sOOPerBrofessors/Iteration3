package Model.Inventory;

import Model.Entity.Character.Character;
import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.Equippable.Weapon.Weapon;
import Model.Items.Takeable.TakeableItem;
import Model.Items.Takeable.Useable.Money;
import Utilities.ItemStuff.ItemManager;
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

    public Inventory(Weapon weapon, Armor armor, TakeableItem... items) {
        observers = new ArrayList<>();
        this.pack = new Pack();
        this.equipment = new Equipment();
        equipment.addObserver(this);

        if(weapon != null)
            equipWeapon(weapon);
        if(armor != null)
            equipArmor(armor);
        for(TakeableItem i : items) {
            add(i);
        }
    } // end constructor

    public TakeableItem dropItem(int index){
        TakeableItem temp = pack.remove(index);
        alert();
        return temp;
    }

    public void dump(ItemManager itemManager, Character character) {
        pack.dump(itemManager, character);
    } // end dump

    public void add(TakeableItem item) {
        pack.add(item);
    } // end add

    public void utilizeItem(int index, Character character){
        pack.utilizeItem(index,character);
    }

    public Weapon equipWeapon(Weapon weapon) {
        return equipment.equipWeapon(weapon);
    } // end equipWeapon

    public Armor equipArmor(Armor armor) {
        return equipment.equipArmor(armor);
    } // end equipArmor

    public boolean unequipWeapon() {
        if(pack.hasRoom()) {
            pack.add(equipment.unequipWeapon());        // add equipped weapon to pack if room exists
            return true;
        }
        return false;
    } // end unequipWeapon

    public boolean unequipArmor() {
        if(pack.hasRoom()) {
            pack.add(equipment.unequipArmor());         // add equipped armor to pack if room exists
            return true;
        }
        return false;
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

    public Armor getArmor(){return equipment.getArmor();}

    public Weapon getWeapon() {return equipment.getWeapon();}

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

    public boolean pickUpItem(TakeableItem item){
        return pack.add(item);
    }

    public void pickUpMoney(Money money) {
        pack.addMoney(money);
    }

    public void spendMoney(int amount) { pack.spendMoney(amount); }

} // end class Inventory
