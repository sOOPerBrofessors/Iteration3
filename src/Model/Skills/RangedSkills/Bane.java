package Model.Skills.RangedSkills;

import Model.Entity.Character.Avatar;
import Model.Map.Map;
import Utilities.GameMessageQueue;
import Utilities.InfluenceAreas.Linear.LinearEffect;

/**
 * Created by AndyZhu on 13/4/2016.
 */
public class Bane extends RangedSkill{

    public Bane(Avatar avatar) {
        super(avatar);
        name = "Bane";
        manaCost = 1;
        coolDownTime = 1;
    }

    @Override
    public void execute (Map map) {
        if (allConditionChecked()) {
            bane(map);
            enforceManaCost();
            setTimePerformed();
            GameMessageQueue.push(name + " success!");
        }
    }

    private int calculateDamage() {
        int skillDamage;
        skillDamage = level * avatar.getIntellect();
        return skillDamage;
    }

    private void bane (Map map) {
        damage = calculateDamage();
        radius = level + 3 > 6 ? 6 : level + 3; //max radius is 6
        affectedArea = LinearEffect.getLinearSameLevel(avatar.getLocation(), avatar.getOrientation(), radius);
        attackAreaSingleTarget(map);
    }
}
