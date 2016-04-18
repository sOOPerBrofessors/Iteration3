package Utilities.Timer;

import Model.Skills.SkillsWithDuration.Creep;

/**
 * Created by AndyZhu on 17/4/2016.
 */
public class CreepTimer extends TimedEvent{
    public CreepTimer(int durationMilli, Creep creep) {
        super(durationMilli,
                creep::activateCreep,
                e -> creep.endCreep()
        );
    } // end constructor
}
