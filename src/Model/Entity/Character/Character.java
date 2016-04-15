package Model.Entity.Character;

import Model.Entity.Character.Mount.Mount;
import Model.Entity.Character.Occupation.Occupation;
import Model.Entity.Entity;
import Model.Inventory.Inventory;
import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.Equippable.Weapon;
import Model.Map.Location;
import Model.Map.Orientation;
import Model.Stats.CharacterStats;
import Utilities.Navigation.Navigation;
import Utilities.Observers.Observer;

/**
 * Created by broskj on 4/6/16.
 *
 * Abstract class to act as the superclass to the player (Avatar) and NPCs.
 */
public abstract class Character extends Entity implements Observer {
    private Occupation o;
    protected CharacterStats stats;
    protected Inventory inventory;
    private int radiusVisibility;
    protected Character(Occupation o, Location location) {
        super(Navigation.makeCharNav(), location);
        this.o = o;
        this.stats = o.initStats();
        this.inventory = new Inventory();
        stats.addObserver(this);
        inventory.addObserver(this);
        this.radiusVisibility = 3; //might need to change to some sort of default later
    } // end private constructor

    /*
    handle passing effects to stats
     */
    public void agilityEffect(int amount) {
        stats.agilityEffect(amount);
    } // end agilityEffect

    public void hardinessEffect(int amount) {
        stats.hardinessEffect(amount);
    } // end hardinessEffect

    public void intellectEffect(int amount) {
        stats.intellectEffect(amount);
    } // end intellectEffect

    public void healthEffect(int amount) {
        stats.healthEffect(amount);
    } // end lifeEffect

    public void livesEffect(int amount) {
        stats.livesEffect(amount);
    } // end livesEffect

    public void manaEffect(int amount) {
        stats.manaEffect(amount);
    } // end manaEffect

    public void movementEffect(int amount) {
        stats.movementEffect(amount);
    } // end movementEffect

    public void strengthEffect(int amount) {
        stats.strengthEffect(amount);
    } // end strengthEffect

    /*
    handle equipping items
     */
    public void equipWeapon(Weapon weapon) {
        inventory.equipWeapon(weapon);
    } // end equipArmor

    public void equipArmor(Armor armor) {
        inventory.equipArmor(armor);
    } // end equipArmor

    public void equipSmasherWeapon(Weapon weapon) {
        o.equipSmasherWeapon(weapon, this);
    } // end equipSmasherWeapon
    public void equipSmasherArmor(Armor armor) {
        o.equipSmasherArmor(armor, this);
    } // end equipSmasherArmor
    public void equipSneakWeapon(Weapon weapon) {
        o.equipSneakWeapon(weapon, this);
    } // end equipSneakWeapon
    public void equipSneakArmor(Armor armor) {
        o.equipSneakArmor(armor, this);
    } // end equipSneakArmor
    public void equipSummonerWeapon(Weapon weapon) {
        o.equipSummonerWeapon(weapon, this);
    } // end equipSummonerWeapon
    public void equipSummonerArmor(Armor armor) {
        o.equipSummonerArmor(armor, this);
    } // end equipSummonerArmor

    public void rideMount(Mount mount){
        mount.addCharacter(this);
    }
    public Occupation getOccupation(){
        return o;
    }
    public int getRadiusVisibility(){
        return radiusVisibility;
    }
} // end abstract class Character
