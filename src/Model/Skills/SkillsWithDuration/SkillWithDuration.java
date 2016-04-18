package Model.Skills.SkillsWithDuration;

import Model.Entity.Character.Avatar;
import Model.Skills.Skill;

/**
 * Created by AndyZhu on 13/4/2016.
 */
abstract class SkillWithDuration extends Skill {

    int durationInMillis;

    SkillWithDuration(Avatar avatar) {
        super(avatar);
    }

    void calculateDuration() {
        durationInMillis = 10000;
    }
}
