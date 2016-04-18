package Controller.AI_Controller.Interest.EntityInterests;

import Controller.AI_Controller.Interest.Interest;
import Controller.AI_Controller.MotorCortex.MotorCortexMemoryInterface;
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

    final Entity getTargetEntity() {

        return targetEntity;

    }

    ArrayList<Orientation> computePathToTarget(MotorCortexMemoryInterface memoryInterface) {

        NPC npc = memoryInterface.getNPC();
        return npc.getController().findPath(npc, getTargetEntity().getLocation());

    }

    public final InterestType getType() {

        return InterestType.ENTITY;

    }

}
