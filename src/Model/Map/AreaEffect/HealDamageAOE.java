package Model.Map.AreaEffect;

import Model.Entity.Character.Character;
import Utilities.Visitor.AOEVisitor;

/**
 * Created by dyeung on 4/15/16.
 */
public class HealDamageAOE extends AreaOfEffect {

    public HealDamageAOE(int value) {
        super(value);
    }

    @Override
    public void acceptAOEVisitor(AOEVisitor aoeVisitor) {
        aoeVisitor.visitHealAOE();
    }

    @Override
    public void onInteract(Character character) {
        character.healthEffect(value);

    }
}
