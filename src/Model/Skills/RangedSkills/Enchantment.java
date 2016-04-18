package Model.Skills.RangedSkills;

import Model.Entity.Character.Avatar;
import Model.Entity.Character.Character;
import Model.Map.Location;
import Model.Map.Map;
import Model.Map.Tile.Tile;
import Model.State.GameState.ActiveGameState;
import Utilities.GameMessageQueue;
import Utilities.InfluenceAreas.Planer.RadialEffect;
import Utilities.Timer.EnchantmentTimer;

import java.util.ArrayList;

/**
 * Created by AndyZhu on 13/4/2016.
 */
public class Enchantment extends RangedSkill{

    private int durationMillis = 1000;

    public Enchantment (Avatar avatar) {
        super(avatar);
        name = "Enchantment";
        level = 1;
        manaCost = 1;
        coolDownTime = 1;
    }

    @Override
    public void execute(ActiveGameState activeGameState) {
        Map map = activeGameState.getMap();
        if (allConditionChecked()) {
            enchantment(map);
            GameMessageQueue.push(name + " success");
            enforceManaCost();
            setTimePerformed();
        }
    }

    private void enchantment (Map map) {
        calculateDuration();
        calculateModifier();
        ArrayList<Location> affectedArea = RadialEffect.getRadialArea(avatar.getLocation(), level);
        for (int i = 1; i < affectedArea.size(); i++) {
            curLocation = affectedArea.get(i);
            Tile curTile = map.getTopTile(curLocation.getX(), curLocation.getY());
            if (curTile.hasCharacter()) {
                Character enemy = curTile.getCharacter();
                new EnchantmentTimer(durationMillis, enemy).start();
                GameMessageQueue.push("Enemy at (" + curLocation.getX() + ", " + curLocation.getY() + ") is slowed down");
            }
        }
    }

    private void calculateDuration() {
        durationMillis = level * 1000;
    }

    private void calculateModifier() {
        int modifier = level;
    }
}
