package Model.State;

import Model.Entity.Character.Avatar;
import Utilities.Tickable;

/**
 * Created by Wimberley on 4/6/16.
 */
public abstract class State implements Tickable{
    // player which is a part of every state
    protected Avatar player;

    // tick method for every state
    @Override
    public abstract void tick();

    public void setPlayer(Avatar player) {
        this.player = player;
    }
}
