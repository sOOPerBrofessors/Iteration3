package Model.Skills.RangedSkills;

import Model.Entity.Character.Avatar;
import Model.Map.Location;
import Model.Map.Map;
import Model.State.GameState.ActiveGameState;
import Utilities.GameMessageQueue;
import Utilities.InfluenceAreas.Planer.RadialEffect;

/**
 * Created by AndyZhu on 13/4/2016.
 *
 * Sneak skill.
 */
public class DetectTrap extends RangedSkill{

    public DetectTrap (Avatar avatar) {
        super(avatar);
        name = "Detect Trap";
        manaCost = 1;
        coolDownTime = 1;
    }

    public void execute (ActiveGameState activeGameState) {
        Map map = activeGameState.getMap();
        if (allConditionChecked()) {
            detectTrap(map);
            enforceManaCost();
            setTimePerformed();
        }
    }

    private void detectTrap(Map map) {
        affectedArea = RadialEffect.getRadialArea(avatar.getLocation(), level);
        for (Location location:affectedArea) {
            curLocation = location;
            curTile = map.getTopTile(curLocation.getX(), curLocation.getY());
            if (curTile.hasTrap()) {
                curTile.detectTrap();
                GameMessageQueue.push("Trap detected");
            }
        }
    }
}
