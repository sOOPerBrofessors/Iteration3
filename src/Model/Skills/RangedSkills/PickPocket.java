package Model.Skills.RangedSkills;

import Model.Entity.Character.Avatar;
import Model.Items.Takeable.TakeableItem;
import Model.Map.Map;
import Model.State.GameState.ActiveGameState;
import Utilities.GameMessageQueue;
import Utilities.InfluenceAreas.Linear.LinearEffect;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by AndyZhu on 13/4/2016.
 */
public class PickPocket extends RangedSkill {

    public PickPocket (Avatar avatar) {
        super(avatar);
        name = "Pick pocket";
        manaCost = 1;
        coolDownTime = 1;
    }

    @Override
    public void execute(ActiveGameState activeGameState) {
        Map map = activeGameState.getMap();
        if (allConditionChecked()) {
            pickPocket(map);
            GameMessageQueue.push(name + " success!");
            enforceManaCost();
            setTimePerformed();
        }
    }

    private void pickPocket (Map map) {
        int radius = level > 3 ? 3 : level;
        affectedArea = LinearEffect.getLinearSameLevel(avatar.getLocation(), avatar.getOrientation(), radius);
        for (int i = 1; i < affectedArea.size(); i++) {
            curLocation = affectedArea.get(i);
            curTile = map.getTopTile(curLocation.getX(), curLocation.getY());
            if (curTile.hasCharacter()) {
                enemy = curTile.getCharacter();
                ArrayList<TakeableItem> enemyItems = enemy.getInventory().getPack().getItems();
                Random rand = new Random();
                int itemIndex;
                int maxIndex = enemyItems.size() - 1 <= 0 ? 0 : enemyItems.size() - 1;
                if (maxIndex != 0)
                    itemIndex = rand.nextInt(maxIndex);
                else {
                    itemIndex = 0;
                }
                if (enemyItems.size() > 0) {
                    TakeableItem itemToSteal = enemyItems.get(itemIndex);
                    enemy.getInventory().removeItem(itemToSteal);
                    Boolean successSteal = avatar.pickUpItem(itemToSteal);
                }
                else {
                    GameMessageQueue.push("Oops! Enemy has no item.");
                }
            }
        }
    }
}