package Model.Map.AreaEffect;

import Model.Entity.Character.Character;
import Model.Map.AreaEffect.AreaOfEffect;
import Utilities.Visitor.AOEVisitor;

/**
 * Created by dyeung on 4/15/16.
 */
public class InstantDeathAOE extends AreaOfEffect {
    public InstantDeathAOE(int value) {
        super(value);
    }

    @Override
    public void onInteract(Character character) {
        character.healthEffect(-character.getHealth());
    }

    @Override
    public void acceptAOEVisitor(AOEVisitor aoeVisitor) {
        aoeVisitor.visitInstantDeath();
    }
}
