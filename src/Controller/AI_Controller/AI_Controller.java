package Controller.AI_Controller;

import Model.Entity.Entity;
import Model.Map.Map;
import Model.Map.Orientation;
import Utilities.ErrorLevel;
import Utilities.MessageHandler;

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

}
