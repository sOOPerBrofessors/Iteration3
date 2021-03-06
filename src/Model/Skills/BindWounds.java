package Model.Skills;

import Model.Entity.Character.Avatar;
import Model.State.GameState.ActiveGameState;
import Utilities.GameMessageQueue;

/**
 * Created by AndyZhu on 13/4/2016.
 */
public class BindWounds extends Skill{

    public BindWounds(Avatar avatar) {
        super(avatar);
        name = "Bind wounds";
        manaCost = 1;
        coolDownTime = 2;
    }

    @Override
    public void execute(ActiveGameState activeGameState) {
        if (allConditionChecked()) {
            performBindWounds();

            enforceManaCost();
            setTimePerformed();

            GameMessageQueue.push(name + " Success!");

        }
    }

    private void performBindWounds() {
        int healAmt = avatar.getStrength() + level;
        avatar.healthEffect(healAmt);
    }
}
