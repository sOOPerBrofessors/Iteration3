package Controller.AI_Controller.VisualCortex.VisualInformation;

import Model.Entity.Character.Character;
import Model.Entity.Entity;
import Visitors.VisualInformationVisitor;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by aseber on 4/6/16.
 */
public class VisualInformation {

    // I should know the current entity location?
    // This lets me compute distances and then pump that into a hashmap<Entity, dist> so I can do more fun stuff with weights

    private final HashMap<Character, Double> entityVisualInformation = new HashMap<>();
//    private HashMap<Point, Item> itemVIsualInformation = new HashMap<>();

    public void addEntityVisualInformation(Character character, double distance) {

        entityVisualInformation.put(character, distance);

    }

    public final Map<Character, Double> getEntityInformation() {

        return Collections.unmodifiableMap(entityVisualInformation);

    }

    public boolean entityExists(Entity entity) {

        return entityVisualInformation.values().contains(entity);

    }

    public void accept(VisualInformationVisitor visitor) {

        visitor.visit(this);

    }

    public void purge() {

        entityVisualInformation.clear();
//        itemVisualInformation.clear();

    }

}
