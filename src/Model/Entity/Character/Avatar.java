package Model.Entity.Character;

import Model.Entity.Character.Occupation.Occupation;
import Model.Entity.Character.Occupation.OccupationStrategy.OccupationStrategy;
import Model.Entity.Character.Occupation.OccupationStrategy.SmasherStrategy;
import Model.Entity.Character.Occupation.OccupationStrategy.SneakStrategy;
import Model.Entity.Character.Occupation.OccupationStrategy.SummonerStrategy;
import Model.Entity.Character.Occupation.Smasher;
import Model.Entity.Character.Occupation.Sneak;
import Model.Entity.Character.Occupation.Summoner;

/**
 * Created by broskj on 4/6/16.
 *
 * Class to be operated by the player.
 */
public class Avatar extends Character {
    private Avatar(Occupation o, OccupationStrategy s) {
        super(o, s);
    } // end constructor

    public Avatar makeSmasher() {
        return new Avatar(new Smasher(), new SmasherStrategy());
    } // end factory method makeSmasher

    public Avatar makeSneak() {
        return new Avatar(new Sneak(), new SneakStrategy());
    } // end factory method makeSneak

    public Avatar makeSummoner() {
        return new Avatar(new Summoner(), new SummonerStrategy());
    } // end factory method makeSneak
} // end class Avatar
