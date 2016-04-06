package Model.State;

import Model.Entity.Character.Avatar;

/**
 * Created by Wimberley on 4/6/16.
 */
public abstract class State {
    // player which is a part of every state
    protected Avatar player;

    // tick method for every state
    protected void tick(){};

    public void setPlayer(Avatar player) {
        this.player = player;
    }
}
