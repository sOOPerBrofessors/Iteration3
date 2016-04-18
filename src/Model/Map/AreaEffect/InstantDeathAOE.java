package Model.Map.AreaEffect;

import Model.Entity.Character.Character;
import Utilities.Visitor.AOEVisitor;

/**
 * Created by dyeung on 4/15/16.
 */
public class InstantDeathAOE extends AreaOfEffect {
    public InstantDeathAOE() {
        super(1);
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
