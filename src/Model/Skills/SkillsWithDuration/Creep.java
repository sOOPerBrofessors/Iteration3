package Model.Skills.SkillsWithDuration;

import Model.Entity.Character.Avatar;

/**
 * Created by AndyZhu on 13/4/2016.
 */
public class Creep extends SkillWithDuration{
    public Creep (Avatar avatar) {
        super(avatar);
        name = "Creep";
        manaCost = 1;
        coolDownTime = 1;
    }
}
