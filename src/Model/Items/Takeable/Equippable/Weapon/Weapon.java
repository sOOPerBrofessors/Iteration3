package Model.Items.Takeable.Equippable.Weapon;

import Model.Items.ItemStrategy.EquippableStrategy.EquippableStrategy;
import Model.Items.ItemStrategy.EquippableStrategy.SmasherWeaponStrategy;
import Model.Items.ItemStrategy.EquippableStrategy.SneakWeaponStrategy;
import Model.Items.ItemStrategy.EquippableStrategy.SummonerWeaponStrategy;
import Model.Items.Takeable.Equippable.EquippableItem;

/**
 * Created by broskj on 4/6/16.
 *
 * Weapon class that uses factory methods to create occupation-specific weapons.  Will
 *  likely need a decorator.
 */
public abstract class Weapon extends EquippableItem {
    private int weaponValue;
    protected double attackInterval;

    protected Weapon(String name, String description, EquippableStrategy s, int weaponValue, int value) {
        super(name, description, s, value);
        this.weaponValue = weaponValue;
    }

    public int getWeaponValue() { return this.weaponValue; }

    public double getAttackInterval() { return this.attackInterval; }
} // end class Weapon
