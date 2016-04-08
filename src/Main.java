import Controller.ControllerManager;
import Controller.Controllers.GamePlayController;
import LoadSave.LoadFactionRelations;
import LoadSave.LoadFactions;
import Model.Model;
import Model.State.StateManager;
import Model.State.States.ActiveGameState;
import View.View;
import View.ViewUtilities.Panels.GamePanel;
import View.ViewManager;

import View.ViewManager;

import Model.State.GameState;
import Utilities.GameLoader;

import Controller.ControllerManager;
import Controller.GameController;
import View.ViewUtilities.MainPanel;

import java.awt.*;



/**
 * Created by Wimberley on 3/23/16.
 */
public class Main {

    public static void main(String[] args) {
        LoadSave.LoadData.load("data/factions.xml", new LoadFactions());
        LoadSave.LoadData.load("data/faction_relationships.xml", new LoadFactionRelations());

        // creates all components that need to know of each other
        Model gameLoop = new Model();
        View view = new View();

        initialize(gameLoop, view);

//        EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//
//                //Mike's stuff that I moved over
//                Model game = new Model();
//                ViewManager view = new ViewManager();
//
//                //Used to test the area view
//                GameLoader gL = new GameLoader();
//                GameState gs = gL.getGameState();
//                //StateManager state = new StateManager();
//                ControllerManager inputManager = new ControllerManager();
//                inputManager.setActiveController(new GameController(inputManager,gs));
//
//
//
//                MainPanel mainPanel = new MainPanel();
//                GameView gv = new GameView(gs);
//
//                mainPanel.addView(gv);
//                mainPanel.addKeyListener(inputManager);
//
//                mainPanel.setVisible(true);
//                mainPanel.start();
//            }
//        });

        gameLoop.start();
        view.start();
    }

    private static void initialize(Model model, View view) {

        // initialize view manager and get necessary views
        ViewManager viewManager = view.getViewManager();
        GamePanel gamePanel = viewManager.getGamePanel();

        //Use the GAMELOADER
        GameLoader gameLoader = new GameLoader();

        // initialize state manager and get necessary states
        StateManager stateManager = model.getStateManager();
        ActiveGameState activeGameState = gameLoader.getActiveGameState();

        stateManager.setActiveGameState(activeGameState);
        gamePanel.setAreaViewport(activeGameState);

        // initialize controller manager and get necessary controllers
        ControllerManager controller = new ControllerManager();
        view.setControllerManager(controller);

        GamePlayController gamePlayController = controller.getGamePlayController();

        // set necessary things for views
        viewManager.setControllerManager(controller);

        // set necessary things for states
        stateManager.setControllerManager(controller);
        //Why does the active game state need to know the controller?
        activeGameState.setActiveGameController(gamePlayController);

        // set necessary things for controllers
        controller.setStateManager(stateManager);
        controller.setViewManager(viewManager);
        gamePlayController.setState(activeGameState);
        gamePlayController.setGamePanel(gamePanel);
        gamePlayController.setState(activeGameState);
    }
}
