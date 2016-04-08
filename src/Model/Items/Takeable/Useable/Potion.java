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
    Effect e;
    int amount;

    private Potion(Effect e, int amount) {
        super();
        this.e = e;
        this.amount = amount;
    } // end constructor

    public static Potion makeAgilityPotion(int amount) {
        return new Potion(Character::agilityEffect, amount);
    } // end factory method makeAgilityPotion

    public static Potion makeHardinessPotion(int amount) {
        return new Potion(Character::hardinessEffect, amount);
    } // end factory method makeHardinessPotion

    public static Potion makeIntellectPotion(int amount) {
        return new Potion(Character::intellectEffect, amount);
    } // end factory method makeIntellectPotion

    public static Potion makeHealthPotion(int amount) {
        return new Potion(Character::healthEffect, amount);
    } // end factory method makeHealthPotion

    public static Potion makeLifePotion(int amount) {
        return new Potion(Character::livesEffect, amount);
    } // end factory method makeLifePotion

    public static Potion makeManaPotion(int amount) {
        return new Potion(Character::manaEffect, amount);
    } // end factory method makeManaPotion

    public static Potion makeMovementPotion(int amount) {
        return new Potion(Character::movementEffect, amount);
    } // end factory method makeMovementPotion

    public static Potion makeStrengthPotion(int amount) {
        return new Potion(Character::strengthEffect, amount);
    } // end factory method makeStrengthPotion

    public void onInteract(Character character) {
        e.execute(character, amount);
    } // end onInteract
} // end class Potion
