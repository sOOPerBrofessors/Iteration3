package Model.Items.ItemStrategy;

import Model.Inventory.Inventory;

/**
 * Created by broskj on 4/6/16.
 *
 * Strategy belonging to items which can be used (on other items), i.e. keys.  Ideally
 *  these aren't class restrictive like equippables are.  On onInteract, the item is passed
 *  to the tile being faced by the Entity which will trigger an action with that tile;
 *  given that the tile contains a door, the door will open and no longer be an obstacle.
 */
class QuestStrategy {

    public boolean onInteract(Inventory inventory) {
        //entity.interactWithFacingTile(item);
        return false;
    } // end onInteract
} // end class QuestStrategy
