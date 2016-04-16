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
    public AreaOfEffect(int value){
        this.value = value;
    }
    public abstract void onInteract(Character character);

}
