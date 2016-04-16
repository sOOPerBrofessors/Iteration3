package Utilities.ItemStuff;

import Model.Items.Interactable.Chest;
import Model.Items.Interactable.Interactable;
import Model.Items.Item;
import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.Equippable.Weapon;
import Model.Items.Takeable.TakeableItem;
import Model.Items.Takeable.Useable.Potion;
import Model.Map.Location;
import Model.Map.Map;
import View.ItemView.InteractableView;
import View.ItemView.ItemView;
import View.ItemView.UsableView;
import View.ViewUtilities.Sprites.ImageAssets;

import java.util.HashMap;

/**
 * Created by Wimberley on 4/14/16.
 */
public class ItemFactory {

    private static HashMap<Location, TakeableItem> takableItems;
    private static HashMap<Location, Interactable> interactableItems;
    private static HashMap<Item, ItemView> itemViews;

    public static void init(Map map){
        takableItems = new HashMap<>();
        itemViews = new HashMap<>();
        interactableItems = new HashMap<>();

        // create new health potion and add to ItemManager
        TakeableItem healthPotion = Potion.makeHealthPotion(10);
        ItemView healthView = new UsableView(ImageAssets.healthPotion);
        Location healthLocation = new Location(4,4,map.getTopTilePosition(4,4) - 1);
        healthView.setLocation(4,4);
        takableItems.put(healthLocation, healthPotion);
        itemViews.put(healthPotion, healthView);

        // create sword
        TakeableItem sword = Weapon.makeSmasherWeapon(5);
        ItemView swordView = new UsableView(ImageAssets.sword);
        Location swordLocation = new Location(4,3,map.getTopTilePosition(4,3) - 1);
        swordView.setLocation(4,3);
        takableItems.put(swordLocation, sword);
        itemViews.put(sword, swordView);

        // create chest armor
        TakeableItem chestArmor = Armor.makeSmasherArmor(5);
        ItemView chestArmorView = new UsableView(ImageAssets.chestPlate);
        Location chestArmorLocation = new Location(3,3,map.getTopTilePosition(3,3) - 1);
        chestArmorView.setLocation(3,3);
        takableItems.put(chestArmorLocation, chestArmor);
        itemViews.put(chestArmor, chestArmorView);

        // create closed chest
        Interactable closedChest = new Chest();
        ItemView closedChestView = new InteractableView(ImageAssets.closedChest);
        Location closedChestLocation = new Location(3,4, map.getTopTilePosition(3,4) - 1);
        closedChestView.setLocation(3,4);
        interactableItems.put(closedChestLocation, closedChest);
        itemViews.put(closedChest,closedChestView);
    }

    public static HashMap<Location, TakeableItem> getTakableItems(){
        return takableItems;
    }

    public static HashMap<Item, ItemView> getItemViews() {
        return itemViews;
    }

    public static HashMap<Location, Interactable> getInteractableItems() {
        return interactableItems;
    }
}