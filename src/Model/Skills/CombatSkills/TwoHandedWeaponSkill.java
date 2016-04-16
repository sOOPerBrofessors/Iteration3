package Model.Skills.CombatSkills;

import Model.Entity.Character.Avatar;
import Model.Entity.Character.Character;
import Model.Map.Location;
import Model.Map.Map;
import Utilities.ErrorLevel;
import Utilities.InfluenceAreas.Planer.AngularEffect;
import Utilities.MessageHandler;
import Utilities.PersonFilter;

import java.util.ArrayList;

/**
 * Created by AndyZhu on 13/4/2016.
 *
 * Two handed weapon attack is powerful, with a damage factor of 3, and attcks all enemies in an angular area
 */
public class TwoHandedWeaponSkill extends CombatSkill{
    public TwoHandedWeaponSkill (Avatar avatar) {
        super(avatar);
        name = "Two Handed Weapon Attack";
        manaCost = 1;
        coolDownTime = 1;
        damageFactor = 3;
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
            radius = level > 4 ? 4 : level;
            affectedArea = AngularEffect.getAngularArea(avatar.getLocation(), avatar.getOrientation(), radius);
            twoHandedAttack(map);

            enforceManaCost();
            setTimePerformed();
        }
        else {
            MessageHandler.println(name + "failed", ErrorLevel.NOTICE, PersonFilter.ANDY);
        }
    }

    private void twoHandedAttack (Map map) {
        attackAreaMultipleTarget(map, affectedArea);
    }

    private void attackAreaMultipleTarget(Map map, ArrayList<Location> locations) {
        ArrayList<Character> enemyList = new ArrayList<>();
        for (int i = 1; i < affectedArea.size(); i++) {
            Location location = affectedArea.get(i);
            int x = location.getX();
            int y = location.getY();
            curTile = map.getTopTile(x, y);
            if (curTile.hasCharacter()) {
                enemy = curTile.getCharacter();
                enemyList.add(enemy);
            }
        }
        for (Character anEnemy : enemyList) {
            System.out.println("Enemy health before: " + enemy.getHealth());
            System.out.println("Total damage: " + damage);
            anEnemy.healthEffect(-damage);
            System.out.println("Enemy health after: " + enemy.getHealth());
        }
    }
}
