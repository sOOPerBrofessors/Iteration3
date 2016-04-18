package Model.Skills.RangedSkills;

import Model.Entity.Character.Avatar;
import Model.Map.Map;
import Model.State.GameState.ActiveGameState;
import Utilities.InfluenceAreas.Planer.AngularEffect;

/**
 * Created by AndyZhu on 18/4/2016.
 */
public class Cleave extends RangedSkill {
    public Cleave(Avatar avatar) {
        super(avatar);
        name = "Cleave";
        manaCost = 1;
        coolDownTime = 1;
    }

    @Override
    public void execute (ActiveGameState activeGameState) {
        Map map = activeGameState.getMap();
        if(allConditionChecked()) {
            cleave(map);
            enforceManaCost();
            setTimePerformed();
        }
    }

    public void cleave(Map map) {
        calculateDamage();
        int radius = level + 2 > 5 ? 5 : level + 2;
        affectedArea = AngularEffect.getAngularArea(avatar.getLocation(), avatar.getOrientation(), radius);
        for (int i = 1; i < affectedArea.size(); i++) {
            curLocation = affectedArea.get(i);
            curTile = map.getTopTile(curLocation.getX(), curLocation.getY());
            if (curTile.hasCharacter()) {
                enemy = curTile.getCharacter();
                enemy.healthEffect(-damage);
            }
            else {

            }
        }
    }

    private void calculateDamage() {
        damage = avatar.getStrength() * level;
    }
}
