package Model.Entity.Character.Occupation;

import Model.Entity.Character.Avatar;
import Model.Map.Orientation;
import Model.Skills.BindWounds;
import Model.Skills.RangedSkills.Observation;
import Model.Skills.Skill;
import Model.Stats.CharacterStats;
import Utilities.Visitor.OccupationVisitor;

import java.util.ArrayList;

/**
 * Created by aseber on 4/18/16.
 */
public class Bird extends Occupation {

    @Override
    public CharacterStats initStats() {
        return CharacterStats.makeEnemyStats();
    } // end initStats

    @Override
    public void acceptOccupationVistor(OccupationVisitor occupationViewVisitor, Orientation orientation) {
        occupationViewVisitor.visitBird(orientation);
    }

    @Override
    public String toString() {
        return "bird";
    }

    public ArrayList<Skill> getSkillList(Avatar character) {
        skillList.add(new BindWounds(character));
        skillList.add(new Observation(character));

        return skillList;
    }

}
