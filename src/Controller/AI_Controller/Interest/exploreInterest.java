package Controller.AI_Controller.Interest;

import Controller.AI_Controller.VisualCortex.VisualInformation.VisualInformation;

/**
 * Created by aseber on 4/8/16.
 */
public class ExploreInterest implements Interest {

    public boolean isValid(VisualInformation visualInformation) {

        return false;

    }

    public String getName() {

        return "ExploreInterest";

    }

}