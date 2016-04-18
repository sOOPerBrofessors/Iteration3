package Controller;

import Controller.ControllerUtility.Command;

import java.util.HashMap;

/**
 * Created by Wimberley on 3/23/16.
 */
public abstract class Controller {

    // common attributes and operations to all controllers
    protected final HashMap<Integer, Command> commands;
    protected final ControllerManager controllerManager;

    protected Controller(ControllerManager controllerManager){
        this.controllerManager = controllerManager;
        commands = new HashMap<>();
    }

    public abstract void keyPress(Integer key);
}