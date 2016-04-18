package Model.Skills.SkillsWithDuration;

import Model.Entity.Character.Avatar;
import Model.Map.Map;
import Utilities.GameMessageQueue;
import Utilities.Timer.BoonTimer;

/**
 * Created by AndyZhu on 13/4/2016.
 *
 * magic that heals, temporarily grants (partial) immunities and defensive bonuses, improves stats, and other beneficial things.
 */
public class Boon extends SkillWithDuration{

    private int modifier;
    private boolean booning = false;

    public Boon (Avatar avatar) {
        super (avatar);
        name = "Boon";
        manaCost = 1;
        coolDownTime = 1;
    }


    @Override
    public void execute (Map map) {
        if (allConditionChecked()) {
            if (!booning) {
                boon();
                enforceManaCost();
                setTimePerformed();
            }
        }
    }

    private void boon() {
        calculateDuration();
        modifier = level;
        new BoonTimer(durationInMillis, this).start();
    }

    public void activateBoon() {
        avatar.healthEffect(modifier);
        avatar.manaEffect(modifier);
        avatar.intellectEffect(modifier);
        avatar.defensiveRatingEffect(modifier);
        avatar.movementEffect(10);
        avatar.setAlpha(0.6f);
        booning = true;
        GameMessageQueue.push("Boon activated!");
    }

    public void endBoon() {
        avatar.intellectEffect(-modifier);
        avatar.defensiveRatingEffect(-modifier);
        avatar.movementEffect(-10);
        avatar.setAlpha(1f);
        booning = false;
        GameMessageQueue.push("Boon ended!");
    }
}
