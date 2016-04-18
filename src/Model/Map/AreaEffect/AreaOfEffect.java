package Model.Map.AreaEffect;

import Model.Entity.Character.Character;
import Utilities.Visitor.AOEVisitable;
import Utilities.Visitor.AOEVisitor;
import View.MapView.AOEView.AreaOfEffectView;

/**
 * Created by dyeung on 4/14/16.
 */
public abstract class AreaOfEffect implements AOEVisitable{
    protected int value;
    protected boolean detected = false;
    protected float alpha = 1f;
    protected boolean active = true;
    public AreaOfEffect(int value){
        this.value = value;
    }
    public abstract void onInteract(Character character);

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public void setActive(boolean bool) {
        active = bool;
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
