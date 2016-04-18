package Model.Skills.CombatSkills;

import Model.Entity.Character.Avatar;
import Model.Entity.Character.Character;
import Model.Map.Location;
import Model.Map.Map;
import Model.Map.Tile.Tile;
import Model.Skills.Skill;
import Utilities.GameMessageQueue;

import java.util.ArrayList;

/**
 * Created by AndyZhu on 5/4/2016.
 */
abstract class CombatSkill extends Skill {
    Character enemy;
    Tile curTile;
    int radius;

    int damage;
    int damageFactor;
    ArrayList<Location> affectedArea;

    CombatSkill(Avatar avatar) {
        super(avatar);
    }

    public abstract boolean weaponCheck();

    int calculateDamage() {
        int offensiveRating = avatar.getBaseOffensiveRating();
        int totalDamage = damageFactor * level * offensiveRating / 5;
        totalDamage = totalDamage < 1 ? 1 : totalDamage;
        return totalDamage;
    }

    void attackAreaSingleTarget(Map map, ArrayList<Location> locations) {
        for (int i = 1; i < locations.size(); i++) {
            Location location = locations.get(i);
            int x = location.getX();
            int y = location.getY();
            curTile = map.getTopTile(x, y);
            if (curTile.hasCharacter()) {
                enemy = curTile.getCharacter();
                enemy.healthEffect(-damage);
                return;
            }
        }
        GameMessageQueue.push(name + ": No enemy found!");
    }
}
