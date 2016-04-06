package Model.Items.ItemStrategy;

import Model.Entity;
import Model.Items.Item;

/**
 * Created by broskj on 4/6/16.
 *
 * Strategy belonging to items which can be used (on other items), i.e. keys.  Ideally
 *  these aren't class restrictive like equippables are.  On onInteract, the item is passed
 *  to the tile being faced by the Entity which will trigger an action with that tile;
 *  given that the tile contains a door or a chest, its
 */
public class QuestStrategy implements ItemStrategy {
    @Override
    public void onInteract(Item item, Entity entity) {
        //entity.interactWithFacingTile(item);
    } // end onInteract
} // end class QuestStrategy
