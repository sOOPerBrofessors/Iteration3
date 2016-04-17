package Model.Skills.RangedSkills;

import Model.Entity.Character.Avatar;

/**
 * Created by AndyZhu on 13/4/2016.
 *
 * Sneak skill.
 */
public class DetectTrap extends RangedSkill{
    public DetectTrap (Avatar avatar) {
        super(avatar);
        name = "Detect Trap";
        manaCost = 1;
        coolDownTime = 1;
    }
}
