package Utilities.Visitor;

import Model.Map.AreaEffect.AreaOfEffect;

/**
 * Created by dyeung on 4/16/16.
 */
public interface AOEVisitor {
    void visitHealAOE();
    void visitTakeDamageAoe();
    void visitTeleportAoe();
    void visitLevelUpAoe();
    void visitInstantDeath();
}
