package Model.Skills.RangedSkills;

import Model.Entity.Character.Avatar;
import Model.Map.Location;
import Model.Map.Map;
import Model.Map.Orientation;
import Model.Skills.Skill;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by AndyZhu on 5/4/2016.
 */
public abstract class RangedSkill extends Skill {

    public RangedSkill(Avatar avatar) {
        super(avatar);
    }

    @Override
    public void execute() {

    }

}
