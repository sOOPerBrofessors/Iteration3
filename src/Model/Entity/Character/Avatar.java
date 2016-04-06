package Model.Entity.Character;

import Model.Entity.Character.Occupation.Occupation;
import Model.Entity.Character.Occupation.OccupationStrategy.OccupationStrategy;
import Model.Entity.Character.Occupation.OccupationStrategy.SummonerStrategy;
import Model.Entity.Character.Occupation.Smasher;
import Model.Entity.Character.Occupation.Sneak;
import Model.Entity.Character.Occupation.Summoner;

/**
 * Created by broskj on 4/6/16.
 */
public class Avatar extends Character {
    private Avatar(Occupation o, OccupationStrategy s) {
        super(o, s);
    } // end constructor

    public Character makeSmasher() {
        return new Character(new Smasher(), new SmasherStrategy());
    } // end factory method makeSmasher

    public Character makeSneak() {
        return new Character(new Sneak(), new SneakStrategy());
    } // end factory method makeSneak

    public Character makeSummoner() {
        return new Avatar(new Summoner(), new SummonerStrategy());
    } // end factory method makeSneak
}
