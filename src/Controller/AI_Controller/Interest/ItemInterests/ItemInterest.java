package Controller.AI_Controller.Interest.ItemInterests;

import Controller.AI_Controller.Interest.Interest;
import Model.Items.Item;

/**
 * Created by aseber on 4/9/16.
 */
public abstract class ItemInterest extends Interest {

    Item targetItem;

    public void setTarget(Item targetItem) {

        this.targetItem = targetItem;

    }

}
