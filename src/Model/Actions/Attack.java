package Model.Actions;

import Model.Entity.Character.Character;
import Model.Map.Location;
import Model.Map.Tile.Tile;
import Model.Map.Map;
import Utilities.GameMessageQueue;
import Utilities.InfluenceAreas.Linear.LinearEffect;

import java.util.ArrayList;

/**
 * Created by AndyZhu on 17/4/2016.
 */
public class Attack{
    private int coolDownTime;
    private double timePerformed;
    private double remainingCoolDownTime;
    private int damage;
    private Character character;
    private Character enemy;
    private ArrayList<Location> affectedArea;
    private Location targetLocation;
    private Tile targetTile;

    public Attack(Character character) {
        this.character = character;
        coolDownTime = 1;
    }

    private boolean checkCD() {
        tick();
        return remainingCoolDownTime == 0.0;
    }
    protected void setTimePerformed() {
        timePerformed = System.currentTimeMillis();
        remainingCoolDownTime = coolDownTime;
    }

    public void tick() {
        double timePassed = (System.currentTimeMillis() - timePerformed) / 1000;
        remainingCoolDownTime = coolDownTime - timePassed;
        if (remainingCoolDownTime <= 0) {
            remainingCoolDownTime = 0.0;
        }
    }

    public void execute(Map map) {
        if (checkCD()) {
            calculateDamage();
            setTimePerformed();
            affectedArea = LinearEffect.getLinearSameLevel(character.getLocation(), character.getOrientation(), 1);
            targetLocation = affectedArea.get(1);
            targetTile = map.getTopTile(targetLocation.getX(), targetLocation.getY());
            if (targetTile.hasCharacter()) {
                enemy = targetTile.getCharacter();
                enemy.healthEffect(-damage);
            }
        }
        else {
            GameMessageQueue.push("You are not prepared for next attack");
        }
    }

    private void calculateDamage() {
        damage = character.getOffensiveRating() / 5;
        if (damage < 1) {
            damage = 1;
        }
    }
}
