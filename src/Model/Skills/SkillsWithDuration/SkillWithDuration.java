package Model.Skills.SkillsWithDuration;

import Model.Entity.Character.Avatar;
import Model.Skills.Skill;

/**
 * Created by AndyZhu on 13/4/2016.
 */
public abstract class SkillWithDuration extends Skill {

    int durationInMillis;

    public SkillWithDuration(Avatar avatar) {
        super(avatar);
    }

    protected void calculateDuration() {
        durationInMillis = 10000;
    }
}
