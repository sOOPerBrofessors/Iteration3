package Model.Items.Interactable;

import Model.Items.Item;
import Model.Items.ItemStrategy.InteractableStrategy.InteractableStrategy;

/**
 * Created by broskj on 4/7/16.
 */
public abstract class Interactable extends Item {
    InteractableStrategy s;

    protected Interactable(InteractableStrategy s) {
        super();
        this.s = s;
    } // end protected constructor
} // end abstract class Interactable
