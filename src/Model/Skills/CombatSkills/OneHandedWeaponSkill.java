package Model.Skills.CombatSkills;

import Model.Entity.Character.Avatar;
import Model.Map.Map;
import Utilities.ErrorLevel;
import Utilities.InfluenceAreas.Linear.LinearEffect;
import Utilities.MessageHandler;
import Utilities.PersonFilter;

/**
 * Created by AndyZhu on 13/4/2016.
 */
public class OneHandedWeaponSkill extends CombatSkill{
    public OneHandedWeaponSkill (Avatar avatar) {
        super(avatar);
        name = "One Handed Weapon Attack";
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
    public void execute(Map map) {
        if (checkAll() && weaponCheck()) {
            damage = calculateDamage();
            radius = level > 3 ? 3 : level;
            affectedArea = LinearEffect.getLinearSameLevel(avatar.getLocation(), avatar.getOrientation(), radius);
            oneHandedAttack(map);

            enforceManaCost();
            setTimePerformed();
        }
        else {
            MessageHandler.println(name + "failed", ErrorLevel.NOTICE, PersonFilter.ANDY);
        }
    }

    private void oneHandedAttack (Map map) {
        attackAreaSingleTarget(map, affectedArea);
    }
}