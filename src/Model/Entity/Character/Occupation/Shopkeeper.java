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
public class Shopkeeper extends Occupation {

    @Override
    public CharacterStats initStats() {
        return CharacterStats.makeShopkeeperStats();
    } // end initStats

    @Override
    public void acceptOccupationVistor(OccupationVisitor occupationViewVisitor, Orientation orientation) {
        occupationViewVisitor.visitShopkeeper(orientation);
    }

    @Override
    public String toString() {
        return "shopkeeper";
    }

    public ArrayList<Skill> getSkillList(Avatar avatar) {
        skillList.add(new BindWounds(avatar));
        skillList.add(new Observation(avatar));

        return skillList;
    }

}
