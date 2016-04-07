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

    public Potion makeHealthPotion(int amount) {
        return new Potion(Character::modifyHealth,
        amount);
    }

    public void onInteract(Character character) {
        e.execute(character, amount);
    } // end onInteract
} // end class Potion
