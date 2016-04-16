package Model.Items.Takeable.Equippable;

import Model.Items.ItemStrategy.EquippableStrategy.EquippableStrategy;
import Model.Items.ItemStrategy.EquippableStrategy.SmasherArmorStrategy;
import Model.Items.ItemStrategy.EquippableStrategy.SneakArmorStrategy;
import Model.Items.ItemStrategy.EquippableStrategy.SummonerArmorStrategy;

/**
 * Created by broskj on 4/6/16.
 *
 * Armor class that uses factory methods to create occupation-specific armor.  Will
 *  likely need a decorator.
 */
public class Armor extends EquippableItem {

    private int armorValue;

    private Armor(String name, String description, EquippableStrategy s, int armorValue) {
        super(name, description, s);
        this.armorValue = armorValue;
        /*
        todo: change constructor to take in weapon value
        */
    } // end private constructor

    public static Armor makeSmasherArmor(String name, String description, int armorValue) {
        return new Armor(name, description, new SmasherArmorStrategy(), armorValue);
    } // end factory method makeSmasherArmor

    public static Armor makeSneakArmor(String name, String description, int armorValue) {
        return new Armor(name, description, new SneakArmorStrategy(), armorValue);
    } // end factory method makeSneakArmor

    public static Armor makeSummonerArmor(String name, String description, int armorValue) {
        return new Armor(name, description, new SummonerArmorStrategy(), armorValue);
    } // end factory method makeSummonerArmor

    public int getArmorValue() { return this.armorValue; }
} // end class Armor
