package Model.Skills.RangedSkills;

import Model.Entity.Character.Avatar;
import Model.Entity.Character.Character;
import Model.Map.Location;
import Model.Map.Map;
import Model.Map.Orientation;
import Model.Map.Tile.Tile;
import Utilities.GameMessageQueue;
import Utilities.InfluenceAreas.Volumetric.PrismEffect;

import java.util.ArrayList;
import java.util.Random;


/**
 * Created by AndyZhu on 13/4/2016.
 *
 * Create HUD on NPCs nearby
 */
public class Observation extends RangedSkill{

    ArrayList<Location> affectedArea;
    Tile curTile;
    Character enemy;
    ArrayList<String> observedMsg;
    ObservationInfo observationInfo;

    public Observation (Avatar avatar){
        super(avatar);
        name = "Observation";
        //TODO:level = 10 for testing
        level = 10;
        manaCost = 1;
        coolDownTime = 5;
    }

    public ObservationInfo execute(Map map, Orientation orientation) {
        if (allConditionChecked()) {
            enforceManaCost();
            setTimePerformed();
            GameMessageQueue.push(name + " Success!");
            return performObservation(map, orientation);
        }
        else {
            observedMsg = new ArrayList<>();
            observedMsg.add("Failed");
            observationInfo = new ObservationInfo(observedMsg);
            return observationInfo;
        }
    }

    private ObservationInfo performObservation(Map map, Orientation orientation) {
        affectedArea = PrismEffect.getPrismVolumeFullHeight(avatar.getLocation(), level);

        for (int i = 1; i < affectedArea.size(); i++) {
            Location location = affectedArea.get(i);
            curTile = map.getTopTile(location.getX(),location.getY());
            if (curTile.hasCharacter()) {
                enemy = curTile.getCharacter();
                Random rand = new Random();
                int modifier = rand.nextInt(10 - level + i);
                int observedLevel = rand.nextInt(10) > 5 ? enemy.getLevel() + modifier : enemy.getLevel() - modifier;
                int observedHealth = rand.nextInt(10) > 5 ? enemy.getHealth() + modifier : enemy.getHealth() - modifier;
                int observedOffensive = rand.nextInt(10) > 5 ? enemy.getOffensiveRating() + modifier : enemy.getOffensiveRating() - modifier;
                observedMsg = new ArrayList<>();
                observedMsg.add("Level: " + observedLevel);
                observedMsg.add("Health: " + observedHealth);
                observedMsg.add("Offensive rating: " + observedOffensive);
                observationInfo = new ObservationInfo(enemy.getLocation(), observedMsg);
                return observationInfo;
            }
        }
        observedMsg = new ArrayList<>();
        observedMsg.add("No enemy found");
        observationInfo = new ObservationInfo(observedMsg);
        return observationInfo;
    }
}
