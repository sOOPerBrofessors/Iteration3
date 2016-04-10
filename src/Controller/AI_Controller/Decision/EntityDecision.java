package Controller.AI_Controller.Decision;

import Controller.AI_Controller.Interest.EntityInterest;
import Model.Entity.Entity;

/**
 * Created by aseber on 4/9/16.
 */
public class EntityDecision extends Decision {

    public EntityDecision(EntityInterest interest, Entity target) {

        interest.setTarget(target);
        super.setInterest(interest);

    }

}
