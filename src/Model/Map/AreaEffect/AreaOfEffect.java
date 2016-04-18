package Model.Map.AreaEffect;

import Model.Entity.Character.Character;
import Utilities.Visitor.AOEVisitable;

/**
 * Created by dyeung on 4/14/16.
 */
public abstract class AreaOfEffect implements AOEVisitable{
    final int value;
    private boolean detected = false;
    float alpha = 1f;
    boolean active = true;
    AreaOfEffect(int value){
        this.value = value;
    }
    public abstract void onInteract(Character character);

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public void setActive() {
        active = false;
    }

    public boolean getActive() {
        return active;
    }

    public float getAlpha() {
        return alpha;
    }

    public void setDetected() {
        detected = true;
    }

    public boolean getDetected() {
        return detected;
    }
}
