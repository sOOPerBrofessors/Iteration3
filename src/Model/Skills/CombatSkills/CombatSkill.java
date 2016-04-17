package Model.Skills.CombatSkills;

import Model.Entity.Character.Avatar;
import Model.Entity.Character.Character;
import Model.Map.Location;
import Model.Map.Map;
import Model.Map.Tile.Tile;
import Model.Skills.Skill;
import Utilities.InfluenceAreas.Linear.LinearEffect;

import java.util.ArrayList;

/**
 * Created by AndyZhu on 5/4/2016.
 */
public abstract class CombatSkill extends Skill {
    Character enemy;
    Tile curTile;
    int radius;

    protected int damage;
    protected int damageFactor;
    protected ArrayList<Location> affectedArea;

    public CombatSkill(Avatar avatar) {
        super(avatar);
    }

    public abstract boolean weaponCheck();

    protected int calculateDamage() {
        int offensiveRating = avatar.getBaseOffensiveRating();
        return damageFactor * level * offensiveRating / 5;
    }

    protected void attackAreaSingleTarget(Map map, ArrayList<Location> locations) {
        for (int i = 1; i < affectedArea.size(); i++) {
            Location location = affectedArea.get(i);
            int x = location.getX();
            int y = location.getY();
            curTile = map.getTopTile(x, y);
            if (curTile.hasCharacter()) {
                enemy = curTile.getCharacter();
                System.out.println("Enemy health before: " + enemy.getHealth());
                System.out.println("Total damage: " + damage);
                enemy.healthEffect(-damage);
                System.out.println("Enemy health after: " + enemy.getHealth());
                return;
            }
        }
    }
}
