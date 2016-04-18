package Model.Entity.Character.Occupation;

import Model.Entity.Character.Avatar;
import Model.Map.Orientation;
import Model.Skills.BindWounds;
import Model.Skills.RangedSkills.*;
import Model.Skills.Skill;
import Model.Skills.SkillsWithDuration.Creep;
import Model.Stats.CharacterStats;
import Utilities.Visitor.OccupationVisitor;

import java.util.ArrayList;

/**
 * Created by aseber on 4/17/16.
 */
public class Pet extends Occupation {

    @Override
    public CharacterStats initStats() {
        return CharacterStats.makePetStats();
    } // end initStats

    public ArrayList<Skill> getSkillList(Avatar avatar) {
        skillList.add(new BindWounds(avatar));
        skillList.add(new Observation(avatar));

        return skillList;
    }

    @Override
    public void acceptOccupationVistor(OccupationVisitor occupationViewVisitor, Orientation orientation) {
        occupationViewVisitor.visitPet(orientation);
    }

}
