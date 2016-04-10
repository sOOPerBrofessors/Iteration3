package Controller.AI_Controller.Decision;

import Controller.AI_Controller.Interest.ItemInterest;
import Model.Items.Item;

/**
 * Created by aseber on 4/9/16.
 */
public class ItemDecision extends Decision {

    public ItemDecision(ItemInterest interest, Item target) {

        interest.setTarget(target);
        super.setInterest(interest);

    }

}
