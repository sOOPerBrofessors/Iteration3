package Utilities;

import Controller.ControllerUtility.Command;
import Model.Skills.RangedSkills.ObservationInfo;
import Utilities.Timer.TimedEvent;
import View.SkillView.ObservedNPC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by AndyZhu on 16/4/2016.
 */
public class ObservationTimer extends TimedEvent {
    public ObservationTimer(ObservationInfo observationInfo) {
        super(2000, new Command() {
            @Override
            public void execute() {
                ObservedNPC.setObservationMsg(observationInfo);
            }
        }, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ObservedNPC.resetObservationMsg();
            }
        });
    } // end constructor
}
