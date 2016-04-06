package Model.Items.ItemStrategy;

import Model.Entity.Character.Character;
import Model.Items.Item;

/**
 * Created by broskj on 4/6/16.
 *
 * Strategy to belong to items which can be consumed, i.e. potions.  Ideally these
 *  aren't class-restrictive like equippables are.  On onInteract, the item's effect
 *  is applied to the entity using the item.
 *
 * Should be called with:
 *  class SomeItem {
 *      ItemStrategy s = new UseableStrategy();
 *      // ...
 *      public void onInteract(Entity entity) {
 *          s.onInteract(this, entity);
 *      }
 *  }
 */
public class UseableStrategy implements ItemStrategy {

    @Override
    public void onInteract(Item item, Character character) {
        //entity.consume(item);
    } // end onInteract()
}// end class UsableStrategy
