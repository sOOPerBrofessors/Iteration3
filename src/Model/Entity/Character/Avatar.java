package Model.Entity.Character;

import Model.Entity.Character.Occupation.Occupation;
import Model.Entity.Character.Occupation.Smasher;
import Model.Entity.Character.Occupation.Sneak;
import Model.Entity.Character.Occupation.Summoner;
import Model.Inventory.Inventory;
import Model.Map.Location;
import Model.Skills.BindWounds;
import Model.Skills.RangedSkills.Observation;
import Model.Skills.Skill;
import Utilities.Observers.Observer;
import Utilities.Visitor.EntityViewVisitor;
import View.EntityView.CharacterView;


/**
 * Created by broskj on 4/6/16.
 *
 * Class to be operated by the player.
 */
public class Avatar extends Character {

    private Skill[] skills;

    private Avatar(Occupation o, Location location) {
        //TODO:I'm not sure how this is going to work but we need something here to define the initial location of an avatar
        super(o, location);
        //skill initialize
        skills = new Skill[] {
                new BindWounds(this),
                new Observation(this)
        };

        //Temporary
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
        return skills[index];
    }

    @Override
    public void update() {
        stats.setEquippedArmor(inventory.getArmorValue());
        stats.setEquippedWeapon(inventory.getWeaponValue());
        stats.recompute();
    } // end update

    @Override
    public void remove() {
        inventory.removeObserver(this);
    } // end remove

    @Override
    public void acceptEntityVisitor(EntityViewVisitor entityViewVisitor) {
        entityViewVisitor.createAvatarView(this);
    }


}
