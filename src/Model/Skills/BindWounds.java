package Model.Skills;

import Model.Entity.Character.Avatar;
import Utilities.ErrorLevel;
import Utilities.MessageHandler;
import Utilities.PersonFilter;

/**
 * Created by AndyZhu on 13/4/2016.
 */
public class BindWounds extends Skill{

    private int healAmt;

    public BindWounds(Avatar avatar) {
        super(avatar);
        name = "Bind wounds";
        manaCost = 1;
        coolDownTime = 2;
    }

    @Override
    public void execute() {
        if (checkAll()) {
            performBindWounds();

            enforceManaCost();
            setTimePerformed();

            MessageHandler.println(name + "success! remaining CD:" + getRemainingCoolDownTime(), ErrorLevel.NOTICE, PersonFilter.ANDY);

        }
        else {
            MessageHandler.println(name + "Failed for some reason", ErrorLevel.NOTICE, PersonFilter.ANDY);
        }
    }

    private void performBindWounds() {
        healAmt = avatar.getStrength() + level;
        avatar.healthEffect(healAmt);
    }
}
