package Model.Items.ItemStrategy;

import Model.Entity.Character.Character;
import Model.Items.Item;

/**
 * Created by broskj on 4/6/16.
 *
 * ItemStrategy interface to be implemented by different item strategy clases.
 *  onInteract will be implemented differently for those items who are used/consumed
 *  vs equipped vs ... for each type of entity who could use them.
 */
public interface ItemStrategy {
    public void onInteract(Item item, Character character);   // to be called on item interaction from within inventory
} // end interface ItemStrategy
