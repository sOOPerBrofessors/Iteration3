package Model.Map.AreaEffect;

import Model.Entity.Character.Character;

/**
 * Created by dyeung on 4/14/16.
 */
public class LevelUpAOE extends AreaOfEffect{
    public LevelUpAOE(int value) {
        super(value);
    }

    @Override
    public void onInteract(Character character) {
        character.levelEffect(value);

    }
}
