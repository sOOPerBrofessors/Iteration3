package Model.Skills.RangedSkills;

import Model.Entity.Character.Avatar;
import Model.Map.Location;
import Model.Map.Map;
import Model.State.GameState.ActiveGameState;
import Utilities.InfluenceAreas.Planer.RadialEffect;
import Utilities.Timer.ArcaneExplosionTimer;
import Utilities.Timer.SecondArcaneExplosionTimer;
import View.SkillView.ArcaneExplosionView;
import View.SkillView.EarthShakeView;

import java.util.ArrayList;

/**
 * Created by AndyZhu on 18/4/2016.
 */
public class ArcaneExplosion extends RangedSkill{

    ArrayList<ArrayList<Location>> list = new ArrayList<>();

    public ArcaneExplosion (Avatar avatar) {
        super(avatar);
        name = "Arcane explosion";
        coolDownTime = 1;
        manaCost = 1;
    }

    @Override
    public void execute(ActiveGameState activeGameState) {
        Map map = activeGameState.getMap();
        if(allConditionChecked()) {
            new ArcaneExplosionTimer(this, map).start();
            enforceManaCost();
            setTimePerformed();
        }
    }

    public void activateArcaneExplosion(Map map) {
        ArcaneExplosionView.setArcaneViewFirstOn(true);
        calculateDamage();
        list = RadialEffect.getAreaWithRadius(avatar.getLocation(), 2);
        affectedArea = list.get(1);
        for (int i = 1; i < affectedArea.size(); i++) {
            curTile = map.getTopTile(affectedArea.get(i).getX(), affectedArea.get(i).getY());
            if (curTile.hasCharacter()) {
                enemy = curTile.getCharacter();
                enemy.healthEffect(-damage);
            }
        }
    }

    public void setSecondArcaneExplosion (Map map) {
        new SecondArcaneExplosionTimer(this, map).start();
    }
    public void secondArcaneExplosion(Map map) {
        ArcaneExplosionView.setArcaneViewFirstOn(false);
        ArcaneExplosionView.setArcaneViewSecondOn(true);
        calculateDamage();
        affectedArea = list.get(2);
        for (int i = 1; i < affectedArea.size(); i++) {
            curTile = map.getTopTile(affectedArea.get(i).getX(), affectedArea.get(i).getY());
            if (curTile.hasCharacter()) {
                enemy = curTile.getCharacter();
                enemy.healthEffect(-damage);
            }
        }
    }

    public void endArcaneExplosion() {
        ArcaneExplosionView.setArcaneViewSecondOn(false);
    }

    private void calculateDamage() {
        damage = avatar.getStrength() * level / 5;
        damage = damage < 1 ? 1 : damage;
    }
}
