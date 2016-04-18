package Model.Skills.RangedSkills;

import Model.Entity.Character.Avatar;
import Model.Entity.Character.Character;
import Model.Map.Location;
import Model.Map.Map;
import Model.Map.Tile.Tile;
import Model.Skills.Skill;
import Model.State.GameState.ActiveGameState;
import Utilities.GameMessageQueue;

import java.util.ArrayList;

/**
 * Created by AndyZhu on 5/4/2016.
 */
public abstract class RangedSkill extends Skill {

    protected int damage;
    protected ArrayList<Location> affectedArea = new ArrayList<>();
    int radius;
    Tile curTile;
    protected Location curLocation = new Location(0, 0, 0);
    Character enemy;

    public RangedSkill(Avatar avatar) {
        super(avatar);
    }

    public void execute() {

    }

    public void execute(ActiveGameState activeGameState) {}

    protected void attackAreaSingleTarget(Map map) {
        for (int i = 1; i < affectedArea.size(); i++) {
            Location location = affectedArea.get(i);
            curTile = map.getTopTile(location.getX(), location.getY());
            if (curTile.hasCharacter()) {
                enemy = curTile.getCharacter();
                enemy.healthEffect(-damage);
                return;
            }
        }
        GameMessageQueue.push(name + ": No enemy found!");
    }
}