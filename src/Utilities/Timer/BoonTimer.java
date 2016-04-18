package Utilities.Timer;

import Model.Skills.SkillsWithDuration.Boon;
import Model.Skills.SkillsWithDuration.Creep;

/**
 * Created by AndyZhu on 17/4/2016.
 */
public class BoonTimer extends TimedEvent{
    public BoonTimer(int durationMilli, Boon boon) {
        super(durationMilli,
                boon::activateBoon,
                e -> boon.endBoon()
        );
    } // end constructor
}
