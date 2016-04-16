package Utilities.ItemStuff;

import Model.Entity.Character.Character;
import Model.Items.Interactable.Interactable;
import Model.Items.Item;
import Model.Items.Takeable.TakeableItem;
import Model.Map.Location;
import Utilities.Observers.Observer;
import Utilities.Observers.Subject;
import View.ItemView.ItemView;

import java.util.HashMap;

/**
 * Created by Wimberley on 4/14/16.
 */
public class ItemManager implements Subject{

    private HashMap<Location, Item> takableItems;
    private HashMap<Item, ItemView> itemViews;
    private HashMap<Location, Interactable> interactableItems;
    private Observer observer;

    public ItemManager(HashMap<Location, Item> takableItems, HashMap<Location, Interactable> interactableItems, HashMap<Item, ItemView> itemViews){
        this.takableItems = takableItems;
        this.itemViews = itemViews;
        this.interactableItems = interactableItems;
    }

    public HashMap<Location, Item> getTakableItems(){
        return takableItems;
    }

    public void contact(Character character){
        for(Location key : takableItems.keySet()) {
            if (key.equals(character.getLocation())) {
                character.pickUpItem(takableItems.get(key));
                itemViews.remove(takableItems.get(key));
                alert();
            }
        }
    }

    public void interact(Character character){
        Location adjacent = character.getLocation().getAdjacent(character.getOrientation());
        for(Location key : takableItems.keySet()){
            if(key.equals(adjacent)){
                takableItems.get(key).onInteract(character);
            }
        }
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