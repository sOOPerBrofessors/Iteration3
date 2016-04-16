package Model.Map.AreaEffect;

import Model.Entity.Character.Character;

/**
 * Created by dyeung on 4/15/16.
 */
public class TakeDamageAOE extends AreaOfEffect {
    public TakeDamageAOE(int value) {
        super(value);
    }

    @Override
    public void onInteract(Character character) {
        character.healthEffect(value);
    }
}
