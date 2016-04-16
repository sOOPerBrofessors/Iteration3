package Utilities.ItemStuff.ItemFactory;

import Model.Items.Takeable.Equippable.Weapon.OneHandedWeapon;
import Model.Items.Takeable.Equippable.Weapon.TwoHandedWeapon;
import Model.Items.Takeable.Equippable.Weapon.Weapon;

/**
 * Created by broskj on 4/16/16.
 *
 * A weapon factory.  Given a string for the grade of the weapon and and integer modification value, a different name and
 *  description will be generated.
 */
public class WeaponFactory {
    public static OneHandedWeapon makeOneHandedSmasherWeapon(String grade, int value) {
        return OneHandedWeapon.makeSmasherWeapon(
                grade + " Sword",
                "A " + grade.toLowerCase() + " sword for warriors (+" + value + ")",
                value
        );
    } // end makeSmasherWeapon

    public static TwoHandedWeapon makeTwoHandedSmasherWeapon(String grade, int value) {
        return TwoHandedWeapon.makeSmasherWeapon(
                grade + " Greatsword",
                "A " + grade.toLowerCase() + " greatsword for warriors (+" + value + ")",
                value
        );
    } // end makeSmasherWeapon

    public static OneHandedWeapon makeSummonerWeapon(String grade, int value) {
        return OneHandedWeapon.makeSummonerWeapon(
                grade + " Staff",
                "A " + grade.toLowerCase() + " staff for spellcasters (+" + value + ")",
                value
        );
    } // end makeSummonerWeapon

    public static OneHandedWeapon makeSneakWeapon(String grade, int value) {
        return OneHandedWeapon.makeSneakWeapon(
                grade + " Bow",
                "A " + grade.toLowerCase() + " bow for sneaking types (+" + value + ")",
                value
        );
    } // end makeSneakWeapon
} // end class WeaponFactory
