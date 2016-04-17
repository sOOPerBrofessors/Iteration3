package Model.Skills.RangedSkills;

import Model.Entity.Character.Avatar;

/**
 * Created by AndyZhu on 13/4/2016.
 */
public class RemoveTrap extends RangedSkill {
    public RemoveTrap (Avatar avatar) {
        super(avatar);
        name = "Remove trap";
        manaCost = 1;
        coolDownTime = 1;
    }
}
