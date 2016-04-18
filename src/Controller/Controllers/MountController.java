package Controller.Controllers;

import Controller.Controller;
import Controller.ControllerManager;
import Controller.ControllerUtility.Command;
import Model.State.GameState.MountGameState;
import Utilities.Settings;

import java.awt.event.KeyEvent;


/**
 * Created by Wimberley on 4/18/16.
 */
public class MountController extends Controller {

    private MountGameState state;

    public MountController(ControllerManager controllerManager){
        super(controllerManager);
    }

    @Override
    public void keyPress(Integer key) {
        if(commands.containsKey(key)) {
            commands.get(key).execute();
        }
    }

    private void initCommands(){

        // up key press
        commands.put(Settings.UP, () -> state.moveMountN());

        commands.put(Settings.UP_ARROW, () -> state.moveMountN());

        // up right key press
        commands.put(Settings.UP_RIGHT, () -> state.moveMountNE());

        commands.put(Settings.RIGHT_ARROW, () -> state.moveMountNE());

        // down right key press
        commands.put(Settings.DOWN_RIGHT, () -> state.moveMountSE());

        // down key press
        commands.put(Settings.DOWN, () -> state.moveMountS());

        commands.put(Settings.DOWN_ARROW, () -> state.moveMountS());

        // down left key press
        commands.put(Settings.DOWN_LEFT, () -> state.moveMountSW());

        // up left key press
        commands.put(Settings.UP_LEFT, () -> state.moveMountNW());

        commands.put(Settings.LEFT_ARROW, () -> state.moveMountNW());

        // attack key press
        commands.put(Settings.ATTACK, () -> {
            state.playerAttack();
            state.startCombatTimer();
        });

        // dismount
        commands.put(Settings.INTERACT, new Command() {
            @Override
            public void execute() {
                state.dismount();
            }
        });

        // levitate mount
       commands.put(KeyEvent.VK_L, new Command() {
            @Override
            public void execute() {
                state.levitate();
            }
        });

    }

    public void activeGame(){
        controllerManager.switchGamePlay();
    }

    public void setState(MountGameState state) {
        this.state = state;
        initCommands();
    }
}