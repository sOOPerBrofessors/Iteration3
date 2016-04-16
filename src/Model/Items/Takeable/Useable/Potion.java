package Model.Items.Takeable.Useable;

import Model.Effect.Effect;
import Model.Entity.Character.Character;

/**
 * Created by broskj on 4/6/16.
 *
 * Class used for items which on use apply bonuses on the player.
 *
 * Needs an Effect.
 */
public class Potion extends UseableItem {

    private Potion(String name, String description, Effect e, int amount) {
        super(name, description);
        this.e = e;
        this.amount = amount;
        //Used for testing, all potions are the same, assuming a name will be given to potion
    } // end constructor

    public static Potion makeAgilityPotion(String name, String description, int amount) {
        return new Potion(name, description, Character::agilityEffect, amount);
    } // end factory method makeAgilityPotion

    public static Potion makeHardinessPotion(String name, String description, int amount) {
        return new Potion(name, description, Character::hardinessEffect, amount);
    } // end factory method makeHardinessPotion

    public static Potion makeIntellectPotion(String name, String description, int amount) {
        return new Potion(name, description, Character::intellectEffect, amount);
    } // end factory method makeIntellectPotion

    public static Potion makeHealthPotion(String name, String description, int amount) {
        return new Potion(name, description, Character::healthEffect, amount);
    } // end factory method makeHealthPotion

    public static Potion makeLifePotion(String name, String description, int amount) {
        return new Potion(name, description, Character::livesEffect, amount);
    } // end factory method makeLifePotion

    public static Potion makeManaPotion(String name, String description, int amount) {
        return new Potion(name, description, Character::manaEffect, amount);
    } // end factory method makeManaPotion

    public static Potion makeMovementPotion(String name, String description, int amount) {
        return new Potion(name, description, Character::movementEffect, amount);
    } // end factory method makeMovementPotion

    public static Potion makeStrengthPotion(String name, String description, int amount) {
        return new Potion(name, description, Character::strengthEffect, amount);
    } // end factory method makeStrengthPotion


} // end class Potion
