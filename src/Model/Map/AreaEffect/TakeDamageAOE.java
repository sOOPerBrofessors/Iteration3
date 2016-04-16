package Model.Map.AreaEffect;

import Model.Entity.Character.Character;
import Utilities.Visitor.AOEVisitor;

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

    @Override
    public void acceptAOEVisitor(AOEVisitor aoeVisitor) {
        aoeVisitor.visitTakeDamageAoe();
    }
}
