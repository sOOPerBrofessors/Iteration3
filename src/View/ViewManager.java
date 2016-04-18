package View;

import Controller.ControllerManager;
import Controller.Controllers.*;
import Model.Entity.Character.Avatar;
import Model.State.GameState.GameState;
import Model.State.StateManager;
import Utilities.GameLoaderSaver.GameLoader;
import Utilities.GameLoaderSaver.Load.LoadParser;
import Utilities.Observers.Subject;
import Utilities.Observers.Observer;
import View.ViewUtilities.Panels.CharacterCreationPanel;
import View.ViewUtilities.Panels.GamePanel;
import View.ViewUtilities.Panels.IntroPanel;

import javax.swing.JPanel;
import java.awt.*;

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
    private final JPanel introPanel;
    private GamePanel gamePanel;
    private final JPanel createPanel;

    public ViewManager(){
        // set intro screen panel
        introPanel = new IntroPanel(this).introPanel();
        introPanel.setBackground(Color.DARK_GRAY);
        createPanel = new CharacterCreationPanel(this).createPanel();
        createPanel.setBackground(Color.darkGray);
        gamePanel = new GamePanel(this);
        activePanel = introPanel;
        boolean alreadystarted = false;
    }

    public void stopThread(){
        stateManager.stopThread();
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
        newGame(Avatar.makeSmasher());
    }

    public void createSneak(){
        newGame(Avatar.makeSneak());
    }

    public void createSummoner(){
        newGame(Avatar.makeSummoner());
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

    private void closeInventory(){
        gamePanel.closeInventoryView();
        stateManager.activeGame();
    }

    public void displayStats() {
        gamePanel.addStatsView();
        stateManager.pauseGame();
    }

    private void closeStats(){
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
        //controllerManager.setSettingsState(); //need to tell controllerManager to go to Settings state since get here from PauseMenu
    }

    private void closeSettings(){
        gamePanel.closeSettingsView();
        stateManager.activeGame();
    }

    public void displaySkills(){
        gamePanel.addSkillsView();
        stateManager.pauseGame();
    }

    private void closeSkills(){
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

    public void loadGame(){
        System.out.println("ViewManager start load game:");
        //No input needed to avatar
        LoadParser loadParser = new LoadParser();
        Avatar avatar = loadParser.loadAvatar();
        GameLoader gameLoader = new GameLoader(avatar, stateManager); // initializes player and attributes of GameState
        gameLoader.loadGame();
        initGame(gameLoader);
    }
    // initialize game once players selection is confirmed
    private void newGame(Avatar player){
        GameLoader gameLoader = new GameLoader(player, stateManager); // initializes player and attributes of GameState
        gameLoader.createNewGame();
        initGame(gameLoader);
    }

    private void initGame(GameLoader gameLoader){
        GamePlayController gamePlayController = controllerManager.getGamePlayController();
        MountController mountController = controllerManager.getMountController();
        gamePanel = new GamePanel(this);
        gamePanel.init(gameLoader.getActiveGameState(), gamePlayController); // initializes the game view
        mountController.setState(gameLoader.getMountGameState());
        gameLoader.getMountGameState().setController(mountController);

        activePanel = gamePanel;
        stateManager.setActiveGameState(gameLoader.getActiveGameState());
        stateManager.setPausedGameState(gameLoader.getPausedGameState());
        stateManager.setMountGameState(gameLoader.getMountGameState());
        activePanel = gamePanel;
        controllerManager.switchGamePlay(); // switch to gameplay controller
        InventoryController.setInventoryView(gamePanel);
        PauseController.setPauseView(gamePanel);
        SkillsController.setSkillsView(gamePanel);
        SettingsController.setSettingsView(gamePanel);
        TradeController.setTradeView(gamePanel);
        View.startGameLoop(); // starts loop in Model class
        alert(); // notifies view of the updated panel
    }

    //FOR SAVE
    public GameState getGameState(){
        return stateManager.getGameState();
    }
}