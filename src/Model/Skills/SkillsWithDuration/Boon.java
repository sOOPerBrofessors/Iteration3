package Model.Skills.SkillsWithDuration;

import Model.Entity.Character.Avatar;

/**
 * Created by AndyZhu on 13/4/2016.
 */
public class Boon extends SkillWithDuration{
    public Boon (Avatar avatar) {
        super (avatar);
        name = "Boon";
        manaCost = 1;
        coolDownTime = 1;
    }
}
