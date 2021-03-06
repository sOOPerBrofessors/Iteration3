package Model.Actions;

import Model.Entity.Character.Character;
import Model.Map.Location;
import Model.Map.Tile.Tile;
import Model.Map.Map;
import Utilities.InfluenceAreas.Linear.LinearEffect;

import java.util.ArrayList;

/**
 * Created by AndyZhu on 17/4/2016.
 */
public class Attack{
    private final int coolDownTime;
    private double timePerformed;
    private double remainingCoolDownTime;
    private int damage;
    private final Character character;

    public Attack(Character character) {
        this.character = character;
        coolDownTime = 1;
    }

    private boolean checkCD() {
        tick();
        return remainingCoolDownTime == 0.0;
    }
    private void setTimePerformed() {
        timePerformed = System.currentTimeMillis();
        remainingCoolDownTime = coolDownTime;
    }

    private void tick() {
        double timePassed = (System.currentTimeMillis() - timePerformed) / 1000;
        remainingCoolDownTime = coolDownTime - timePassed;
        if (remainingCoolDownTime <= 0) {
            remainingCoolDownTime = 0.0;
        }
    }

    public void execute(Map map) {
        if (checkCD()) {
            setTimePerformed();
            ArrayList<Location> affectedArea = LinearEffect.getLinearSameLevel(character.getLocation(), character.getOrientation(), 1);

            if (affectedArea.size() != 2) {

                return;

            }

            Location targetLocation = affectedArea.get(1);
            Tile targetTile = map.getTopTile(targetLocation.getX(), targetLocation.getY());
            if (targetTile.hasCharacter()) {
                Character enemy = targetTile.getCharacter();
                calculateDamage(enemy);
                enemy.healthEffect(-damage);
                if(enemy.getHealth() <= 0)
                    character.experienceEffect(enemy.getBaseHealth());
            }
        }
    }

    private void calculateDamage(Character enemy) {
        int enemyDefense = enemy.getDefensiveRating(),
                enemyArmor = enemy.getArmorRating();
        damage = (int)(Math.random() * character.getOffensiveRating())+1 -
                (int)(Math.random() * enemyArmor/2)+1 -
                (int)(Math.random() * enemyDefense/2)+1;
        if (damage < 1) {
            damage = 1;
        }
    }
}
