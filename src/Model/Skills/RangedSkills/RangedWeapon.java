package Model.Skills.RangedSkills;

import Model.Entity.Character.Avatar;

/**
 * Created by AndyZhu on 13/4/2016.
 */
public class RangedWeapon extends RangedSkill{
    public RangedWeapon(Avatar avatar) {
        super(avatar);
        name = "Ranged weapon";
        manaCost = 1;
        coolDownTime = 1;
    }
}
