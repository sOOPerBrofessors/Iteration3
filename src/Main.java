import Controller.AI_Controller.Personality.Personality;
import Controller.AI_Controller.Personality.PersonalityFactory;
import Controller.ControllerManager;
import Controller.Controllers.GamePlayController;
import LoadSave.LoadData;
import LoadSave.LoadFactionRelationsVisitor;
import LoadSave.LoadFactionsVisitor;
import LoadSave.LoadPersonalitiesVisitor;
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

        // This loads the factions and faction relationships
        LoadData.load("data/factions.xml", new LoadFactionsVisitor());
        LoadData.load("data/faction_relationships.xml", new LoadFactionRelationsVisitor());
        LoadData.load("data/personalities.xml", new LoadPersonalitiesVisitor());

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
        controller.setStateManager(stateManager);
        controller.setViewManager(viewManager);
        //gamePlayController.setState(activeGameState);
        gamePlayController.setGamePanel(gamePanel);
    }
}
