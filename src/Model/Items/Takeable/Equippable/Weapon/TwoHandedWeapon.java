package Model.Items.Takeable.Equippable.Weapon;

import Model.Items.ItemStrategy.EquippableStrategy.EquippableStrategy;
import Model.Items.ItemStrategy.EquippableStrategy.SmasherWeaponStrategy;

/**
 * Created by broskj on 4/16/16.
 */
public class TwoHandedWeapon extends Weapon {

    private TwoHandedWeapon(String name, String description, EquippableStrategy s, int weaponValue, int value) {
        super(name, description, s, weaponValue, value);
    } // end private constructor

    public static TwoHandedWeapon makeSmasherWeapon(String name, String description, int weaponValue, int value) {
        return new TwoHandedWeapon(name, description, new SmasherWeaponStrategy(), weaponValue, value);
    } // end factory method makeSmasherWeapon
} // end class TwoHandedWeapon
