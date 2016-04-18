package Utilities.ItemStuff.ItemFactory;

import Model.Items.Interactable.Chest;
import Model.Items.Interactable.Interactable;
import Model.Items.Item;
import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.Equippable.Weapon.Weapon;
import Model.Items.Takeable.Quest;
import Model.Items.Takeable.TakeableItem;
import Model.Items.Takeable.Useable.Money;
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
    public static void initHashMaps(){
        takableItems = new HashMap<>();
        allItemViews = new HashMap<>();
        interactableItems = new HashMap<>();
        mapItemViews = new HashMap<>();
    }
    public static void init(Map map){

        //initHashMaps(); MIGHT cause problems later
        // create new health potion
        Potion healthPotion = ItemFactory.makeBasicHealthPotion();
        ItemView healthView = new UsableView(ImageAssets.healthPotion);
        Location healthLocation = new Location(4,4,map.getTopTilePosition(4,4));
        healthView.setLocation(4,4);
        takableItems.put(healthLocation, healthPotion);
        allItemViews.put(healthPotion, healthView);
        mapItemViews.put(healthPotion, healthView);

        // create sword
        Weapon sword = ItemFactory.makeWoodenSword();
        ItemView swordView = new UsableView(ImageAssets.sword);
        Location swordLocation = new Location(4,3,map.getTopTilePosition(4,3));
        swordView.setLocation(4,3);
        takableItems.put(swordLocation, sword);
        allItemViews.put(sword, swordView);
        mapItemViews.put(sword, swordView);

        // create chest armor
        Armor chestArmor = ItemFactory.makeLightArmor();
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

        // create money in chest
        Money treasure = Money.makeMoney(100);
        ItemView treasureView = new UsableView(ImageAssets.money);
        allItemViews.put(treasure, treasureView);

        // create closed chest
        Interactable closedChest = new Chest((Quest)chestKey, treasure, "ClosedChest");
        ItemView closedChestView = new InteractableView(ImageAssets.closedChest);
        Location closedChestLocation = new Location(3,4, map.getTopTilePosition(3,4));
        closedChestView.setLocation(3,4);
        interactableItems.put(closedChestLocation, closedChest);
        mapItemViews.put(closedChest,closedChestView);
    }

    /*
    potion factory methods
    three of each type
     */
    public static Potion makeBasicAgilityPotion() {
        return PotionFactory.makeAgilityPotion("Basic", 3);
    } // end factory method makeBasicAgilityPotion

    public static Potion makeGoodAgilityPotion() {
        return PotionFactory.makeAgilityPotion("Good", 6);
    } // end factory method makeGoodAgilityPotion

    public static Potion makeSuperAgilityPotion() {
        return PotionFactory.makeAgilityPotion("Super", 10);
    } // end factory method makeSuperAgilityPotion

    public static Potion makeBasicHardinessPotion() {
        return PotionFactory.makeHardinessPotion("Basic", 3);
    } // end factory method makeBasicHardinessPotion

    public static Potion makeGoodHardinessPotion() {
        return PotionFactory.makeHardinessPotion("Good", 6);
    } // end factory method makeGoodHardinessPotion

    public static Potion makeSuperHardinessPotion() {
        return PotionFactory.makeHardinessPotion("Super", 10);
    } // end factory method makeSuperHardinessPotion

    public static Potion makeBasicIntellectPotion() {
        return PotionFactory.makeIntellectPotion("Basic", 3);
    } // end factory method makeBasicIntellectPotion

    public static Potion makeGoodIntellectPotion() {
        return PotionFactory.makeIntellectPotion("Good", 6);
    } // end factory method makeGoodIntellectPotion

    public static Potion makeSuperIntellectPotion() {
        return PotionFactory.makeIntellectPotion("Super", 10);
    } // end factory method makeSuperIntellectPotion

    public static Potion makeBasicHealthPotion() {
        return PotionFactory.makeHealthPotion("Basic", 3);
    } // end factory method makeBasicHealthPotion

    public static Potion makeGoodHealthPotion() {
        return PotionFactory.makeHealthPotion("Good", 6);
    } // end factory method makeGoodHealthPotion

    public static Potion makeSuperHealthPotion() {
        return PotionFactory.makeHealthPotion("Super", 10);
    } // end factory method maakeSuperHealthPotion

    public static Potion makeBasicLifePotion() {
        return PotionFactory.makeLifePotion("Basic", 1);
    } // end factory method makeBasicLifePotion

    public static Potion makeGoodLifePotion() {
        return PotionFactory.makeLifePotion("Good", 2);
    } // end factory method makeGoodLifePotion

    public static Potion makeSuperLifePotion() {
        return PotionFactory.makeLifePotion("Super", 3);
    } // end factory method makeSuperLifePotion

    public static Potion makeBasicManaPotion() {
        return PotionFactory.makeManaPotion("Basic", 3);
    } // end factory method makeBasicManaPotion

    public static Potion makeGoodManaPotion() {
        return PotionFactory.makeManaPotion("Good", 6);
    } // end factory method makeGoodManaPotion

    public static Potion makeSuperManaPotion() {
        return PotionFactory.makeManaPotion("Super", 10);
    } // end factory method maakeSuperManaPotion

    public static Potion makeBasicMovementPotion() {
        return PotionFactory.makeMovementPotion("Basic", 3);
    } // end factory method makeBasicMovementPotion

    public static Potion makeGoodMovementPotion() {
        return PotionFactory.makeMovementPotion("Good", 6);
    } // end factory method makeGoodMovementPotion

    public static Potion makeSuperMovementPotion() {
        return PotionFactory.makeMovementPotion("Super", 10);
    } // end factory method maakeSuperMovementPotion

    public static Potion makeBasicStrengthPotion() {
        return PotionFactory.makeStrengthPotion("Basic", 3);
    } // end factory method makeBasicStrengthPotion

    public static Potion makeGoodStrengthPotion() {
        return PotionFactory.makeStrengthPotion("Good", 6);
    } // end factory method makeGoodStrengthPotion

    public static Potion makeSuperStrengthPotion() {
        return PotionFactory.makeStrengthPotion("Super", 10);
    } // end factory method maakeSuperStrengthPotion

    /*
    weapon factory methods
    three of each one handed weapon for all occupations,
      and three two handed weapons for smashers
     */
    public static Weapon makeWoodenSword() {
        return WeaponFactory.makeOneHandedSmasherWeapon("Wooden", 3);
    } // end factory method makeWoodenSword

    public static Weapon makeSteelSword() {
        return WeaponFactory.makeOneHandedSmasherWeapon("Steel", 5);
    } // end factory method makeSteelSword

    public static Weapon makeDiamondSword() {
        return WeaponFactory.makeOneHandedSmasherWeapon("Diamond", 9);
    } // end factory method makeDiamondSword

    public static Weapon makeWoodenGreatword() {
        return WeaponFactory.makeTwoHandedSmasherWeapon("Wooden", 4);
    } // end factory method makeWoodenGreatsword

    public static Weapon makeSteelGreatsword() {
        return WeaponFactory.makeTwoHandedSmasherWeapon("Steel", 8);
    } // end factory method makeSteelGreatsword

    public static Weapon makeDiamondGreatsword() {
        return WeaponFactory.makeTwoHandedSmasherWeapon("Diamond", 16);
    } // end factory method makeDiamondGreatsword

    public static Weapon makeWoodenStaff() {
        return WeaponFactory.makeSummonerWeapon("Wooden", 2);
    } // end factory method makeWoodenStaff

    public static Weapon makeEnchantedStaff() {
        return WeaponFactory.makeOneHandedSmasherWeapon("Enchanted", 4);
    } // end factory method makePotentStaff

    public static Weapon makeSpectralStaff() {
        return WeaponFactory.makeOneHandedSmasherWeapon("Spectral", 7);
    } // end factory method makeSpectralStaff

    public static Weapon makeWoodenBow() {
        return WeaponFactory.makeSneakWeapon("Wooden", 3);
    } // end factory method makeWoodenBow

    public static Weapon makeSightedBow() {
        return WeaponFactory.makeSneakWeapon("Sighted", 5);
    } // end factory method makePotentStaff

    public static Weapon makeCompoundBow() {
        return WeaponFactory.makeSneakWeapon("Spectral", 9);
    } // end factory method makeCompoundBow

    /*
    armor factory methods
    three of each for all occupations
     */
    public static Armor makeLightArmor() {
        return ArmorFactory.makeSmasherArmor("Light", 5);
    } // end factory method makeLightArmor

    public static Armor makeChainmailArmor() {
        return ArmorFactory.makeSmasherArmor("Chainmail", 8);
    } // end factory method makeChainmailArmor

    public static Armor makePlatemailArmor() {
        return ArmorFactory.makeSmasherArmor("Platemail", 14);
    } // end factory method makeCPlatemailArmor

    public static Armor makeTatteredRobes() {
        return ArmorFactory.makeSummonerArmor("Tattered", 3);
    } // end factory method makeTatteredRobes

    public static Armor makeMysticalRobes() {
        return ArmorFactory.makeSummonerArmor("Mystical", 6);
    } // end factory method makeTatteredRobes

    public static Armor makeSpellbindingRobes() {
        return ArmorFactory.makeSummonerArmor("Spellbinding", 10);
    } // end factory method makeTatteredRobes

    public static Armor makeLeatherArmor() {
        return ArmorFactory.makeSneakArmor("Leather", 3);
    } // end factory method makeLeatherArmor

    public static Armor makeStuddedArmor() {
        return ArmorFactory.makeSneakArmor("Studded", 3);
    } // end factory method makeStuddedArmor

    public static Armor makeShroudedArmor() {
        return ArmorFactory.makeSneakArmor("Shrouded", 3);
    } // end factory method makeShroudedArmor

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