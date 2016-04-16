package Utilities.ItemStuff;

import Model.Entity.Character.Character;
import Model.Items.Item;
import Model.Map.Location;
import Utilities.Observers.Observer;
import Utilities.Observers.Subject;
import View.ItemView.ItemView;

import java.util.HashMap;

/**
 * Created by Wimberley on 4/14/16.
 */
public class ItemManager implements Subject{

    private HashMap<Location, Item> items;
    private HashMap<Item, ItemView> itemViews;
    private Observer observer;

    public ItemManager(HashMap<Location, Item> items, HashMap<Item, ItemView> itemViews){
        this.items = items;
        this.itemViews = itemViews;
    }

    public HashMap<Location, Item> getItems(){
        return items;
    }

    public void contact(Character character){
        for(Location key : items.keySet()) {
            if (key.equals(character.getLocation())) {
                character.pickUpItem(items.get(key));
                itemViews.remove(items.get(key));
                alert();
            }
        }
    }

    public void interact(Character character){
        //interactable items
    }

    public ItemView[] getItemViews(){
        ItemView [] views;
        views = itemViews.values().toArray(new ItemView[itemViews.size()]);
        return views;
    }

    @Override
    public void addObserver(Observer o) {
        observer = o;
    }

    @Override
    public void removeObserver(Observer o) {
        observer = null;
    }

    @Override
    public void alert() {
        observer.update();
    }
}