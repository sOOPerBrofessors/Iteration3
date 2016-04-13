package Model.Skills.CombatSkills;

import Model.Entity.Character.Avatar;
import Model.Skills.Skill;

/**
 * Created by AndyZhu on 5/4/2016.
 */
public abstract class CombatSkill extends Skill {

    protected int damage;
    protected int damageFactor;

    public CombatSkill(Avatar avatar) {
        super(avatar);
    }

    public abstract void equipmentCheck();

}
