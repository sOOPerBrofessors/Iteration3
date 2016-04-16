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

    private HashMap<Location, TakeableItem> takableItems;
    private HashMap<Item, ItemView> mapItemViews;
    private HashMap<Item, ItemView> allItemViews;
    private HashMap<Location, Interactable> interactableItems;
    private Observer observer;

    public ItemManager(HashMap<Location, TakeableItem> takableItems, HashMap<Location, Interactable> interactableItems, HashMap<Item, ItemView> allItemViews, HashMap<Item, ItemView> mapItemViews){
        this.takableItems = takableItems;
        this.mapItemViews = mapItemViews;
        this.allItemViews = allItemViews;
        this.interactableItems = interactableItems;
    }

    public HashMap<Location, TakeableItem> getMapTakableItems(){
        return takableItems;
    }

    public void contact(Character character){
        Location temp = null;
        for(Location key : takableItems.keySet()) {
            if (key.equals(character.getLocation())) {
                takableItems.get(key).onInteract(character);
                mapItemViews.remove(takableItems.get(key));
                temp = key;
                alert();
            }
        }
        if(temp != null){
            takableItems.remove(temp);
        }
    }

    public void interact(Character character){
        Location adjacent = character.getLocation().getAdjacent(character.getOrientation());
        for(Location key : interactableItems.keySet()){
            if(key.equals(adjacent)){
                interactableItems.get(key).onInteract(character);
            }
        }
    }

    public ItemView[] getMapItemViews(){
        ItemView [] views;
        views = mapItemViews.values().toArray(new ItemView[mapItemViews.size()]);
        return views;
    }

    public HashMap<Item, ItemView> getAllItemViews(){
        return allItemViews;
    }

    public void removeItem(Item item){
        allItemViews.remove(item);
    }

    public void addItem(Item item, Location location){
        //takableItems
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