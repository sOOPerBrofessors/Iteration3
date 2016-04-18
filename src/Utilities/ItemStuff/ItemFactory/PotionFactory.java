package Utilities.ItemStuff.ItemFactory;

import Model.Items.Takeable.Useable.Potion;

/**
 * Created by broskj on 4/16/16.
 *
 * A potion factory.  Given a string for the grade of potion and and integer modification value, a different name and
 *  description will be generated.
 */
class PotionFactory {

    public static Potion makeAgilityPotion(String grade, int amount) {
        return Potion.makeManaPotion(
                grade + " Agility Potion",
                "A " + grade.toLowerCase() + " agility potion (+" + amount + ")",
                amount,
                7 * amount / 2
        );
    } // end factory method makeAgilityPotion

    public static Potion makeHardinessPotion(String grade, int amount) {
        return Potion.makeManaPotion(
                grade + " Hardiness Potion",
                "A " + grade.toLowerCase() + " hardiness potion (+" + amount + ")",
                amount,
                7 * amount / 2
        );
    } // end factory method makeHardinessPotion

    public static Potion makeIntellectPotion(String grade, int amount) {
        return Potion.makeManaPotion(
                grade + " Intellect Potion",
                "A " + grade.toLowerCase() + " intellect potion (+" + amount + ")",
                amount,
                7 * amount / 2
        );
    } // end factory method makeIntellectPotion

    public static Potion makeHealthPotion(String grade, int amount) {
        return Potion.makeHealthPotion(
                grade + " Health Potion",
                "A " + grade.toLowerCase() + " health potion (+" + amount +")",
                amount,
                7 * amount / 2
        );
    } // end factory method makeHealthPotion

    public static Potion makeLifePotion(String grade, int amount) {
        return Potion.makeManaPotion(
                grade + " Life Potion",
                "A " + grade.toLowerCase() + " Life potion (+" + amount + ")",
                amount,
                7 * amount / 2
        );
    } // end factory method makeLifePotion

    public static Potion makeManaPotion(String grade, int amount) {
        return Potion.makeManaPotion(
                grade + " Mana Potion",
                "A " + grade.toLowerCase() + " health potion (+" + amount + ")",
                amount,
                7 * amount / 2
        );
    } // end factory method makeManaPotion

    public static Potion makeMovementPotion(String grade, int amount) {
        return Potion.makeManaPotion(
                grade + " Movement Potion",
                "A " + grade.toLowerCase() + " movement potion (+" + amount + ")",
                amount,
                7 * amount / 2
        );
    } // end factory method makeMovementPotion

    public static Potion makeStrengthPotion(String grade, int amount) {
        return Potion.makeManaPotion(
                grade + " Strength Potion",
                "A " + grade.toLowerCase() + " strength potion (+" + amount + ")",
                amount,
                7 * amount / 2
        );
    } // end factory method makeStrengthPotion
} // end class PotionFactory
