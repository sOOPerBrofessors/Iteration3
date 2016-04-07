package Model.Effect;

import Model.Entity.Character.Character;

/**
 * Created by broskj on 4/7/16.
 */
public interface Effect {
    void execute(Character character, int amount);
} // end interface Effect
