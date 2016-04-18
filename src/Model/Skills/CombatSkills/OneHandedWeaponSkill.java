package Model.Skills.CombatSkills;

import Model.Entity.Character.Avatar;
import Model.Map.Map;
import Model.State.GameState.ActiveGameState;
import Utilities.GameMessageQueue;
import Utilities.InfluenceAreas.Linear.LinearEffect;

/**
 * Created by AndyZhu on 13/4/2016.
 */
public class OneHandedWeaponSkill extends CombatSkill{
    public OneHandedWeaponSkill (Avatar avatar) {
        super(avatar);
        name = "OHW Attack";
        manaCost = 1;
        coolDownTime = 1;
        damageFactor = 2;
    }

    @Override
    public boolean weaponCheck() {
        boolean properWeapon = false;
        if (avatar.getAttackInterval() == 1.5) {
            properWeapon = true;
        }
        return properWeapon;
    }

    @Override
    public void execute(ActiveGameState activeGameState) {
        Map map = activeGameState.getMap();
        if (weaponCheck()) {
            if (allConditionChecked()) {
                damage = calculateDamage();
                radius = level > 3 ? 3 : level;
                affectedArea = LinearEffect.getLinearSameLevel(avatar.getLocation(), avatar.getOrientation(), radius);
                oneHandedAttack(map);
                GameMessageQueue.push(name + " Success!");
                enforceManaCost();
                setTimePerformed();
            }
        }
        else {
            GameMessageQueue.push("Improper weapon, you should equip an OHW");
        }
    }

    private void oneHandedAttack (Map map) {
        attackAreaSingleTarget(map, affectedArea);
    }
}
