package Model.Map.AreaEffect;

import Model.Entity.Character.Character;
import Model.Map.AreaEffect.AreaOfEffect;

/**
 * Created by dyeung on 4/15/16.
 */
public class InstantDeathAOE extends AreaOfEffect {
    public InstantDeathAOE(int value) {
        super(value);
    }

    @Override
    public void onInteract(Character character) {
        character.healthEffect(value);
    }
}
