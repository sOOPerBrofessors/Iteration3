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
        boolean properWeapon = true;

        return properWeapon;
    }

    @Override
    public void execute(ActiveGameState activeGameState) {
        Map map = activeGameState.getMap();
        if (allConditionChecked() && weaponCheck()) {
            damage = calculateDamage();
            radius = level > 3 ? 3 : level;
            affectedArea = LinearEffect.getLinearSameLevel(avatar.getLocation(), avatar.getOrientation(), radius);
            oneHandedAttack(map);
            GameMessageQueue.push(name + " Success!");
            enforceManaCost();
            setTimePerformed();
        }
    }

    private void oneHandedAttack (Map map) {
        attackAreaSingleTarget(map, affectedArea);
    }
}
