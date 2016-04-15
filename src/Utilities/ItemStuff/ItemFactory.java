package Utilities.ItemStuff;

import Model.Items.Item;
import Model.Items.Takeable.Useable.Potion;
import Model.Map.Location;
import Model.Map.Map;
import View.ItemView.ItemView;
import View.ItemView.PotionView;
import View.ViewUtilities.ImageAssets;

import java.util.HashMap;

/**
 * Created by Wimberley on 4/14/16.
 */
public class ItemFactory {

    private static HashMap<Location, Item> items = new HashMap<>();
    private static HashMap<Item, ItemView> itemViews = new HashMap<>();

    public static void init(){
        // create new health potion and add to ItemManager
        Item healthPotion = Potion.makeHealthPotion(10);
        ItemView healthView = new PotionView(ImageAssets.healthPotion);
        Location location = new Location(4,4,Map.getTopTilePosition(5,5));
        healthView.setLocation(4,4);
        items.put(location, healthPotion);
        itemViews.put(healthPotion, healthView);
    }

    public static HashMap<Location, Item> getItems(){
        return items;
    }

    public static HashMap<Item, ItemView> getItemViews() {
        return itemViews;
    }

}