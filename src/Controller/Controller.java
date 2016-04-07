package Controller;

import Controller.ControllerUtility.Command;

import java.util.HashMap;
import java.awt.event.KeyEvent;

/**
 * Created by Wimberley on 3/23/16.
 */
public abstract class Controller {

    // common attributes to all controllers
    protected HashMap<Integer, Command> commands;
    protected ControllerManager controllerManager;

    public Controller(ControllerManager controllerManager){
        this.controllerManager = controllerManager;
    }

    public abstract void keyPress(KeyEvent e);


}
