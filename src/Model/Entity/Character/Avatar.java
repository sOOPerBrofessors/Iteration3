package Model.Entity.Character;

import Model.Entity.Character.Occupation.Occupation;
import Model.Entity.Character.Occupation.Smasher;
import Model.Entity.Character.Occupation.Sneak;
import Model.Entity.Character.Occupation.Summoner;
import Model.Stats.CharacterStats;

/**
 * Created by broskj on 4/6/16.
 *
 * Class to be operated by the player.
 */
public class Avatar extends Character {
    private Avatar(Occupation o, CharacterStats s) {
        super(o, s);
    } // end constructor

    public static Avatar makeSmasher() {
        return new Avatar(new Smasher(), Smasher.initStats());
    } // end factory method makeSmasher

    public static Avatar makeSneak() {
        return new Avatar(new Sneak(), Sneak.initStats());
    } // end factory method makeSneak

    public static Avatar makeSummoner() {
        return new Avatar(new Summoner(), Summoner.initStats());
    } // end factory method makeSneak
} // end class Avatar
