package Model.Entity.Character.NPC;

import Controller.AI_Controller.AI_Controller;
import Controller.AI_Controller.Brain;
import Controller.AI_Controller.Personality.Personality;
import Model.Entity.Character.Character;
import Model.Entity.Character.NPC.NPCStrategy.NPCStrategy;
import Model.Entity.Character.Occupation.Occupation;
import Model.Faction.Faction;
import Model.Inventory.Inventory;
import Model.Inventory.Pack;
import Model.Items.Item;
import Model.Items.Takeable.Equippable.Weapon.Weapon;
import Model.Items.Takeable.TakeableItem;
import Model.Items.Takeable.Useable.Potion;
import Model.Map.Location;
import Utilities.ItemStuff.ItemFactory.ItemFactory;
import Utilities.ItemStuff.ItemManager;
import Utilities.Tickable;
import Utilities.Visitor.CharacterTypeVisitor;
import Utilities.Visitor.CharacterVisitor;
import View.ItemView.ItemView;
import View.ItemView.UsableView;
import View.ViewUtilities.Sprites.ImageAssets;

import java.util.HashMap;

/**
 * Created by Wimberley on 4/9/16.
 */
public class NPC extends Character implements Tickable{

    private Brain brain;
    private Personality personality;
    private NPCStrategy npcStrategy;
    AI_Controller controller;

    public NPC(Occupation o, Location location, Personality personality, Faction faction, Inventory inventory, NPCStrategy npcStrategy) {
        super(o, location, faction, inventory);
        stats.makeNPC();
        this.personality = personality;
        this.npcStrategy = npcStrategy;
        addItems();
    }

    @Override
    public void tick() {
        brain.tick();
    }

    public void setController(AI_Controller controller) {

        this.controller = controller;

    }

    public AI_Controller getController() {

        return controller;

    }

    @Override
    public void update() {
        setDelay(getMovement());
        if (getHealth() <= 0) {
            stats.kill();
            if (getLives() == 0) {

            }
        }
    }

    @Override
    public void dropItems(ItemManager itemManager) {
        super.dropItems(itemManager);
        //GameMessageQueue.push("Your items have been placed on the floor.");
    }

    @Override
    public void remove() {

    }

    public Personality getPersonality(){
        return personality;
    }

    public void setBrain(Brain brain){
        this.brain = brain;
    }

    @Override
    public void acceptCharacterVisitor(CharacterVisitor characterVisitor) {
        characterVisitor.visitInventory(inventory);
        characterVisitor.visitOccupation(o);
        characterVisitor.visitStats(stats);
    }

    @Override
    public void acceptCharacterTypeVisitor(CharacterTypeVisitor characterTypeVisitor) {
        characterTypeVisitor.visitNPC(this);
    }

    @Override
    public void onInteract() {
        npcStrategy.onInteract();
    }

    private void addItems() {
        //addHealthPotion();
        addHealthPotion();
        //addSmaherWeapon();
        addSmaherWeapon();
    }

    private void addItem(TakeableItem item) {
        Pack pack = inventory.getPack();
        pack.add(item);
    }
    private void addSmaherWeapon() {
        HashMap<Item, ItemView> allItemViews = ItemFactory.getAllItemViews();

        //make smasher weapon
        Weapon smasherOHW = ItemFactory.makeDiamondSword();
        ItemView smasherOHWView = new UsableView(ImageAssets.sword);

        allItemViews.put(smasherOHW, smasherOHWView);
        inventory.add(smasherOHW);
    }
    private void addHealthPotion() {
        HashMap<Item, ItemView> allItemViews = ItemFactory.getAllItemViews();

        //make healthPotion
        Potion healthPotion = ItemFactory.makeBasicHealthPotion();
        ItemView healthView = new UsableView(ImageAssets.healthPotion);

        allItemViews.put(healthPotion, healthView);
        inventory.add(healthPotion);
    }
}
