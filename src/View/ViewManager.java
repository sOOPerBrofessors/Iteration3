package View;

import Controller.ControllerManager;
import Controller.Controllers.*;
import Model.Entity.Character.Avatar;
import Model.State.StateManager;
import Utilities.GameLoaderSaver.GameLoader;
import Utilities.Observers.Subject;
import Utilities.Observers.Observer;
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

    public ViewManager(){
        // set intro screen panel
        introPanel = new IntroPanel(this).introPanel();
        createPanel = new CharacterCreationPanel(this).createPanel();
        gamePanel = new GamePanel(this);

        activePanel = introPanel;
        //inventoryView = new InventoryView()
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

    public void closeAll(){ //Massive OCP violation
        closeInventory();
        closeStats();
        closePauseScreen();
        closeSkills();
        closeSettings();
    }

    public void displayInventory() {
        gamePanel.addInventoryView();
        stateManager.pauseGame();
    }

    public void closeInventory(){
        gamePanel.closeInventoryView();
        stateManager.activeGame();
    }

    public void displayStats() {
        gamePanel.addStatsView();
        stateManager.pauseGame();
    }

    public void closeStats(){
        gamePanel.closeStatsView();
        stateManager.activeGame();
    }

    public void displayPauseScreen(){
        gamePanel.addPauseView();
        stateManager.pauseGame();
    }

    public void closePauseScreen(){
        gamePanel.closePauseView();
        stateManager.activeGame();
    }

    public void displaySettings(){
        gamePanel.addSettingsView();
        stateManager.pauseGame();
    }

    public void closeSettings(){
        gamePanel.closeSettingsView();
        stateManager.activeGame();
    }

    public void displaySkills(){
        gamePanel.addSkillsView();
        stateManager.pauseGame();
    }

    public void closeSkills(){
        gamePanel.closeSkillsView();
        stateManager.activeGame();
    }

    public void displayActiveGame(){
        activePanel = gamePanel;
        controllerManager.switchGamePlay();
        alert();
    }

    public JPanel getActivePanel(){
        return activePanel;
    }

    public GamePanel getGamePanel() {return gamePanel;}

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

    public void setControllerManager(ControllerManager controllerManager) {
        this.controllerManager = controllerManager;
        gamePanel.addKeyListener(controllerManager);
    }

    public void setStateManager(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    // initialize game once players selection is confirmed
    private void initGame(Avatar player){
        GameLoader gameLoader = new GameLoader(player); // initializes player and attributes of GameState
        activePanel = gamePanel;
        stateManager.setActiveGameState(gameLoader.getActiveGameState());
        stateManager.setPausedGameState(gameLoader.getPausedGameState());
        gamePanel.init(gameLoader.getActiveGameState()); // initilaizes the game view
        controllerManager.switchGamePlay(); // switch to gameplay controller
        InventoryController.setInventoryView(gamePanel);
        PauseController.setPauseView(gamePanel);
        SkillsController.setSkillsView(gamePanel);
        SettingsController.setSettingsView(gamePanel);
        TradeController.setTradeView(gamePanel);
        View.startGameLoop(); // starts loop in Model class
        alert(); // notifies view of the updated panel
    }
}