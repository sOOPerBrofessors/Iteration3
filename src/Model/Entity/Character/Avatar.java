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

    @Override
    public void update() {

    }

    @Override
    public void remove() {

    }

    @Override
    public MapObjectView acceptMapVisitor(ColumnVisitor columnVisitor) {
        return columnVisitor.createAvatarView(this);
    }

}
