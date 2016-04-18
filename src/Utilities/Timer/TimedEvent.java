package Utilities.Timer;

import Controller.ControllerUtility.Command;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by broskj on 4/15/16.
 *
 * abstract class to handle timed events.  Takes in a time duration, a before task, and an after task.
 *
 * Before task is executed before starting the timer, and after task is executed after.
 *
 * Time can be reset if start() is called while already running.
 */
public class TimedEvent {
    private final Timer t;
    private final Command beforeTask;
    private final ActionListener afterTask;

    public TimedEvent(int time, Command beforeTask, ActionListener afterTask) {
        t = new Timer(time, afterTask);
        t.setRepeats(false);
        this.beforeTask = beforeTask;
        this.afterTask = afterTask;
    } // end constructor

    public void start() {
        if(t.isRunning()) {
            t.restart();
        }
        else {
            beforeTask.execute();
            t.start();
        }
    } // end start

    public boolean isRunning() {
        return t.isRunning();
    } // end isRunning
} // end class TimedEvent
