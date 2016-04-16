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

    private Armor(EquippableStrategy s, int armorValue) {
        super(s);
        this.armorValue = armorValue;
        /*
        todo: change constructor to take in weapon value
        */
    } // end private constructor

    public static Armor makeSmasherArmor(int armorValue) {
        return new Armor(new SmasherArmorStrategy(), armorValue);
    } // end factory method makeSmasherArmor

    public static Armor makeSneakArmor(int armorValue) {
        return new Armor(new SneakArmorStrategy(), armorValue);
    } // end factory method makeSneakArmor

    public static Armor makeSummonerArmor(int armorValue) {
        return new Armor(new SummonerArmorStrategy(), armorValue);
    } // end factory method makeSummonerArmor

    public int getArmorValue() { return this.armorValue; }
} // end class Armor
