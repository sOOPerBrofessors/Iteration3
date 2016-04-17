package Model.Skills.RangedSkills;

import Model.Entity.Character.Avatar;

/**
 * Created by AndyZhu on 13/4/2016.
 */
public class Enchantment extends RangedSkill{
    public Enchantment (Avatar avatar) {
        super(avatar);
        name = "Enchantment";
        manaCost = 1;
        coolDownTime = 1;
    }
}
