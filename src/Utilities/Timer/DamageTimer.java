package Utilities.Timer;

import Controller.ControllerUtility.Command;

import java.awt.event.ActionListener;

/**
 * Created by broskj on 4/17/16.
 */
public class DamageTimer extends TimedEvent {

    public DamageTimer(Command beforeTask, ActionListener afterTask) {
        super(1500, beforeTask, afterTask);
    }
}
