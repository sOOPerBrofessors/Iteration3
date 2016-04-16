package Model.Skills;

import Model.Entity.Character.Avatar;
import Model.Map.Map;
import Model.Map.Orientation;
import Utilities.ErrorLevel;
import Utilities.MessageHandler;
import Utilities.PersonFilter;
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
    private double timePerformed;
    private double remainingCoolDownTime;
    protected int manaCost;

    protected Avatar avatar;

    public Skill (Avatar avatar) {
        this.avatar = avatar;
        level = 1;
    }

    public void levelUp() {
        if (level < 10) {// and avatar have enough skill point
            level += 1;
            //TODO: also modify CD, manaCost, substact skillPoint, etc
        }
    }

    //subclass need to override either of the two
    public abstract void execute();

    public void enforceManaCost() {
        avatar.manaEffect( -manaCost );
    }
    protected void setTimePerformed() {
        timePerformed = System.currentTimeMillis();
        remainingCoolDownTime = coolDownTime;
    }

    public void tick() {
        //TODO: this is dumb implementation
        double timePassed = (System.currentTimeMillis() - timePerformed) / 1000;
        remainingCoolDownTime = coolDownTime - timePassed;
        if (remainingCoolDownTime <= 0) {
            remainingCoolDownTime = 0.0;
        }
    }

    protected boolean checkCD() {
        tick();
        return remainingCoolDownTime == 0.0;
    }

    protected boolean checkMana() { return avatar.getMana() >= manaCost; }

    //chance of success is 0.5 when skill level is 1, and reaches 1 when skill level is 5
    protected boolean checkPerformanceSuccess() {
        Random random = new Random();
        //it's a number increments from 0.5 to 1 with level
        double chanceOfSuccess = 0.5 + (double) level / 10;
        //generate a number (from 0 to 1) for comparison
        double compareNumber = random.nextDouble();

        return compareNumber <= chanceOfSuccess;
    }

    protected boolean checkAll() {
        if (!checkCD()) {
            MessageHandler.println(name + "Not cooled down, remaining CD: " + getRemainingCoolDownTime(), ErrorLevel.NOTICE, PersonFilter.ANDY);
            return false;
        }
        else if (!checkMana()) {
            MessageHandler.println(name + "Not enough mana", ErrorLevel.NOTICE, PersonFilter.ANDY);
            return false;
        }
        else if (!checkPerformanceSuccess()) {
            enforceManaCost();
            setTimePerformed();
            MessageHandler.println(name + "Fail" + getRemainingCoolDownTime(), ErrorLevel.NOTICE, PersonFilter.ANDY);
            return false;
        }
        else {
            return true;
        }
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
