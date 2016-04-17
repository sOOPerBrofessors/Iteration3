package Model.Items.Takeable.Useable;

import Model.Entity.Character.Character;
import Model.Items.Takeable.TakeableItem;

/**
 * Created by Wimberley on 4/16/16.
 */
public class Money extends TakeableItem {

    private int quantity;

    private Money() {
        super("Money", "Lovely money!", 1);
        this.quantity = 0;
    } // end default constructor

    private Money(int quantity) {
        super("Money", "Lovely money!", 1);
        this.quantity = quantity;
    }

    public static Money makeMoney(int quantity){
        return new Money(quantity);
    }

    @Override
    protected void utilize(Character character) {
        // use while in trade state
    }

    @Override
    public void onInteract(Character character) {
        character.pickUpMoney(this);
    } // end onInteract

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}