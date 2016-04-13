package View;

import Controller.ControllerManager;
import Model.Entity.Character.Avatar;
import Model.State.StateManager;
import Utilities.GameLoader;
import Utilities.Observers.Subject;
import Utilities.Observers.Observer;
import View.InventoryView.InventoryView;
import View.ViewUtilities.Panels.CharacterCreationPanel;
import View.ViewUtilities.Panels.GamePanel;
import View.ViewUtilities.Panels.IntroPanel;

import javax.swing.JPanel;

/**
 * Created by Wimberley on 3/23/16.
 */
public class ViewManager implements Subject {

    // controller manager used to issue commands to change current controller
    private ControllerManager controllerManager;

    // state manager used to issue commands to model
    private StateManager stateManager;

    // view observers
    private Observer observer;

    // panel that will be painted to screen
    private JPanel activePanel;

    // all views that need to be swapped between
    private JPanel introPanel;
    private GamePanel gamePanel;
    private JPanel createPanel;
    private InventoryView inventoryView;

    public ViewManager(){
        // set intro screen panel
        introPanel = new IntroPanel(this).introPanel();
        createPanel = new CharacterCreationPanel(this).createPanel();
        gamePanel = new GamePanel(this);
        activePanel = introPanel;
    }

    public void displayIntro(){
        activePanel = introPanel;
        alert(); // notifies view of the updated panel
    }

    public void displayCreate(){
        activePanel = createPanel;
        alert(); // notifies view of the updated panel
    }

    public void createSmasher(){
        initGame(Avatar.makeSmasher());
    }

    public void createSneak(){
        initGame(Avatar.makeSneak());
    }

    public void createSummoner(){
        initGame(Avatar.makeSummoner());
    }

    public void displayInventory(){
        //activePanel = inventoryPanel;

    }

    public void displayActiveGame(){
        activePanel = gamePanel;
        controllerManager.switchGamePlay();
        alert();
    }

    public void displayEquipment(){
        //activePanel = equipmentPanel;
    }

    public void displayPauseMenu(){
        //activePanel = pausePanel;
    }

    public void displaySkills(){
        //activePanel = skillsPanel;
    }

    public JPanel getActivePanel(){
        return activePanel;
    }

    @Override
    public void addObserver(Observer o) {
        observer = o;
    }

    @Override
    public void removeObserver(Observer o) {

    }

    @Override
    public void alert() {
        observer.update();
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void setControllerManager(ControllerManager controllerManager) {
        this.controllerManager = controllerManager;
        gamePanel.addKeyListener(controllerManager);
    }

    public void setStateManager(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    // initialize game once players selection is confirmed
    private void initGame(Avatar player){
        GameLoader gameLoader = new GameLoader(player);
        activePanel = gamePanel;
        stateManager.setActiveGameState(gameLoader.getActiveGameState());
        gamePanel.init(gameLoader.getActiveGameState());
        controllerManager.switchGamePlay();
        View.startGameLoop();
        alert(); // notifies view of the updated panel
    }
}
