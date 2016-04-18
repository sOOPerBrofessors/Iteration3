package Model.Map.Tile.Terrain;


import Controller.ControllerUtility.Command;
import Model.Entity.Character.Character;
import Model.Map.Map;
import Model.Map.Orientation;
import Utilities.Timer.TimedEvent;
import Utilities.Visitor.TerrainVisitor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sgl on 4/5/16.
 */
public class RiverTerrain extends WaterTerrain {
    private final int flowRate;
    private final Orientation direction;

    public RiverTerrain(Orientation orientation){
        flowRate = 1000;
        this.direction = orientation;
        int delay = 1000;
        boolean canMove = false;
    }

    private boolean movePlayer(Map map, Character character){
        //entity.move(direction);
        //return character.move(map, direction);
        character.setOrientation(direction);
        return map.moveCharacter(character, character.getLocation().getAdjacent(direction));
    }

    @Override
    public void onInteract(Map map, Character character) {
        System.out.println("River: started interaction");
        new TimedEvent(flowRate, new Command() {
            @Override
            public void execute() {
                System.out.println("started");
            }
        }, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                movePlayer(map, character);
            }
        }).start();
        //character.setDelay(flowRate);
        //character.move(map, direction);
        //map.moveCharacter(character, character.getLocation().getAdjacent(direction));
        //character.setOrientation(direction);
        //character.setDelay(flowRate);
        //character.move(map, direction);
        //map.moveCharacter(character, map.ge)
    }

    @Override
    public void acceptTerrainVisitor(TerrainVisitor tv) {
        tv.visitRiverTerrain();
    }
}
