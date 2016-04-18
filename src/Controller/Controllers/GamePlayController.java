package Controller.Controllers;

import Controller.Controller;
import Controller.ControllerManager;
import Controller.ControllerUtility.Command;
import Model.State.GameState.ActiveGameState;
import Utilities.GameLoaderSaver.GameSaver;
import Utilities.Timer.ObservationTimer;
import Utilities.Settings;
import View.ViewUtilities.Panels.GamePanel;

import java.awt.event.KeyEvent;

/**
 * Created by Wimberley on 4/6/16.
 */
public class GamePlayController extends Controller{

    private ActiveGameState state;
    private GamePanel gamePanel;

    public GamePlayController(ControllerManager controllerManager){
        super(controllerManager);
    }

    @Override
    public void keyPress(Integer key){
        if(commands.containsKey(key)) {
            commands.get(key).execute();
        }
    } // end keyPress

    private void initCommands(){

        // up key press
        commands.put(Settings.UP, () -> state.movePlayerN());

        commands.put(Settings.UP_ARROW, () -> state.movePlayerN());

        // up right key press
        commands.put(Settings.UP_RIGHT, () -> state.movePlayerNE());

        commands.put(Settings.RIGHT_ARROW, () -> state.movePlayerNE());

        // down right key press
        commands.put(Settings.DOWN_RIGHT, () -> state.movePlayerSE());

        // down key press
        commands.put(Settings.DOWN, () -> state.movePlayerS());

        commands.put(Settings.DOWN_ARROW, () -> state.movePlayerS());

        // down left key press
        commands.put(Settings.DOWN_LEFT, () -> state.movePlayerSW());

        // up left key press
        commands.put(Settings.UP_LEFT, () -> state.movePlayerNW());

        commands.put(Settings.LEFT_ARROW, () -> state.movePlayerNW());

        // attack key press
        commands.put(Settings.ATTACK, () -> {
            state.playerAttack();
            //state.startCombatTimer();
        });

        // interact key press
        commands.put(Settings.INTERACT, () -> state.playerInteract());

        // skill one key press
        commands.put(Settings.ONE, new Command() {
            @Override
            public void execute() {
                state.playerExecuteSkill(0);
            }
        });

        // skill 2 key press
        commands.put(Settings.TWO, () -> new ObservationTimer(state.playerObservationSkill()).start());

        // skill 3 key press
        commands.put(Settings.THREE, () -> state.playerExecuteSkill(2));

        // skill 4 key press
        commands.put(Settings.FOUR, () -> state.playerExecuteSkill(3));

        // skill 5 key press
        commands.put(Settings.FIVE, () -> state.playerExecuteSkill(4));

        // skill 6 key press
        commands.put(Settings.SIX, () -> state.playerExecuteSkill(5));

        // skill 7 key press
        commands.put(Settings.SEVEN, () -> state.playerExecuteSkill(6));

        // inventory key press
        commands.put(Settings.INVENTORY, () -> controllerManager.setInventoryState());

        // Stats key press
        commands.put(Settings.STATS, () -> controllerManager.setStatsState());

        // PAUSE game key press
        commands.put(Settings.ESC, () -> controllerManager.setPauseState());

        // Skills key Press
        commands.put(Settings.SKILLS, () -> controllerManager.setSkillsState());

        // settings key press
        commands.put(Settings.SETTINGS, () -> controllerManager.setSettingsState());

        commands.put(Settings.TEST_KEY, () -> {
            /*
            switch((int)(Math.random()*5)+1){
                case 1:
                    state.getAvatar().experienceEffect((int)(Math.random()*5));
                    break;
                case 2:
                    state.getAvatar().healthEffect((int)(Math.random()*3));
                    break;
                case 3:
                    state.getAvatar().manaEffect((int)(Math.random()*3));
                    break;
                case 4:
                    state.getAvatar().healthEffect(-1*((int)(Math.random()*3)));
                    break;
                case 5:
                    state.getAvatar().manaEffect(-1*((int)(Math.random()*3)));
                    break;
            }*/
            state.getAvatar().healthEffect(-1);
            //state.getAvatar().healthEffect((int)(Math.random()*3)+1);
            //state.getAvatar().manaEffect(10000);
        });

    }

    public void setState(ActiveGameState state) {
        this.state = state;
        initCommands();
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
}