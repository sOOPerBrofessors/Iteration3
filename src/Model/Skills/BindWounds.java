package Model.Skills;

import Model.Entity.Character.Avatar;
import Model.Map.Map;
import Utilities.ErrorLevel;
import Utilities.GameMessageQueue;
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
    public void execute(Map map) {
        if (checkAll()) {
            performBindWounds();

            enforceManaCost();
            setTimePerformed();

            GameMessageQueue.push(name + " Success!");

        }
    }

    private void performBindWounds() {
        healAmt = avatar.getStrength() + level;
        avatar.healthEffect(healAmt);
    }
}
