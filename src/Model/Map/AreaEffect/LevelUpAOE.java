package Model.Map.AreaEffect;

import Model.Entity.Character.Character;
import Utilities.Visitor.AOEVisitor;

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

    @Override
    public void acceptAOEVisitor(AOEVisitor aoeVisitor) {
        aoeVisitor.visitLevelUpAoe();
    }
}
