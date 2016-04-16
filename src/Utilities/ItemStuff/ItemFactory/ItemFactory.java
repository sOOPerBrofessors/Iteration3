package Utilities.ItemStuff.ItemFactory;

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

        // create new health potion
        Potion healthPotion = ItemFactory.makeBasicHealthPotion();
        ItemView healthView = new UsableView(ImageAssets.healthPotion);
        Location healthLocation = new Location(4,4,map.getTopTilePosition(4,4));
        healthView.setLocation(4,4);
        takableItems.put(healthLocation, healthPotion);
        itemViews.put(healthPotion, healthView);

        // create sword
        Weapon sword = ItemFactory.makeWoodenSword();
        ItemView swordView = new UsableView(ImageAssets.sword);
        Location swordLocation = new Location(4,3,map.getTopTilePosition(4,3));
        swordView.setLocation(4,3);
        takableItems.put(swordLocation, sword);
        itemViews.put(sword, swordView);

        // create chest armor
        Armor chestArmor = ItemFactory.makeLightChainmail();
        ItemView chestArmorView = new UsableView(ImageAssets.chestPlate);
        Location chestArmorLocation = new Location(3,3,map.getTopTilePosition(3,3));
        chestArmorView.setLocation(3,3);
        takableItems.put(chestArmorLocation, chestArmor);
        itemViews.put(chestArmor, chestArmorView);

        // create closed chest
        Interactable closedChest = new Chest();
        ItemView closedChestView = new InteractableView(ImageAssets.closedChest);
        Location closedChestLocation = new Location(3,4, map.getTopTilePosition(3,4));
        closedChestView.setLocation(3,4);
        interactableItems.put(closedChestLocation, closedChest);
        itemViews.put(closedChest,closedChestView);
    }

    public static Potion makeBasicHealthPotion() {
        return Potion.makeHealthPotion("Basic Health potion",
                "A basic health potion (+3)",
                3);
    } // end factory method makeHealthPotion

    public static Potion makeGoodHealthPotion() {
        return Potion.makeHealthPotion("Good Health potion",
                "A good health potion (+6)",
                6);
    } // end factory method makeHealthPotion

    public static Potion makeSuperHealthPotion() {
        return Potion.makeHealthPotion("Super Health potion",
                "A super health potion (+10)",
                10);
    } // end factory method makeHealthPotion

    public static Weapon makeWoodenSword() {
        return Weapon.makeSmasherWeapon("Wooden Sword",
                "A wooden sword for warriors (+2)",
                2);
    } // end factory method makeSmasherWeapon

    public static Weapon makeSteelSword() {
        return Weapon.makeSmasherWeapon("Steel Sword",
                "A steel sword for warriors (+5)",
                5);
    } // end factory method makeSmasherWeapon

    public static Weapon makeDiamondSword() {
        return Weapon.makeSmasherWeapon("Diamond Sword",
                "A Diamond sword for warriors (+9)",
                9);
    } // end factory method makeSmasherWeapon

    public static Armor makeLightChainmail () {
        return Armor.makeSmasherArmor("Light Chainmail",
                "Some basic chainmail armor for warriors",
                2);
    } // end factory method makeSmasherWeapon

    public static Armor makeSteelArmor () {
        return Armor.makeSmasherArmor("Steel Armor",
                "Some steel platemail for warriors",
                2);
    } // end factory method makeSmasherWeapon

    public static Armor makeDiamondArmor () {
        return Armor.makeSmasherArmor("Light Chainmail",
                "Some diamond platemail for warriors",
                2);
    } // end factory method makeSmasherWeapon

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