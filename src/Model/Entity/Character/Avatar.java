package Model.Entity.Character;

import Model.Entity.Character.Occupation.Occupation;
import Model.Entity.Character.Occupation.Smasher;
import Model.Entity.Character.Occupation.Sneak;
import Model.Entity.Character.Occupation.Summoner;

/**
 * Created by broskj on 4/6/16.
 *
 * Class to be operated by the player.
 */
public class Avatar extends Character {

    private Avatar(Occupation o) {
        super(o);
    } // end constructor

    public static Avatar makeSmasher() {
        return new Avatar(new Smasher());
    } // end factory method makeSmasher

    public static Avatar makeSneak() {
        return new Avatar(new Sneak());
    } // end factory method makeSneak

    public Avatar makeSummoner() {
        return new Avatar(new Summoner());
    } // end factory method makeSneak

    @Override
    public void update() {

    }

    @Override
    public void remove() {

    }
} // end class Avatar
