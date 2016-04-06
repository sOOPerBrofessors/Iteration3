package Controller;

import Controller.ControllerUtility.Command;
import Model.State.StateManager;
import View.ViewManager;

import java.awt.event.KeyEvent;
import java.util.HashMap;

/**
 * Created by Wimberley on 3/23/16.
 */
public abstract class Controller {

    // common attributes to all controllers
    protected HashMap<KeyEvent, Command> commands;
    protected ViewManager viewManager;
    protected StateManager stateManager;
}
