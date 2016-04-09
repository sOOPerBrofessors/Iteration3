package Controller.AI_Controller.Interest;

import Controller.AI_Controller.VisualCortex.VisualInformation.VisualInformation;

/**
 * Created by aseber on 4/6/16.
 */
public interface Interest {

    boolean isValid(VisualInformation visualInformation);

    public String getName();

}