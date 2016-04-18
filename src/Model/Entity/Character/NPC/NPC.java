package Model.Entity.Character.NPC;

import Controller.AI_Controller.AI_Controller;
import Controller.AI_Controller.Brain;
import Controller.AI_Controller.Personality.Personality;
import Model.Effect.Effect;
import Model.Entity.Character.Character;
import Model.Entity.Character.NPC.NPCStrategy.NPCStrategy;
import Model.Entity.Character.Occupation.Occupation;
import Model.Faction.Faction;
import Model.Inventory.Inventory;
import Model.Inventory.Pack;
import Model.Items.Interactable.Interactable;
import Model.Items.Item;
import Model.Items.ItemStrategy.EquippableStrategy.EquippableStrategy;
import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.Equippable.EquippableItem;
import Model.Items.Takeable.Equippable.Weapon.OneHandedWeapon;
import Model.Items.Takeable.Equippable.Weapon.Weapon;
import Model.Items.Takeable.TakeableItem;
import Model.Items.Takeable.Useable.Money;
import Model.Items.Takeable.Useable.Potion;
import Model.Map.Location;
import Utilities.ItemStuff.ItemFactory.ItemFactory;
import Utilities.Tickable;
import Utilities.Visitor.CharacterTypeVisitor;
import Utilities.Visitor.CharacterVisitor;
import View.ItemView.ItemView;
import View.ItemView.UsableView;
import View.ViewUtilities.Sprites.ImageAssets;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Wimberley on 4/9/16.
 */
public class NPC extends Character implements Tickable{

    private Brain brain;
    private Faction faction;
    private Personality personality;
    private NPCStrategy npcStrategy;
    AI_Controller controller;

    public NPC(Occupation o, Location location, Personality personality, Faction faction, NPCStrategy npcStrategy) {
        super(o, location);
        this.faction = faction;
        this.personality = personality;
        this.npcStrategy = npcStrategy;
        addItems();
    }

    @Override
    public void tick(){
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
        characterVisitor.visitSkills(skills);
        characterVisitor.visitStats(stats);
    }

    @Override
    public void acceptCharacterTypeVisitor(CharacterTypeVisitor characterTypeVisitor) {
        characterTypeVisitor.visitNPC(this);
    }

    @Override
    public void onInteract() {
        System.out.println("NPC: I am being interacted on");
        npcStrategy.onInteract();
    }

    private void addItems() {
        addHealthPotion();
        addHealthPotion();
        addSmaherWeapon();
        addSmaherWeapon();
    }

    private void addItem(TakeableItem item) {
        Pack pack = this.inventory.getPack();
        pack.add(item);
    }
    private void addSmaherWeapon() {
        Pack pack = this.inventory.getPack();
        HashMap<Item, ItemView> allItemViews = ItemFactory.getAllItemViews();

        //make smasher weapon
        Weapon smasherOHW = ItemFactory.makeDiamondSword();
        ItemView smasherOHWView = new UsableView(ImageAssets.sword);

        allItemViews.put(smasherOHW, smasherOHWView);
        pack.add(smasherOHW);
    }
    private void addHealthPotion() {
        Pack pack = this.inventory.getPack();
        HashMap<Item, ItemView> allItemViews = ItemFactory.getAllItemViews();

        //make healthPotion
        Potion healthPotion = ItemFactory.makeBasicHealthPotion();
        ItemView healthView = new UsableView(ImageAssets.healthPotion);

        allItemViews.put(healthPotion, healthView);
        pack.add(healthPotion);
    }
}
