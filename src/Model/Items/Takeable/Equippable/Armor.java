package Model.Items.Takeable.Equippable;

import Model.Entity.Character.Character;
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

    private Armor(EquippableStrategy s) {
        super(s);
        this.armorValue = 0;
        /*
        todo: change constructor to take in weapon value
        */
    } // end private constructor

    public Armor makeSmasherArmor() {
        return new Armor(new SmasherArmorStrategy());
    } // end factory method makeSmasherArmor

    public Armor makeSneakArmor() {
        return new Armor(new SneakArmorStrategy());
    } // end factory method makeSneakArmor

    public Armor makeSummonerArmor() {
        return new Armor(new SummonerArmorStrategy());
    } // end factory method makeSummonerArmor

    public void onInteract(Character character) {
        s.onInteract(this, character);
    } // end onInteract

    public int getArmorValue() { return this.armorValue; }
} // end class Armor
