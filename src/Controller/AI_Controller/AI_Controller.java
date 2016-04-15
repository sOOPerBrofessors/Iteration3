package Controller.AI_Controller;

import Model.Entity.Entity;
import Model.Map.Map;
import Model.Map.Orientation;
import Utilities.ErrorLevel;
import Utilities.MessageHandler;

import java.util.ArrayList;

/**
 * Created by aseber on 4/9/16.
 */
public class AI_Controller {

    Map map;

    public void setMap(Map map) {

        this.map = map;

    }

    public void move(Entity entity, Orientation orientation) {

        if (map == null) {

            MessageHandler.println("AI_Controller: Map null in move method call", ErrorLevel.ERROR);

        }

        entity.move(map, orientation);

    }

    public boolean canMove(Entity entity, Orientation orientation) {

        return entity.canMove(map, orientation);

    }

    public ArrayList<Orientation> moveableOrientations(Entity entity) {

        ArrayList<Orientation> orientations = new ArrayList<>();

        for (Orientation orientation : Orientation.values()) {

            if (canMove(entity, orientation)) {

                orientations.add(orientation);

            }

        }

        return orientations;

    }

}
