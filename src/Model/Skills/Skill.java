package Model.Skills;

import java.util.Random;

/**
 * Created by AndyZhu on 5/4/2016.
 */
public abstract class Skill { //TODO: skills should also be ticked if we want to display remaining CD
    //TODO: complete everything after avatar is done
    private int level; //level range: [1, 10]
    private String name;
    private double coolDownTime;
    private double timePerformed;
    private double remainingCoolDownTime;
    private double manaCost;


    /* protected Avatar avatar;

    public Skill (Avatar avatar) {
        this.avatar = avatar;
    }*/

    public void levelUp() {
        if (level < 10) {// and avatar have enough skill point
            level += 1;
            //TODO: also modify CD, manaCost, etc
        }
    }

    public abstract void executeSkill();

    public void enforceManaCost() {
        /*
        avatar.modifyMana( -manaCost );
         */
    }

    public void tick() {
        //TODO: this is dumb implementation
        coolDownTime = (System.currentTimeMillis() - timePerformed) / 1000;
    }

    protected boolean checkCD() {
        return remainingCoolDownTime == 0.0;
    }

    protected boolean checkPerformanceSuccess() {
        Random random = new Random();
        //it's a number increments from 0.5 to 1 with level
        double chanceOfSuccess = 0.5 + (double) level / 10;
        //generate a number (from 0 to 1) for comparison
        double compareNumber = random.nextDouble();

        return compareNumber <= chanceOfSuccess;
    }

    // accessors
    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public double getCoolDownTime() {
        return coolDownTime;
    }

    public double getRemainingCoolDownTime() {
        return remainingCoolDownTime;
    }
}
