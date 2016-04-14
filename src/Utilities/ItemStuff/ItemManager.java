package Utilities.ItemStuff;

import Model.Items.Item;
import Model.Map.Location;
import View.ItemView.ItemView;

import java.awt.*;
import java.util.HashMap;

/**
 * Created by Wimberley on 4/14/16.
 */
public class ItemManager{

    private static HashMap<Location, Item> items;
    private static HashMap<Item, ItemView> itemViews;

    public static void setItems(HashMap<Location, Item> items) {
        items = items;
    }

    public static HashMap<Location, Item> getItems(){
        return items;
    }

    public static void renderItems(Graphics g, Location offset){
        for(ItemView view: itemViews.values()){
            view.paintComponent(g, offset);
        }
    }

    public static void setItemViews(HashMap<Item, ItemView> itemViews) {
        ItemManager.itemViews = itemViews;
    }
}