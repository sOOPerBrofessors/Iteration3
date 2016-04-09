package Model.Items.Takeable.Equippable;

import Model.Entity.Character.Character;
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

    private Weapon(EquippableStrategy s) {
        super(s);
        this.weaponValue = 0;
        /*
        todo: change constructor to take in weapon value
         */
    } // end private constructor

    public Weapon makeSmasherWeapon() {
        return new Weapon(new SmasherWeaponStrategy());
    } // end factory method makeSmasherWeapon

    public Weapon makeSneakWeapon() {
        return new Weapon(new SneakWeaponStrategy());
    } // end factory method makeSneakWeapon

    public Weapon makeSummonerWeapon() {
        return new Weapon(new SummonerWeaponStrategy());
    } // end factory method makeSummonerWeapon

    public void onInteract(Character character) {
        s.onInteract(this, character);
    } // end onInteract

    public int getWeaponValue() { return this.weaponValue; }
} // end class Weapon
