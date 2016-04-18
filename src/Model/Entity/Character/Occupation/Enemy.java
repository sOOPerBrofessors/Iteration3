package Model.Entity.Character.Occupation;

import Model.Entity.Character.Avatar;
import Model.Entity.Character.Character;
import Model.Map.Orientation;
import Model.Skills.BindWounds;
import Model.Skills.RangedSkills.Observation;
import Model.Skills.Skill;
import Model.Stats.CharacterStats;
import Utilities.Visitor.OccupationVisitor;

import java.util.ArrayList;

/**
 * Created by sgl on 4/18/16.
 */
public class Enemy extends Occupation {

    @Override
    public CharacterStats initStats() {
        return CharacterStats.makeEnemyStats();
    } // end initStats

    @Override
    public void acceptOccupationVistor(OccupationVisitor occupationViewVisitor, Orientation orientation) {
        occupationViewVisitor.visitEnemy(orientation);
    }

    @Override
    public String toString() {
        return "enemy";
    }

    public ArrayList<Skill> getSkillList(Avatar character) {
        skillList.add(new BindWounds(character));
        skillList.add(new Observation(character));

        return skillList;
    }
}
