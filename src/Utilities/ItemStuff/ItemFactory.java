package Utilities.ItemStuff;

import Model.Items.Item;
import Model.Items.Takeable.Equippable.Weapon;
import Model.Items.Takeable.Useable.Potion;
import Model.Map.Location;
import Model.Map.Map;
import View.ItemView.ItemView;
import View.ItemView.UsableView;
import View.ViewUtilities.Sprites.ImageAssets;

import java.util.HashMap;

/**
 * Created by Wimberley on 4/14/16.
 */
public class ItemFactory {

    private static HashMap<Location, Item> items;
    private static HashMap<Item, ItemView> itemViews;

    public static void init(Map map){
        items = new HashMap<>();
        itemViews = new HashMap<>();

        // create new health potion and add to ItemManager
        Item healthPotion = Potion.makeHealthPotion(10);
        ItemView healthView = new UsableView(ImageAssets.healthPotion);
        Location healthLocation = new Location(4,4,map.getTopTilePosition(4,4));
        healthView.setLocation(4,4);
        items.put(healthLocation, healthPotion);
        itemViews.put(healthPotion, healthView);

        // create sword
        Item sword = Weapon.makeSmasherWeapon(5);
        ItemView swordView = new UsableView(ImageAssets.sword);
        Location swordLocation = new Location(4,3,map.getTopTilePosition(4,3));
        swordView.setLocation(4,3);
        items.put(swordLocation, sword);
        itemViews.put(sword, swordView);
    }

    public static HashMap<Location, Item> getItems(){
        return items;
    }

    public static HashMap<Item, ItemView> getItemViews() {
        return itemViews;
    }
}