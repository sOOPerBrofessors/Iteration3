package Model.Items.Interactable;

import Model.Items.Item;
import Model.Items.ItemStrategy.InteractableStrategy.InteractableStrategy;
import Utilities.Visitor.ItemVisitor;

/**
 * Created by broskj on 4/7/16.
 */
public abstract class Interactable extends Item {

    final InteractableStrategy s;

    boolean success;

    Interactable(InteractableStrategy s, String name) {
        super(name);
        this.s = s;
    } // end protected constructor

    @Override
    public void acceptItemVisitor(ItemVisitor itemVisitor) {
        itemVisitor.visitInteractive(this);
    }
    public boolean isSuccess() {
        return success;
    }
} // end abstract class Interactable
