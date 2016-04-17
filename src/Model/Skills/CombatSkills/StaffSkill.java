package Model.Skills.CombatSkills;

import Model.Entity.Character.Avatar;
import Model.Map.Map;
import Utilities.ErrorLevel;
import Utilities.GameMessageQueue;
import Utilities.InfluenceAreas.Linear.LinearEffect;
import Utilities.MessageHandler;
import Utilities.PersonFilter;

/**
 * Created by AndyZhu on 13/4/2016.
 */
public class StaffSkill extends CombatSkill{
    public StaffSkill (Avatar avatar) {
        super(avatar);
        name = "Staff Attack";
        manaCost = 1;
        coolDownTime = 1;
        damageFactor = 1;
    }

    @Override
    public boolean weaponCheck() {
        boolean properWeapon = true;

        return properWeapon;
    }

    @Override
    public void execute(Map map) {
        if (checkAll() && weaponCheck()) {
            damage = calculateDamage();
            radius = 1;
            affectedArea = LinearEffect.getLinearSameLevel(avatar.getLocation(), avatar.getOrientation(), radius);
            staffAttack(map);
            GameMessageQueue.push(name + " Success!");
            enforceManaCost();
            setTimePerformed();
        }
    }

    private void staffAttack (Map map) {
        attackAreaSingleTarget(map, affectedArea);
    }
}
