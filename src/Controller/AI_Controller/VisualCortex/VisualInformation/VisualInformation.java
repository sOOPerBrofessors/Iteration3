package Controller.AI_Controller.VisualCortex.VisualInformation;

import Model.Entity;

import java.awt.*;
import java.util.HashMap;

/**
 * Created by aseber on 4/6/16.
 */
public class VisualInformation {

    HashMap<Point, Entity> entityVisualInformation = new HashMap<>();
//    HashMap<Point, Items> itemVIsualInformation = new HashMap<>();

    public void purge() {

        entityVisualInformation.clear();
//        itemVisualInformation.clear();

    }

}
