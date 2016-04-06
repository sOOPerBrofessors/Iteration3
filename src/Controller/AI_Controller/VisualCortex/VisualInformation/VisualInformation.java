package Controller.AI_Controller.VisualCortex.VisualInformation;

import Model.Entity;

import java.awt.*;
import java.util.HashMap;

/**
 * Created by aseber on 4/6/16.
 */
public class VisualInformation {

    // I should know the current entity location?
    // This lets me compute distances and then pump that into a hashmap<Entity, dist> so I can do more fun stuff with weights

    HashMap<Point, Entity> entityVisualInformation = new HashMap<>();
//    HashMap<Point, Items> itemVIsualInformation = new HashMap<>();

    public boolean entityExists(Entity entity) {

        return entityVisualInformation.values().contains(entity);

    }

    public void purge() {

        entityVisualInformation.clear();
//        itemVisualInformation.clear();

    }

}
