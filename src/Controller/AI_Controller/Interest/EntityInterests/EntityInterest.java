package Controller.AI_Controller.Interest.EntityInterests;

import Controller.AI_Controller.Interest.Interest;
import Model.Entity.Entity;

/**
 * Created by aseber on 4/9/16.
 */
public abstract class EntityInterest extends Interest {

    Entity targetEntity;

    public void setTarget(Entity targetEntity) {

        this.targetEntity = targetEntity;

    }

}
