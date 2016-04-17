package Model.Entity.Character;

import Model.Entity.Character.Mount.Mount;
import Model.Entity.Character.Occupation.Occupation;
import Model.Entity.Entity;
import Model.Inventory.Inventory;
import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.Equippable.Weapon.Weapon;
import Model.Items.Takeable.TakeableItem;
import Model.Items.Takeable.Useable.Money;
import Model.Map.Location;
import Model.Map.Map;
import Model.Map.Orientation;
import Model.Map.Tile.Terrain.Terrain;
import Model.Stats.CharacterStats;
import Utilities.Timer.CombatTimer;
import Utilities.GameMessageQueue;
import Utilities.Navigation.Navigation;
import Utilities.Observers.Observer;
import Utilities.Observers.Subject;
import Utilities.Visitor.CharacterVisitable;
import View.EntityView.CharacterView;

import java.util.ArrayList;


/**
 * Created by broskj on 4/6/16.
 *
 * Abstract class to act as the superclass to the player (Avatar) and NPCs.
 */
public abstract class Character extends Entity implements Observer, Subject, CharacterVisitable {
    private ArrayList<Observer> observers;

    private Occupation o;
    protected CharacterStats stats;
    protected Inventory inventory;
    private int radiusVisibility;
    private CombatTimer combatTimer;

    protected Character(Occupation o, Location location) {
        super(Navigation.makeCharNav(), location);
        this.o = o;
        this.stats = o.initStats();
        this.inventory = new Inventory();
        stats.addObserver(this);
        inventory.addObserver(this);
        this.radiusVisibility = 3; //might need to change to some sort of default later
        observers = new ArrayList<>();
        combatTimer = new CombatTimer();
    } // end private constructor

    public boolean isInCombat() {
        return combatTimer.isRunning();
    } // end isInCombat

    public void startCombatTimer() {
        combatTimer.start();
    } // end startCombatTimer

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void alert() {
        observers.forEach(Observer::update);
    }

    /*
    handle passing effects to stats
     */
    public void agilityEffect(int amount) {
        stats.agilityEffect(amount);
        alert();
    } // end agilityEffect

    public void hardinessEffect(int amount) {
        stats.hardinessEffect(amount);
        alert();
    } // end hardinessEffect

    public void intellectEffect(int amount) {
        stats.intellectEffect(amount);
        alert();
    } // end intellectEffect

    public void healthEffect(int amount) {
        stats.healthEffect(amount);
        if(amount >= 0)
            GameMessageQueue.push("You gained " + amount + " health.");
        else {
            GameMessageQueue.push("You took " + -1 * amount + " damage.");
            startCombatTimer();
        }
        alert();
    } // end lifeEffect

    public void livesEffect(int amount) {
        stats.livesEffect(amount);
        alert();
    } // end livesEffect

    public void levelEffect(int amount) {
        stats.levelEffect(amount);
        alert();
    } // end levelsEffect

    public void manaEffect(int amount) {
        stats.manaEffect(amount);
        if(amount >= 0)
            GameMessageQueue.push("You gained " + amount + " mana.");
        else
            GameMessageQueue.push("Lost " + -1*amount + " mana.");
        alert();
    } // end manaEffect

    public void movementEffect(int amount) {
        stats.movementEffect(amount);
        alert();
    } // end movementEffect

    public void strengthEffect(int amount) {
        stats.strengthEffect(amount);
        alert();
    } // end strengthEffect

    public void experienceEffect(int amount) {
        stats.experienceEffect(amount);
        if(amount >= 0)
            GameMessageQueue.push("You gained " + amount + " experience.");
        else
            GameMessageQueue.push("Lost " + -1*amount + " experience.");
        alert();
    } // end experienceEffect

    /*
    handle equipping items
     */
    public void equipWeapon(Weapon weapon) {
        inventory.equipWeapon(weapon);
        alert();
    } // end equipArmor

    public void equipArmor(Armor armor) {
        inventory.equipArmor(armor);
        alert();
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
    public int getBaseAgility() {
        return stats.getBaseAgility();
    }

    public int getAgility() {
        return stats.getAgility();
    }

    public int getExperience() {
        return stats.getExperience();
    }

    public int getBaseHardiness() {
        return stats.getBaseHardiness();
    }

    public int getHardiness() {
        return stats.getHardiness();
    }

    public int getBaseIntellect() {
        return stats.getBaseIntellect();
    }

    public int getIntellect() {
        return stats.getIntellect();
    }

    public int getBaseLives() {
        return stats.getBaseLives();
    }

    public int getLives() {
        return stats.getLives();
    }

    public int getBaseStrength() {
        return stats.getBaseStrength();
    }

    public int getStrength() {
        return stats.getStrength();
    }

    public int getBaseHealth() {
        return stats.getBaseHealth();
    }

    public int getHealth() {
        return stats.getHealth();
    }

    public int getLevel() {
        return stats.getLevel();
    }

    public int getBaseMana() {
        return stats.getBaseMana();
    }

    public int getMana() {
        return stats.getMana();
    }

    public int getBaseOffensiveRating() {
        return stats.getBaseOffensiveRating();
    }

    public int getOffensiveRating() {
        return stats.getOffensiveRating();
    }

    public int getBaseDefensiveRating() {
        return stats.getBaseDefensiveRating();
    }

    public int getDefensiveRating() {
        return stats.getDefensiveRating();
    }

    public int getBaseArmorRating() {
        return stats.getBaseArmorRating();
    }

    public int getArmorRating() {
        return stats.getArmorRating();
    }

    public int getEquippedWeapon() {
        return stats.getOffensiveRating();
    }

    public int getEquippedArmor() {
        return stats.getArmorRating();
    }

    public int getExperienceThreshold() {
        return stats.getExperienceThreshold();
    }

    public double getExperienceMultiplier() {
        return stats.getExperienceMultiplier();
    }

    public double getLevelMultiplier() {
        return stats.getLevelMultiplier();
    }

    @Override
    public boolean move(Map map, Orientation orientation) {
        if (this.orientation.equals(orientation)) {
            int x = location.getX() + orientation.x;
            int y = location.getY() + orientation.y;
            //z is zero here. Since it is a character it will move based on the next possible height
            Location newLocation = new Location(x,y,0);
            return map.moveCharacter(this, newLocation);
        }else {
            setOrientation(orientation);
            return false;
        }
    }
    public boolean checkStrategy(Terrain terrain){
       return navigation.canMove(terrain);
    }

    public void pickUpItem(TakeableItem item){
        inventory.pickUpItem(item);
        alert();
    } // end pickUpItem

    public void pickUpMoney(Money money) {
        inventory.pickUpMoney(money);
        alert();
    } // end pickUpMoney

    public boolean removeItem(TakeableItem item) {
        return inventory.removeItem(item);
    } // end removeItem

    public CharacterStats getCharacterStats() {return stats;}

    public abstract void onInteract();
    public Inventory getInventory(){ //needed for InventoryView - Sam
        return inventory;
    }


} // end abstract class Character
