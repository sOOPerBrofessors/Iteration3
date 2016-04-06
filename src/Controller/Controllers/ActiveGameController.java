package Controller.Controllers;

import Controller.Controller;
import Controller.ControllerManager;
import Controller.ControllerUtility.Command;
import Model.State.States.ActiveGameState;
import Utilities.Settings;

import java.awt.event.KeyEvent;

/**
 * Created by Wimberley on 4/6/16.
 */
public class ActiveGameController extends Controller{

    private ActiveGameState state;

    public ActiveGameController(ControllerManager controllerManager, ActiveGameState state){
        super(controllerManager);
        this.state = state;
        initCommands();
    }

    public void keyPress(KeyEvent key){
        commands.get(key).execute();
    }

    private void initCommands(){

        // up key press
        commands.put(Settings.UP, new Command() {
            @Override
            public void execute() {
                state.movePlayerN();
            }
        });

        // up right key press
        commands.put(Settings.UP_RIGHT, new Command() {
            @Override
            public void execute() {
                state.movePlayerNE();
            }
        });

        // down right key press
        commands.put(Settings.DOWN_RIGHT, new Command() {
            @Override
            public void execute() {
                state.movePlayerSE();
            }
        });

        // down key press
        commands.put(Settings.DOWN, new Command() {
            @Override
            public void execute() {
                state.movePlayerS();
            }
        });

        // down left key press
        commands.put(Settings.DOWN_LEFT, new Command() {
            @Override
            public void execute() {
                state.movePlayerSW();
            }
        });

        // up left key press
        commands.put(Settings.UP_LEFT, new Command() {
            @Override
            public void execute() {
                state.movePlayerNW();
            }
        });

        // attack key press
        commands.put(Settings.ATTACK, new Command() {
            @Override
            public void execute() {
                state.playerAttack();
            }
        });

        // interact key press
        commands.put(Settings.INTERACT, new Command() {
            @Override
            public void execute() {
                state.playerInteract();
            }
        });

        // skill one key press
        commands.put(Settings.ONE, new Command() {
            @Override
            public void execute() {
                state.playerFirstSkill();
            }
        });

        // skill two key press
        commands.put(Settings.TWO, new Command() {
            @Override
            public void execute() {
                state.playerSecondSkill();
            }
        });

        // inventory key press
        commands.put(Settings.INVENTORY, new Command() {
            @Override
            public void execute() {
                controllerManager.inventory();
            }
        });

        // equipment key press
        commands.put(Settings.EQUIP, new Command() {
            @Override
            public void execute() {
                controllerManager.equipment();
            }
        });

        // pause game key press
        commands.put(Settings.ESC, new Command() {
            @Override
            public void execute() {
                controllerManager.pause();
            }
        });

        // skills key press
        commands.put(Settings.SKILLS, new Command() {
            @Override
            public void execute() {
                controllerManager.skills();
            }
        });
    }
}
