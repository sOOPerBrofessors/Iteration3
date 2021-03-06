package Model.Entity.Character;

import Model.Entity.Character.Occupation.Occupation;
import Model.Entity.Character.Occupation.Smasher;
import Model.Entity.Character.Occupation.Sneak;
import Model.Entity.Character.Occupation.Summoner;
import Model.Faction.FactionFactory;
import Model.Inventory.Inventory;
import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.Equippable.Weapon.Weapon;
import Model.Items.Takeable.TakeableItem;
import Model.Items.Takeable.Useable.Money;
import Model.Map.Location;
import Model.Skills.Skill;
import Utilities.GameMessageQueue;
import Utilities.ItemStuff.ItemManager;
import Utilities.Settings;
import Utilities.Visitor.CharacterTypeVisitor;

import Utilities.Visitor.CharacterVisitor;
import View.AreaViewport.HUDView.HUD;
import View.ViewUtilities.Sprites.ImageAssets;

import java.util.ArrayList;


/**
 * Created by broskj on 4/6/16.
 *
 * Class to be operated by the player.
 */
public class Avatar extends Character {

    private Avatar(Occupation o, Location location) {
        //TODO:I'm not sure how this is going to work but we need something here to define the initial location of an avatar
        super(o, location, FactionFactory.getFaction("blue"), new Inventory());
        this.skills.addAll(o.getSkillList(this)); //initialize skills
    } // end constructor

    public static Avatar makeSmasher(Location location) {
        HUD.setOccupationSprite(ImageAssets.smasherS);
        return new Avatar(new Smasher(), location);
    } // end factory method makeSmasher

    public static Avatar makeSneak(Location location) {
        HUD.setOccupationSprite(ImageAssets.sneakS);
        return new Avatar(new Sneak(),location);
    } // end factory method makeSneak

    public static Avatar makeSummoner(Location location) {
        HUD.setOccupationSprite(ImageAssets.summonerS);
        return new Avatar(new Summoner(), location);
    } // end factory method makeSneak

    public static Avatar makeSmasher() {
        HUD.setOccupationSprite(ImageAssets.smasherS);
        return new Avatar(new Smasher(), new Location(Settings.SPAWN_X, Settings.SPAWN_Y, Settings.SPAWN_Z));
    } // end factory method makeSmasher

    public static Avatar makeSneak() {
        HUD.setOccupationSprite(ImageAssets.sneakS);
        return new Avatar(new Sneak(),new Location(Settings.SPAWN_X, Settings.SPAWN_Y, Settings.SPAWN_Z));
    } // end factory method makeSneak

    public static Avatar makeSummoner() {
        HUD.setOccupationSprite(ImageAssets.summonerS);
        return new Avatar(new Summoner(), new Location(Settings.SPAWN_X, Settings.SPAWN_Y, Settings.SPAWN_Z));
    } // end factory method makeSmasher

    public Inventory getInventory(){ //needed for InventoryView - Sam
        return inventory;
    }

    public double getAttackInterval() {
        if (inventory.getEquipment().getWeapon() != null) {
            return inventory.getEquipment().getWeapon().getAttackInterval();
        }
        else {
            return 1;
        }
    }

    public Skill getSkill (int index) {
        return skills.get(index);
    }

    public ArrayList<Skill> getSKillList () {
        return skills;
    }

    public void dropItems(ItemManager itemManager) {
        inventory.dump(itemManager, this);
    }

    @Override
    public void update() {
        stats.setEquippedArmor(inventory.getArmorValue());
        stats.setEquippedWeapon(inventory.getWeaponValue());
        if(getExperience() > getExperienceThreshold()) {
            GameMessageQueue.push("Level up!");
            stats.levelUp();
        }
        if(getHealth() <= 0) {
            stats.kill();
            setDead(true);

            if(getLives() == 0) {
                GameMessageQueue.push("Game over!");
                // TODO: go to death state
            } else {
                String life;
                if(getLives() == 1)
                    life = "life";
                else
                    life = "lives";
                GameMessageQueue.push("Oh dear, you are dead!  " + getLives() + " " + life + " remaining.");
            }

        }
        stats.recompute();
        setDelay(getMovement());
        alert();
    } // end update

    @Override
    public void notifyOfTeleport() {
        GameMessageQueue.push("You've been teleported!");
    } // end notifyOfTeleport

    @Override
    public void notifyOfTrap() { GameMessageQueue.push("You've activated a trap!"); } // end notifyOfTrap

    @Override
    public void applyFallDamage(int amount) {
        GameMessageQueue.push("You hurt yourself from the fall!");
        super.applyFallDamage(amount);
    }

    @Override
    public void healthEffect(int amount) {
        super.healthEffect(amount);
        if(amount > 0)
            GameMessageQueue.push("You gained " + amount + " health.");
        else if(amount > 0) {
            GameMessageQueue.push("You took " + -1 * amount + " damage.");
        }
    } // end healthEffect

    @Override
    public void manaEffect(int amount) {
        super.manaEffect(amount);
        if(amount >= 0)
            GameMessageQueue.push("You gained " + amount + " mana.");
        else
            GameMessageQueue.push("Lost " + -1*amount + " mana.");
    } // end manaEffect

    @Override
    public void experienceEffect(int amount) {
        super.experienceEffect(amount);
        if(amount >= 0)
            GameMessageQueue.push("You gained " + amount + " experience.");
        else
            GameMessageQueue.push("Lost " + -1*amount + " experience.");
    } // end experienceEffect

    @Override
    public void movementEffect(int amount) {
        super.movementEffect(amount);
        if(amount >= 0)
            GameMessageQueue.push("You can now move more quickly.");
        else
            GameMessageQueue.push("Your movement has been slowed!");
    }

    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
        GameMessageQueue.push("Equipped " + weapon.getName());
    } // end equipArmor

    public void equipArmor(Armor armor) {
        super.equipArmor(armor);
        GameMessageQueue.push("Equipped " + armor.getName());
    } // end equipArmor

    public boolean unEquipWeapon(){
        if(super.unEquipWeapon()) {
            GameMessageQueue.push("Removed weapon.");
            return true;
        }
        GameMessageQueue.push("Your inventory is full, can't remove weapon.");
        return false;
    } // end unequipWeapon

    public boolean unEquipArmor(){
        if(super.unEquipArmor()) {
            GameMessageQueue.push("Removed armor.");
            return true;
        }
        GameMessageQueue.push("Your inventory is full, can't remove armor.");
        return false;
    } // end unequipArmor

    @Override
    public boolean pickUpItem(TakeableItem item) {
        if(super.pickUpItem(item)) {
            GameMessageQueue.push("Picked up " + item.getName());
            return true;
        }
        GameMessageQueue.push("Your inventory is full.");
        return false;
    }

    @Override
    public void pickUpMoney(Money money) {
        super.pickUpMoney(money);
        GameMessageQueue.push("Picked up " + money.getQuantity() + " coins.");
    } // end pickUpMoney

    @Override
    public void spendMoney(int amount) {
        super.spendMoney(amount);
        GameMessageQueue.push("Spent " + amount + " coins.");
    }

    @Override
    public void remove() {
        inventory.removeObserver(this);
    } // end remove

    @Override
    public void acceptCharacterVisitor(CharacterVisitor characterVisitor) {
        characterVisitor.visitInventory(inventory);
        characterVisitor.visitOccupation(o);
        characterVisitor.visitStats(stats);
    }

    @Override
    public void acceptCharacterTypeVisitor(CharacterTypeVisitor characterTypeVisitor) {
        characterTypeVisitor.visitAvatar(this);
    }

    @Override
    public void onInteract() {
        //Do nothing on interact
    }
}