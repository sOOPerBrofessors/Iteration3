package Model.Skills.RangedSkills;

import Model.Entity.Character.Avatar;
import Model.Map.Location;
import Model.State.GameState.ActiveGameState;
import Utilities.InfluenceAreas.Planer.RadialEffect;
import Utilities.Timer.EarthShakeTimer;
import View.SkillView.EarthShakeView;
import Model.Map.Map;

import java.util.ArrayList;

/**
 * Created by AndyZhu on 18/4/2016.
 */
public class EarthShake extends RangedSkill {
    private ArrayList<Location> newList;

    public EarthShake(Avatar avatar) {
        super(avatar);
        name = "Earth shake";
        level = 10;
        manaCost = 1;
        coolDownTime = 1;
    }

    @Override
    public void execute (ActiveGameState activeGameState) {
        Map map = activeGameState.getMap();
        if(allConditionChecked()) {
            System.out.println("Hi Line 27");
            new EarthShakeTimer(this, map).start();
            enforceManaCost();
            setTimePerformed();
        }
    }

    public void activateEarthShake(Map map) {
        EarthShakeView.setEarthShakeViewOn(true);
        System.out.println("Hi");
        calculateDamage();
        affectedArea = RadialEffect.getRadialArea(avatar.getLocation(), 1);
        for (int i = 1; i < affectedArea.size(); i++) {
            curLocation = affectedArea.get(i);
            curTile = map.getTopTile(curLocation.getX(), curLocation.getY());
            if (curTile.hasCharacter()) {
                enemy = curTile.getCharacter();
                enemy.healthEffect(-damage);
            }
        }
    }

    public void endEarthShake() {
        EarthShakeView.setEarthShakeViewOn(false);
    }

    private void calculateDamage() {
        damage = avatar.getStrength() * level;
    }
}
