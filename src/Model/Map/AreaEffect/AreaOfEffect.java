package Model.Map.AreaEffect;

import Model.Entity.Character.Character;

/**
 * Created by dyeung on 4/14/16.
 */
public abstract class AreaOfEffect{
    protected int value;
    public AreaOfEffect(int value){
        this.value = value;
    }
    public abstract void onInteract(Character character);
}
