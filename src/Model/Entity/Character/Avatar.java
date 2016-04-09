package Model.Entity.Character;

import Model.Entity.Character.Occupation.Occupation;
import Model.Entity.Character.Occupation.Smasher;
import Model.Entity.Character.Occupation.Sneak;
import Model.Entity.Character.Occupation.Summoner;
import Model.Map.Location;
import Utilities.Visitor.ColumnVisitor;
import View.MapView.MapObjectView;


/**
 * Created by broskj on 4/6/16.
 *
 * Class to be operated by the player.
 */
public class Avatar extends Character {

    private Avatar(Occupation o, Location location) {
        //I'm not sure how this is going to work but we need something here to define the initial location of an avatar
        super(o, location);
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
    public MapObjectView acceptMapVisitor(ColumnVisitor columnVisitor) {
        return columnVisitor.createCharacterView(this);
    }

    @Override
    public void tick() {
        // not used
    }
}
