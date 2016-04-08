package Model.Entity.Character;

import Model.Entity.Character.Occupation.Occupation;
import Model.Entity.Character.Occupation.Smasher;
import Model.Entity.Character.Occupation.Sneak;
import Model.Entity.Character.Occupation.Summoner;
import Model.Map.Location;
import Model.Stats.CharacterStats;

/**
 * Created by broskj on 4/6/16.
 *
 * Class to be operated by the player.
 */
public class Avatar extends Character {

    private Avatar(Occupation o, CharacterStats s, Location location) {
        //I'm not sure how this is going to work but we need something here to define the initial location of an avatar
        super(o, s, location);
    } // end constructor

    public static Avatar makeSmasher(Location location) {
        return new Avatar(new Smasher(), Smasher.initStats(), location);
    } // end factory method makeSmasher

    public static Avatar makeSneak(Location location) {
        return new Avatar(new Sneak(), Sneak.initStats(),location);
    } // end factory method makeSneak

    public static Avatar makeSummoner(Location location) {
        return new Avatar(new Summoner(), Summoner.initStats(),location);
    } // end factory method makeSneak
} // end class Avatar
