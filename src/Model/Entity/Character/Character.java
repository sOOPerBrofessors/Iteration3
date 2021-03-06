package Model.Entity.Character;

import Model.Actions.Attack;
import Model.Entity.Character.Occupation.Occupation;
import Model.Entity.Entity;
import Model.Faction.Faction;
import Model.Inventory.Inventory;
import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.Equippable.Weapon.Weapon;
import Model.Items.Takeable.TakeableItem;
import Model.Items.Takeable.Useable.Money;
import Model.Map.Location;
import Model.Map.Map;
import Model.Map.Orientation;
import Model.Map.Tile.Terrain.Terrain;
import Model.Skills.Skill;
import Model.Stats.CharacterStats;
import Utilities.ItemStuff.ItemManager;
import Utilities.Splats.DamageQueue;
import Utilities.Splats.DamageSplat;
import Utilities.Splats.ExperienceQueue;
import Utilities.Splats.ExperienceSplat;
import Utilities.Timer.CombatTimer;
import Utilities.Navigation.Navigation;
import Utilities.Observers.Observer;
import Utilities.Observers.Subject;
import Utilities.Timer.TimedEvent;
import Utilities.Visitor.CharacterVisitable;

import java.util.ArrayList;


/**
 * Created by broskj on 4/6/16.
 *
 * Abstract class to act as the superclass to the player (Avatar) and NPCs.
 */
public abstract class Character extends Entity implements Observer, Subject, CharacterVisitable {
    private final ArrayList<Observer> observers;

    final ArrayList<Skill> skills = new ArrayList<>();
    protected final Occupation o;
    protected final CharacterStats stats;
    protected final Inventory inventory;
    private final int radiusVisibility;
    private final Faction faction;
    private final CombatTimer combatTimer;
    private final Attack attack;
    private int delay;
    private boolean canMove;
    private final DamageQueue damageQueue;
    private final ExperienceQueue experienceQueue;
    private float alpha = 1f;
    private boolean dead;

    protected Character(Occupation o, Location location, Faction faction, Inventory inventory) {
        super(Navigation.makeCharNav(), location);
        this.o = o;
        this.faction = faction;
        this.stats = o.initStats();
        this.inventory = inventory;
        stats.addObserver(this);
        inventory.addObserver(this);
        this.radiusVisibility = 3; //might need to change to some sort of default later
        observers = new ArrayList<>();
        combatTimer = new CombatTimer();
        delay = 1500 / stats.getMovement();
        canMove = true;
        damageQueue = new DamageQueue();
        experienceQueue = new ExperienceQueue();
        dead = false;
        attack = new Attack(this);
    } // end private constructor

    protected void dropItems(ItemManager itemManager) {
        inventory.dump(itemManager, this);
    } // end dropItems

    private void delayMovement() {
        /*
        starts a timer of duration 'delay'; the beginning of which toggles the userCanMakeInput
         value to false, and after finishing execution toggles it back to true
         */
        new TimedEvent(delay, () -> canMove = false, e -> canMove = true).start();
    } // end delayMovement

    public void applyFallDamage(int amount) {
        healthEffect(amount);
    } // end applyFallDamage()

    protected void setDelay(int amount) {
        delay = 1500 / amount;
    } // end setDelay

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

    public Faction getFaction() {

        return faction;

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
        if(amount >= 0)
            startCombatTimer();
        damageQueue.push(new DamageSplat(amount));
        stats.healthEffect(amount);
        startCombatTimer();
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

    public void skillPointEffect (int amount) {
        stats.skillPointEffect(amount);
        alert();
    }

    public void defensiveRatingEffect (int amount) {
        stats.defensiveRatingEffect(amount);
        alert();
    }


    public void experienceEffect(int amount) {
        experienceQueue.push(new ExperienceSplat(amount));
        stats.experienceEffect(amount);
        alert();
    } // end experienceEffect

    /*
    handle equipping items
     */
    public void equipWeapon(Weapon weapon) {
        inventory.add(inventory.equipWeapon(weapon));
        alert();
    } // end equipArmor

    public void equipArmor(Armor armor) {
        inventory.add(inventory.equipArmor(armor));
        alert();
    } // end equipArmor

    boolean unEquipWeapon(){
        boolean success = inventory.unequipWeapon();
        alert();
        return success;
    }

    boolean unEquipArmor(){
        boolean success = inventory.unequipArmor();
        alert();
        return success;
    }

    public boolean equipSmasherWeapon(Weapon weapon) {
        return o.equipSmasherWeapon(weapon, this);
    } // end equipSmasherWeapon
    public boolean equipSmasherArmor(Armor armor) {
        return o.equipSmasherArmor(armor, this);
    } // end equipSmasherArmor
    public boolean equipSneakWeapon(Weapon weapon) {
        return o.equipSneakWeapon(weapon, this);
    } // end equipSneakWeapon
    public boolean equipSneakArmor(Armor armor) {
        return o.equipSneakArmor(armor, this);
    } // end equipSneakArmor
    public boolean equipSummonerWeapon(Weapon weapon) {
        return o.equipSummonerWeapon(weapon, this);
    } // end equipSummonerWeapon
    public boolean equipSummonerArmor(Armor armor) {
        return o.equipSummonerArmor(armor, this);
    } // end equipSummonerArmor
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

    public int getMovement() {
        return stats.getMovement();
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

    public int getSkillPoint() {
        return stats.getSkillPoint();
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
        if (this.orientation.equals(orientation) && canMove) {
            int x = location.getX() + orientation.x;
            int y = location.getY() + orientation.y;
            //z is zero here. Since it is a character it will move based on the next possible height
            Location newLocation = new Location(x,y,0);
            delayMovement();
            return map.moveCharacter(this, newLocation);
        }else {
            setOrientation(orientation);
            return false;
        }
    }

    public void notifyOfTeleport() {}
    public void notifyOfTrap() {}

    public boolean checkStrategy(Terrain terrain){
       return navigation.canMove(terrain);
    }

    public boolean pickUpItem(TakeableItem item){
        boolean success = inventory.pickUpItem(item);
        alert();
        return success;
    } // end pickUpItem

    public void pickUpMoney(Money money) {
        inventory.pickUpMoney(money);
        alert();
    } // end pickUpMoney

    void spendMoney(int amount) {
        inventory.spendMoney(amount);
        alert();
    } // end spendMoney

    public boolean removeItem(TakeableItem item) {
        alert();
        return inventory.removeItem(item);
    } // end removeItem

    public void utilizeItem(int index){
        inventory.utilizeItem(index,this);
        alert();
    }

    public CharacterStats getCharacterStats() {return stats;}

    public abstract void onInteract();
    public Inventory getInventory(){ //needed for InventoryView - Sam
        return inventory;
    }

    public boolean hasDamageQueued() { return damageQueue.size() > 0; }
    public boolean hasExperienceQueued() { return experienceQueue.size() > 0; }

    public DamageQueue getDamageQueue() { return damageQueue; }
    public ExperienceQueue getExperienceQueue() { return experienceQueue; }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public float getAlpha() {
        return alpha;
    }

    public boolean isDead() { return dead; }

    public void setDead(boolean dead) { this.dead = dead; }

    public void attack(Map map) {
        startCombatTimer();
        this.attack.execute(map);
    }
} // end abstract class Character
