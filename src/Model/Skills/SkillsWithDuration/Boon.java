package Model.Skills.SkillsWithDuration;

import Model.Entity.Character.Avatar;
import Model.Map.Map;
/**
 * Created by AndyZhu on 13/4/2016.
 *
 * magic that heals, temporarily grants (partial) immunities and defensive bonuses, improves stats, and other beneficial things.
 */
public class Boon extends SkillWithDuration{

    private int modifier;

    public Boon (Avatar avatar) {
        super (avatar);
        name = "Boon";
        manaCost = 1;
        coolDownTime = 1;
    }


    @Override
    public void execute (Map map) {
        if (allConditionChecked()) {
            boon();
        }
    }

    private void boon() {
        modifier = level;

    }

    public void activateBoon() {

    }

    public void endBoon() {

    }
}
