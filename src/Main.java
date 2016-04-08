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

        gameLoop.start();
        view.start();
    }

    private static void initialize(Model model, View view) {

        // initialize view manager and get necessary views
        ViewManager viewManager = view.getViewManager();
        GamePanel gamePanel = viewManager.getGamePanel();

        // initialize state manager and get necessary states
        StateManager stateManager = model.getStateManager();
        ActiveGameState activeGameState = stateManager.getActiveGameState();

        // initialize controller manager and get necessary controllers
        ControllerManager controller = new ControllerManager();
        GamePlayController gamePlayController = controller.getGamePlayController();

        // set necessary things for views
        viewManager.setControllerManager(controller);
        gamePanel.setAreaViewport(activeGameState);

        // set necessary things for states
        stateManager.setControllerManager(controller);
        activeGameState.setActiveGameController(gamePlayController);

        // set necessary things for controllers
        view.setKeyListener(controller);
        controller.setStateManager(stateManager);
        controller.setViewManager(viewManager);
        gamePlayController.setState(activeGameState);
        gamePlayController.setGamePanel(gamePanel);
    }
}
