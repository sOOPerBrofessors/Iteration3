package Utilities.ItemStuff;

import Model.Items.Interactable.Chest;
import Model.Items.Interactable.Interactable;
import Model.Items.Item;
import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.Equippable.Weapon;
import Model.Items.Takeable.Quest;
import Model.Items.Takeable.Useable.Money;
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
    private static HashMap<Item, ItemView> allItemViews;
    private static HashMap<Item, ItemView> mapItemViews;

    public static void init(Map map){
        takableItems = new HashMap<>();
        allItemViews = new HashMap<>();
        interactableItems = new HashMap<>();
        mapItemViews = new HashMap<>();

        // create money
        TakeableItem money = Money.makeMoney(50);
        ItemView moneyView = new UsableView(ImageAssets.money);
        Location moneyLocation = new Location(4,5, map.getTopTilePosition(4,5));
        moneyView.setLocation(4,5);
        takableItems.put(moneyLocation, money);
        allItemViews.put(money, moneyView);
        mapItemViews.put(money, moneyView);

        // create money in chest
        TakeableItem treasure = Money.makeMoney(100);
        ItemView treasureView = new UsableView(ImageAssets.money);
        allItemViews.put(treasure, treasureView);

        // create new health potion
        TakeableItem healthPotion = Potion.makeHealthPotion(10);
        ItemView healthView = new UsableView(ImageAssets.healthPotion);
        Location healthLocation = new Location(4,4,map.getTopTilePosition(4,4));
        healthView.setLocation(4,4);
        takableItems.put(healthLocation, healthPotion);
        allItemViews.put(healthPotion, healthView);
        mapItemViews.put(healthPotion, healthView);

        // create sword
        TakeableItem sword = Weapon.makeSmasherWeapon(5);
        ItemView swordView = new UsableView(ImageAssets.sword);
        Location swordLocation = new Location(4,3,map.getTopTilePosition(4,3));
        swordView.setLocation(4,3);
        takableItems.put(swordLocation, sword);
        allItemViews.put(sword, swordView);
        mapItemViews.put(sword, swordView);

        // create chest armor
        TakeableItem chestArmor = Armor.makeSmasherArmor(5);
        ItemView chestArmorView = new UsableView(ImageAssets.chestPlate);
        Location chestArmorLocation = new Location(3,3,map.getTopTilePosition(3,3));
        chestArmorView.setLocation(3,3);
        takableItems.put(chestArmorLocation, chestArmor);
        allItemViews.put(chestArmor, chestArmorView);
        mapItemViews.put(chestArmor, chestArmorView);

        // create key for chest
        TakeableItem chestKey = Quest.makeKey();
        ItemView chestKeyView = new UsableView(ImageAssets.chestKey);
        Location chestKeyLocation = new Location(7,2, map.getTopTilePosition(7,2));
        chestKeyView.setLocation(7,2);
        takableItems.put(chestKeyLocation, chestKey);
        allItemViews.put(chestKey, chestKeyView);
        mapItemViews.put(chestKey, chestKeyView);

        // create closed chest
        Interactable closedChest = new Chest((Quest)chestKey, treasure);
        ItemView closedChestView = new InteractableView(ImageAssets.closedChest);
        Location closedChestLocation = new Location(3,4, map.getTopTilePosition(3,4));
        closedChestView.setLocation(3,4);
        interactableItems.put(closedChestLocation, closedChest);
        mapItemViews.put(closedChest,closedChestView);
    }

    public static HashMap<Location, TakeableItem> getTakableItems(){
        return takableItems;
    }

    public static HashMap<Item, ItemView> getAllItemViews() {
        return allItemViews;
    }

    public static HashMap<Location, Interactable> getInteractableItems() {
        return interactableItems;
    }

    public static HashMap<Item, ItemView> getMapItemViews() {
        return mapItemViews;
    }
}