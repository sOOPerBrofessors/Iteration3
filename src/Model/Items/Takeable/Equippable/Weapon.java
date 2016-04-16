package Model.Items.Takeable.Equippable;

import Model.Items.ItemStrategy.EquippableStrategy.EquippableStrategy;
import Model.Items.ItemStrategy.EquippableStrategy.SmasherWeaponStrategy;
import Model.Items.ItemStrategy.EquippableStrategy.SneakWeaponStrategy;
import Model.Items.ItemStrategy.EquippableStrategy.SummonerWeaponStrategy;

/**
 * Created by broskj on 4/6/16.
 *
 * Weapon class that uses factory methods to create occupation-specific weapons.  Will
 *  likely need a decorator.
 */
public class Weapon extends EquippableItem {

    private int weaponValue;

    private Weapon(String name, String description, EquippableStrategy s, int value) {
        super(name, description, s);
        this.weaponValue = value;
        /*
        todo: change constructor to take in weapon value
         */
    } // end private constructor

    public static Weapon makeSmasherWeapon(String name, String description, int value) {
        return new Weapon(name, description, new SmasherWeaponStrategy(), value);
    } // end factory method makeSmasherWeapon

    public Weapon makeSneakWeapon(String name, String description, int value) {
        return new Weapon(name, description, new SneakWeaponStrategy(), value);
    } // end factory method makeSneakWeapon

    public Weapon makeSummonerWeapon(String name, String description, int value) {
        return new Weapon(name, description, new SummonerWeaponStrategy(), value);
    } // end factory method makeSummonerWeapon

    public int getWeaponValue() { return this.weaponValue; }
} // end class Weapon
