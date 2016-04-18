package Model.Skills.SkillsWithDuration;

import Model.Entity.Character.Avatar;
import Model.Entity.Character.Character;
import Model.Map.Location;
import Model.State.GameState.ActiveGameState;
import Utilities.GameMessageQueue;
import Utilities.InfluenceAreas.Linear.LinearEffect;
import Utilities.Timer.CreepTimer;
import Model.Map.Map;
import java.util.ArrayList;


/**
 * Created by AndyZhu on 13/4/2016.
 *
 * Sneak skill. You can only back stab when you are creeping
 */
public class Creep extends SkillWithDuration {

    private boolean creeping = false;
    private int damage;
    private Character enemy;
    private ArrayList<Location> attackArea;

    public Creep (Avatar avatar) {
        super(avatar);
        name = "Creep";
        manaCost = 1;
        coolDownTime = 1;
    }

    @Override
    public void execute(ActiveGameState activeGameState) {
        Map map = activeGameState.getMap();
        if (creeping) {
            calculateDamage();
            backStab(map);
        }
        else if (allConditionChecked()) {
            if (!creeping) {
                creep();
                GameMessageQueue.push(name + " success!");
                enforceManaCost();
                setTimePerformed();
            }
        }
    }

    private void backStab(Map map) {
        attackArea = LinearEffect.getLinearSameLevel(avatar.getLocation(), avatar.getOrientation(), 1);
        Location targetLocation = attackArea.get(1);
        if (map.getTopTile(targetLocation.getX(),targetLocation.getY()).hasCharacter()) {
            enemy = map.getTopTile(targetLocation.getX(),targetLocation.getY()).getCharacter();
            if (enemy.getOrientation() == avatar.getOrientation()) {
                enemy.healthEffect(-damage);
                GameMessageQueue.push("Back stab success!");
                endCreep();
            }
            else {
                GameMessageQueue.push("You are not attacking enemy's back");
            }
        }
        else {
            GameMessageQueue.push("Back stab: Enemy not found!");
        }
    }

    private void creep() {
        calculateDuration();
        new CreepTimer(durationInMillis, this).start();
    }

    public void activateCreep() {
        avatar.setAlpha(0.5f);
        avatar.agilityEffect(level);
        avatar.movementEffect(3);
        creeping = true;
    }

    //only automatically end in CreepTimer when you didn't back stab
    public void endCreep() {
        if (creeping) {
            avatar.setAlpha(1f);
            avatar.agilityEffect(-level);
            avatar.movementEffect(-3);
            creeping = false;
        }
    }

    private void calculateDamage() {
        damage = avatar.getAgility() * level;
    }
}
