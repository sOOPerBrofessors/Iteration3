package Controller.Controllers;

import Controller.Controller;
import Controller.ControllerManager;
import Controller.ControllerUtility.Command;
import Model.Skills.Skill;
import Utilities.Settings;
import View.InventoryView.InventoryView;
import View.ViewManager;
import View.ViewUtilities.Panels.GamePanel;

/**
 * Created by AndyZhu on 16/4/2016.
 *
 * For upgrading skills
 */
public class SkillController extends Controller {

    public SkillController(ControllerManager controllerManager) {
        super(controllerManager);
    }

    @Override
    public void keyPress(Integer key) {
        if(commands.containsKey(key)) {
            commands.get(key).execute();
        }
    }

    private void initCommands(){
    }


}