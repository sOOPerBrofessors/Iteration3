package Model.Items.Takeable.Useable;

import Model.Entity.Character.Character;
import Model.Items.ItemStrategy.UseableStrategy;

/**
 * Created by broskj on 4/6/16.
 *
 * Class used for items which on use apply bonuses on the player.
 *
 * Needs an Effect.
 */
public class Potion extends UseableItem {
    public Potion() {
        super(new UseableStrategy());
    } // end constructor

    public void onInteract(Character character) {
        s.onInteract(this, character);
    } // end onInteract
} // end class Potion
