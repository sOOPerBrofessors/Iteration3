package Controller.AI_Controller.Interest;

import Controller.AI_Controller.VisualCortex.VisualInformation.VisualInformation;

/**
 * Created by aseber on 4/8/16.
 */
public class TalkInterest implements Interest {

    static {

        Interest interest = new TalkInterest();
        InterestFactory.addInterest(interest.getName(), interest);

    }

    public boolean isValid(VisualInformation visualInformation) {

        return false;

    }

    public String getName() {

        return "TalkInterest";

    }

}
