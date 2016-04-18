package Controller.AI_Controller.Interest.ItemInterests;

import Controller.AI_Controller.Interest.Interest;
import Controller.AI_Controller.MotorCortex.MotorCortexMemoryInterface;
import Model.Entity.Entity;
import Model.Items.Item;

/**
 * Created by aseber on 4/9/16.
 */
public abstract class ItemInterest extends Interest {

    Item targetItem;

    public void setTarget(Item targetItem) {

        this.targetItem = targetItem;

    }

    public void onEntityTouch(MotorCortexMemoryInterface memory) {



    }

}
