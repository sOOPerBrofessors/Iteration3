package Model.Skills;

import Model.Entity.Character.Avatar;
import com.sun.org.glassfish.external.statistics.Stats;

import java.util.Random;

/**
 * Created by AndyZhu on 5/4/2016.
 *
 * All skills are active. Skill is the parent of all kinds of skills.
 */
public abstract class Skill { //TODO: skills should also be ticked if we want to display remaining CD
    //TODO: complete everything after avatar is done
    protected int level; //level range: [1, 10]
    protected String name;
    protected double coolDownTime;
    protected double timePerformed;
    protected double remainingCoolDownTime;
    protected int manaCost;

    protected Avatar avatar;

    public Skill (Avatar avatar) {
        this.avatar = avatar;
    }

    public void levelUp() {
        if (level < 10) {// and avatar have enough skill point
            level += 1;
            //TODO: also modify CD, manaCost, etc
        }
    }

    public abstract void execute();

    public void enforceManaCost() {
        avatar.manaEffect( -manaCost );
    }

    public void tick() {
        //TODO: this is dumb implementation
        remainingCoolDownTime = (System.currentTimeMillis() - timePerformed) / 1000;
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

    protected void setTimePerformed() {
        timePerformed = System.currentTimeMillis();
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
