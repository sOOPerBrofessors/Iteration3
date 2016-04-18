package Model.Skills.RangedSkills;

import Model.Entity.Character.Avatar;
import Model.Items.Takeable.TakeableItem;
import Model.Map.Location;
import Model.Map.Map;
import Utilities.GameMessageQueue;
import Utilities.InfluenceAreas.Linear.LinearEffect;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by AndyZhu on 13/4/2016.
 */
public class PickPocket extends RangedSkill {
    private int radius;
    private ArrayList<TakeableItem> enemyItems;
    private TakeableItem itemToSteal;

    public PickPocket (Avatar avatar) {
        super(avatar);
        name = "Pick pocket";
        level = 10; //TODO: testing
        manaCost = 1;
        coolDownTime = 1;
    }

    @Override
    public void execute(Map map) {
        if (allConditionChecked()) {
            pickPocket(map);
            GameMessageQueue.push(name + " success!");
            enforceManaCost();
            setTimePerformed();
        }
    }

    private void pickPocket (Map map) {
        radius = level > 3 ? 3 : level;
        affectedArea = LinearEffect.getLinearSameLevel(avatar.getLocation(), avatar.getOrientation(), radius);
        for (int i = 1; i < affectedArea.size(); i++) {
            curLocation = affectedArea.get(i);
            curTile = map.getTopTile(curLocation.getX(), curLocation.getY());
            if (curTile.hasCharacter()) {
                enemy = curTile.getCharacter();
                enemyItems = enemy.getInventory().getPack().getItems();
                Random rand = new Random();
                int itemIndex;
                int maxSize = enemyItems.size() - 1 <= 0 ? 0 : enemyItems.size() - 1;
                if (maxSize != 0)
                    itemIndex = rand.nextInt(maxSize);
                else {
                    itemIndex = 0;
                }
                if (enemyItems.size() > 0) {
                    itemToSteal = enemyItems.get(itemIndex);
                    enemy.getInventory().removeItem(itemToSteal);
                    avatar.pickUpItem(itemToSteal);
                    GameMessageQueue.push("You stole a " + itemToSteal.getName());
                }
                else {
                    GameMessageQueue.push("Oops! Enemy has no item.");
                }
            }
        }
    }
}