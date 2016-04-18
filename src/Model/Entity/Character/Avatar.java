package Model.Entity.Character;

import Model.Entity.Character.Occupation.Occupation;
import Model.Entity.Character.Occupation.Smasher;
import Model.Entity.Character.Occupation.Sneak;
import Model.Entity.Character.Occupation.Summoner;
import Model.Inventory.Inventory;
import Model.Map.Location;
import Model.Skills.BindWounds;
import Model.Skills.CombatSkills.BrawlingSkill;
import Model.Skills.RangedSkills.Observation;
import Model.Skills.Skill;
import Model.Map.Map;
import Utilities.GameMessageQueue;
import Utilities.Visitor.CharacterTypeVisitor;

import Utilities.Visitor.CharacterVisitor;

import java.util.ArrayList;

/**
 * Created by broskj on 4/6/16.
 *
 * Class to be operated by the player.
 */
public class Avatar extends Character {

    private Avatar(Occupation o, Location location) {
        //TODO:I'm not sure how this is going to work but we need something here to define the initial location of an avatar
        super(o, location);
        this.skills.addAll(o.getSkillList(this)); //initialize skills
    } // end constructor

    public static Avatar makeSmasher(Location location) {
        return new Avatar(new Smasher(), location);
    } // end factory method makeSmasher

    public static Avatar makeSneak(Location location) {
        return new Avatar(new Sneak(),location);
    } // end factory method makeSneak

    public static Avatar makeSummoner(Location location) {
        return new Avatar(new Summoner(), location);
    } // end factory method makeSneak

    public static Avatar makeSmasher() {
        return new Avatar(new Smasher(), new Location(5,5,0));
    } // end factory method makeSmasher

    public static Avatar makeSneak() {
        return new Avatar(new Sneak(),new Location(5,5,0));
    } // end factory method makeSneak

    public static Avatar makeSummoner() {
        return new Avatar(new Summoner(), new Location(5,5,0));
    } // end factory method makeSneak

    public Inventory getInventory(){ //needed for InventoryView - Sam
        return inventory;
    }

    public Skill getSkill (int index) {
        return skills.get(index);
    }

    public ArrayList<Skill> getSKillList () {
        return skills;
    }

    @Override
    public void update() {
        stats.setEquippedArmor(inventory.getArmorValue());
        stats.setEquippedWeapon(inventory.getWeaponValue());
        stats.recompute();
        setDelay(getMovement());
        alert();
    } // end update

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
        if(amount >= 0)
            GameMessageQueue.push("You gained " + amount + " mana.");
        else
            GameMessageQueue.push("Lost " + -1*amount + " mana.");
    } // end manaEffect

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

    //Player specific items
    public void checkInteract(Map map){
        int newX = getX() + orientation.x;
        int newY = getY() + orientation.y;
        //the new location doesn't matter what z position it is, it will check for the the highest tile at a point
        map.checkTileInteraction(this, location, new Location(newX,newY,0));
    }

    @Override
    public void onInteract() {
        //Do nothing on interact
    }

}
