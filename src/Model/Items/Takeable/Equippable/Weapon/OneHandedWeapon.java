package Model.Items.Takeable.Equippable.Weapon;

import Model.Items.ItemStrategy.EquippableStrategy.EquippableStrategy;
import Model.Items.ItemStrategy.EquippableStrategy.SmasherWeaponStrategy;
import Model.Items.ItemStrategy.EquippableStrategy.SneakWeaponStrategy;
import Model.Items.ItemStrategy.EquippableStrategy.SummonerWeaponStrategy;

/**
 * Created by broskj on 4/16/16.
 */
public class OneHandedWeapon extends Weapon {

    private OneHandedWeapon(String name, String description, EquippableStrategy s, int weaponValue) {
        super(name, description, s, weaponValue);
    } // end private constructor

    public static OneHandedWeapon makeSmasherWeapon(String name, String description, int value) {
        return new OneHandedWeapon(name, description, new SmasherWeaponStrategy(), value);
    } // end factory method makeSmasherWeapon

    public static OneHandedWeapon makeSneakWeapon(String name, String description, int value) {
        return new OneHandedWeapon(name, description, new SneakWeaponStrategy(), value);
    } // end factory method makeSneakWeapon

    public static OneHandedWeapon makeSummonerWeapon(String name, String description, int value) {
        return new OneHandedWeapon(name, description, new SummonerWeaponStrategy(), value);
    } // end factory method makeSummonerWeapon
} // end OneHandedWeapon
