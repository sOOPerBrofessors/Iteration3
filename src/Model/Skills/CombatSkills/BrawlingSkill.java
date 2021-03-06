package Model.Skills.CombatSkills;

import Model.Entity.Character.Avatar;
import Model.Map.Map;
import Model.State.GameState.ActiveGameState;
import Utilities.GameMessageQueue;
import Utilities.InfluenceAreas.Linear.LinearEffect;

/**
 * Created by AndyZhu on 13/4/2016.
 */
public class BrawlingSkill extends CombatSkill{

    public BrawlingSkill (Avatar avatar) {
        super(avatar);
        name = "Brawling";
        manaCost = 1;
        coolDownTime = 1;
        damageFactor = 1;
    }

    @Override
    public boolean weaponCheck() {
        boolean properWeapon = false;
        if (avatar.getAttackInterval() == 1) {
            properWeapon = true;
        }
        return properWeapon;
    }

    @Override
    public void execute(ActiveGameState activeGameState) {
        Map map = activeGameState.getMap();
        if  (weaponCheck()) {
            if (allConditionChecked()) {
                damage = calculateDamage();
                radius = level > 3 ? 3 : level;
                affectedArea = LinearEffect.getLinearSameLevel(avatar.getLocation(), avatar.getOrientation(), radius);
                brawling(map);
                GameMessageQueue.push(name + " Success!");
                enforceManaCost();
                setTimePerformed();
            }
        }
        else {
            GameMessageQueue.push("Improper weapon, you should equip nothing");
        }
    }

    private void brawling (Map map) {
        attackAreaSingleTarget(map, affectedArea);
    }
}
