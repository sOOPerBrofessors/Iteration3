package Utilities.Timer;

import Model.Skills.RangedSkills.ObservationInfo;
import View.SkillView.ObservedNPC;
/**
 * Created by AndyZhu on 16/4/2016.
 * For Observation view
 */
public class ObservationTimer extends TimedEvent {
    public ObservationTimer(ObservationInfo observationInfo) {
        super(2000,
                () -> ObservedNPC.setObservationMsg(observationInfo),
                e -> ObservedNPC.resetObservationMsg());
    } // end constructor
}
