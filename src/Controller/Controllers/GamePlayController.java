package Controller.Controllers;

import Controller.Controller;
import Controller.ControllerManager;
import Controller.ControllerUtility.Command;
import Model.State.GameState.ActiveGameState;
import Utilities.Settings;
import View.ViewUtilities.Panels.GamePanel;

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
    }

    private void initCommands(){

        // up key press
        commands.put(Settings.UP, new Command() {
            @Override
            public void execute() {
                state.movePlayerN();
            }
        });

        commands.put(Settings.UP_ARROW, new Command() {
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

        commands.put(Settings.RIGHT_ARROW, new Command() {
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

        commands.put(Settings.DOWN_ARROW, new Command() {
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

        commands.put(Settings.LEFT_ARROW, new Command() {
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
                state.startCombatTimer();
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
                controllerManager.setInventoryState();
            }
        });

        // Stats key press
        commands.put(Settings.STATS, new Command() {
            @Override
            public void execute() {
                controllerManager.setStatsState();
            }
        });

        // equipment key press
        commands.put(Settings.EQUIP, new Command() {
            @Override
            public void execute() {

            }
        });

        // pause game key press
        commands.put(Settings.ESC, new Command() {
            @Override
            public void execute() {
                controllerManager.setPauseState();
            }
        });

        // skills key press
        commands.put(Settings.SKILLS, new Command() {
            @Override
            public void execute() {
                controllerManager.setSkillsState();
            }
        });

        commands.put(Settings.TEST_KEY, new Command() {
            @Override
            public void execute() {
                switch((int)(Math.random()*5)+1){
                    case 1:
                        state.getAvatar().experienceEffect((int)(Math.random()*5)+1);
                        break;
                    case 2:
                        state.getAvatar().healthEffect((int)(Math.random()*3)+1);
                        break;
                    case 3:
                        state.getAvatar().manaEffect((int)(Math.random()*3)+1);
                        break;
                    case 4:
                        state.getAvatar().healthEffect(-1*((int)(Math.random()*3)+1));
                        break;
                    case 5:
                        state.getAvatar().manaEffect(-1*((int)(Math.random()*3)+1));
                        break;
                }
            }
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
