package Controller.Controllers;

import Controller.Controller;
import Controller.ControllerManager;
import Controller.ControllerUtility.Command;
import Utilities.Settings;
import View.MenuViews.SkillsView;
import View.ViewUtilities.Panels.GamePanel;


public class SkillsController extends Controller { //NOT VERY OOPY

    private static SkillsView skillsView;

    public SkillsController(ControllerManager controllerManager){
        super(controllerManager);
        initCommands();
    }
    public static void setSkillsView(GamePanel gamePanel){ skillsView = gamePanel.getSkillsView(); }

    @Override
    public void keyPress(Integer key){
        if(commands.containsKey(key)) {
            commands.get(key).execute();
        }
    }

    private void initCommands(){

        commands.put(Settings.UP_ARROW, new Command() {
            @Override
            public void execute() {
                skillsView.selectUp();
            }
        });

        commands.put(Settings.DOWN_ARROW, new Command() {
            @Override
            public void execute() {
                skillsView.selectDown();
            }
        });


        // interact key press
        commands.put(Settings.ENTER, new Command() {
            @Override
            public void execute() {
                skillsView.select();
            }
        });

        // Exit InventoryView
        commands.put(Settings.ESC, new Command() {
            @Override
            public void execute() {
                controllerManager.switchGamePlay();
            }
        });

        // Exit InventoryView
        commands.put(Settings.SKILLS, new Command() {
            @Override
            public void execute() {
                controllerManager.switchGamePlay();
            }
        });
    }
}
