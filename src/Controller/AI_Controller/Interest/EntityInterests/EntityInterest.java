package Controller.AI_Controller.Interest.EntityInterests;

import Controller.AI_Controller.Interest.Interest;
import Model.Entity.Character.NPC.NPC;
import Model.Entity.Entity;
import Model.Map.Orientation;

import java.util.ArrayList;

/**
 * Created by aseber on 4/9/16.
 */
public abstract class EntityInterest extends Interest {

    private Entity targetEntity;

    public final void setTarget(Entity targetEntity) {

        this.targetEntity = targetEntity;

    }

    protected final Entity getTargetEntity() {

        return targetEntity;

    }

    protected ArrayList<Orientation> computePathToTarget(NPC npc) {

        return npc.getController().findPath(npc, getTargetEntity().getLocation());

    }

    public final InterestType getType() {

        return InterestType.ENTITY;

    }

}
