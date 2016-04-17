package Model.Skills.RangedSkills;

import Model.Entity.Character.Avatar;

/**
 * Created by AndyZhu on 13/4/2016.
 */
public class PickPocket extends RangedSkill {
    public PickPocket (Avatar avatar) {
        super(avatar);
        name = "Pick pocket";
        manaCost = 1;
        coolDownTime = 1;
    }
}