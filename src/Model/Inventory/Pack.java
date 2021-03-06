package Model.Inventory;

import Model.Entity.Character.Character;
import Model.Items.Item;
import Model.Items.Takeable.TakeableItem;
import Model.Items.Takeable.Useable.Money;
import Utilities.ItemStuff.ItemManager;

import java.util.ArrayList;

/**
 * Created by broskj on 4/8/16.
 */
public class Pack {
    private final ArrayList<TakeableItem> items;
    private int money;
    private final int cap = 16;

    public Pack() {
        items = new ArrayList<>();
        money = 0;
    } // end default constructor

    public void utilizeItem(int index, Character character){
        if(items.get(index).utilize(character)) {
            items.remove(index);
        }
    } // end utilizeItem

    public boolean add(TakeableItem item) {
        if(item == null || size() >= cap)
            return false;
        items.add(item);
        return true;
    } // end add

    public void dump(ItemManager itemManager, Character character) {
        for(TakeableItem t : items)
            itemManager.addItem(t, character);
    } // end dump

    public void addMoney(Money money) {
        this.money += money.getQuantity();
    } // end addMoney

    public void spendMoney(int amount) {
        this.money -= amount;
    } // end spendMoney

    public int indexOf(Item item) {
        return items.indexOf(item);
    } // end indexOf

    public TakeableItem remove(int index) {
        TakeableItem temp = items.remove(index);
        return temp;
    } // end remove

    public boolean remove(TakeableItem item) {
        return items.remove(item);
    } // end remove

    public int size() {
        return items.size();
    } // end size

    public boolean hasRoom() { return size() < cap; }

    public ArrayList<TakeableItem> getItems(){return items;}

    public Item getItemAt(int index){
        return items.get(index);
    }

} // end class Pack
