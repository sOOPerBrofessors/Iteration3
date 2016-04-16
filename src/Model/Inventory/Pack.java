package Model.Inventory;

import Model.Items.Item;
import Utilities.GameMessageQueue;

import java.util.ArrayList;

/**
 * Created by broskj on 4/8/16.
 */
public class Pack {
    ArrayList<Item> items;
    final int cap = 16;

    public Pack() {
        items = new ArrayList<>();
    } // end default constructor

    public void add(Item item) {
        if(item != null && size() < cap) {
            items.add(item);
            GameMessageQueue.push("Picked up an item.");
        } else if (size() >= cap) {
            GameMessageQueue.push("Inventory full, can't take item.");
        }
    } // end add

    public int indexOf(Item item) {
        return items.indexOf(item);
    } // end indexOf

    public Item remove(int index) {
        return items.remove(index);
    } // end remove

    public boolean remove(Item item) {
        return items.remove(item);
    } // end remove

    public int size() {
        return items.size();
    } // end size
    public boolean hasRoom() { return size() < cap; }

    public ArrayList<Item> getItems(){return items;}

} // end class Pack
