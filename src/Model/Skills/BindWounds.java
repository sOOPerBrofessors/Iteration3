package Model.Skills;

import Model.Entity.Character.Avatar;

/**
 * Created by AndyZhu on 13/4/2016.
 */
public class BindWounds extends Skill{

    public BindWounds(Avatar avatar) {
        super(avatar);
        level = 1;
        name = "Bind wounds";
        manaCost = 5;
        coolDownTime = 5;
    }

    @Override
    public void execute() {

    }
}
