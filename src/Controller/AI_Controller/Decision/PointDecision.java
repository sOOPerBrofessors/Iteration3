package Controller.AI_Controller.Decision;

import Controller.AI_Controller.Interest.PointInterest;

import java.awt.*;

/**
 * Created by aseber on 4/9/16.
 */
public class PointDecision extends Decision {

    public PointDecision(PointInterest interest, Point target) {

        super.setInterest(interest);
        setPointOfInterest(target);

    }

}
