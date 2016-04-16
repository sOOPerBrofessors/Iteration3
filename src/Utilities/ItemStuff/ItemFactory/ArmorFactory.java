package Utilities.ItemStuff.ItemFactory;

import Model.Items.Takeable.Equippable.Armor;

/**
 * Created by broskj on 4/16/16.
 *
 * An armor factory.  Given a string for the grade of armor and and integer modification value, a different name and
 *  description will be generated.
 */
public class ArmorFactory {
    public static Armor makeSmasherArmor(String grade, int value) {
        return Armor.makeSmasherArmor(
                grade + " Armor",
                "A " + grade.toLowerCase() + " armor set for warriors.",
                value
        );
    } // end factory method makeSmasherArmor

    public static Armor makeSummonerArmor(String grade, int value) {
        return Armor.makeSummonerArmor(
                grade + " Robes",
                "Some " + grade.toLowerCase() + " robes for spellcasters.",
                value
        );
    } // end factory method makeSummonerArmor

    public static Armor makeSneakArmor(String grade, int value) {
        return Armor.makeSneakArmor(
                grade + " Leather Gear",
                "Some " + grade.toLowerCase() + " leather gear for sneaky types.",
                value
        );
    } // end factory method makeSummonerArmor

} // end class ArmorFactory
