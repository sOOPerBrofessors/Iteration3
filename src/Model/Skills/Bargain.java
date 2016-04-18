package Model.Skills;

import Model.Entity.Character.Avatar;

/**
 * Created by AndyZhu on 13/4/2016.
 *
 * Player can choose whether to use bargain when starting trading with NPC
 * You will get a double by executing this skill
 */
public class Bargain extends Skill{
    public Bargain(Avatar avatar) {
        super(avatar);
        name = "Bargain";
        manaCost = 1;
        coolDownTime = 2;
    }

    public double executeBargain() {
        double discount = 1;
        if (allConditionChecked()) {
            enforceManaCost();
            setTimePerformed();
            return bargain();
        }
        else {
            return discount; //this is just 1, so no discount
        }
    }

    private double bargain() {
        double discount;
        discount = 1 - (double) level / 20;
        return discount;
    }
}
