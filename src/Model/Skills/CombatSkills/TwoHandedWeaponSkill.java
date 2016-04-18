package Model.Skills.CombatSkills;

import Model.Entity.Character.Avatar;
import Model.Entity.Character.Character;
import Model.Map.Location;
import Model.Map.Map;
import Model.State.GameState.ActiveGameState;
import Utilities.GameMessageQueue;
import Utilities.InfluenceAreas.Planer.AngularEffect;

import java.util.ArrayList;

/**
 * Created by AndyZhu on 13/4/2016.
 *
 * Two handed weapon attack is powerful, with a damage factor of 3, and attcks all enemies in an angular area
 */
public class TwoHandedWeaponSkill extends CombatSkill{
    public TwoHandedWeaponSkill (Avatar avatar) {
        super(avatar);
        name = "THW Attack";
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
    public void execute(ActiveGameState activeGameState) {
        Map map = activeGameState.getMap();
        if (allConditionChecked() && weaponCheck()) {
            damage = calculateDamage();
            radius = level > 4 ? 4 : level;
            affectedArea = AngularEffect.getAngularArea(avatar.getLocation(), avatar.getOrientation(), radius);
            twoHandedAttack(map);
            GameMessageQueue.push(name + " Success!");
            enforceManaCost();
            setTimePerformed();
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
        if (enemyList.isEmpty()) {
            GameMessageQueue.push(name + ": No enemy found!");
        }
        for (Character anEnemy : enemyList) {
            anEnemy.healthEffect(-damage);
        }
    }
}
