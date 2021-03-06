import Controller.ControllerManager;
import Controller.Controllers.GamePlayController;
import LoadSave.LoadData;
import LoadSave.LoadFactionRelationsVisitor;
import LoadSave.LoadFactionsVisitor;
import LoadSave.LoadPersonalitiesVisitor;
import Model.Model;
import Model.State.StateManager;
import View.View;
import View.ViewUtilities.Panels.GamePanel;
import View.ViewManager;

/**
 * Created by Wimberley on 3/23/16.
 */
class Main {

    public static void main(String[] args) {

        // This loads the factions and faction relationships
        LoadData.load("res/DefaultData/factions.xml", new LoadFactionsVisitor());
        LoadData.load("res/DefaultData/faction_relationships.xml", new LoadFactionRelationsVisitor());
        LoadData.load("res/DefaultData/personalities.xml", new LoadPersonalitiesVisitor());

        // creates all components that need to know of each other
        Model gameLoop = new Model();
        View view = new View(gameLoop);

        initialize(gameLoop, view);

        view.start();
    }

    private static void initialize(Model model, View view) {

        // initialize view manager and get necessary views
        ViewManager viewManager = view.getViewManager();
        GamePanel gamePanel = viewManager.getGamePanel();

        // initialize state manager and get necessary states
        StateManager stateManager = model.getStateManager();

        // initialize controller manager and get necessary controllers
        ControllerManager controller = new ControllerManager();

        GamePlayController gamePlayController = controller.getGamePlayController();

        // set necessary things for views
        viewManager.setControllerManager(controller);
        viewManager.setStateManager(stateManager);

        //gamePanel.setGamePlayController(gamePlayController);

        // set necessary things for states
        stateManager.setControllerManager(controller);

        // set necessary things for controllers
        view.setKeyListener(controller);
        controller.setStateManager(stateManager);
        controller.setViewManager(viewManager);
        gamePlayController.setGamePanel(gamePanel);
    }
}
