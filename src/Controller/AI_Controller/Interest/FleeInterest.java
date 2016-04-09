package Controller.AI_Controller.Interest;

import Controller.AI_Controller.VisualCortex.VisualInformation.VisualInformation;

/**
 * Created by aseber on 4/9/16.
 */
public class FleeInterest implements Interest {

    public boolean isValid(VisualInformation visualInformation) {

        return false;

    }

    public String getName() {

        return "FleeInterest";

    }

}
