package View.ViewUtilities.Panels;

import Controller.Controllers.GamePlayController;
import Model.State.GameState.ActiveGameState;
import Utilities.Observers.Observer;
import View.AreaViewport.AreaViewport;
import View.MenuViews.*;
import View.ViewManager;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dyeung on 4/5/16.
 */
public class GamePanel extends JPanel{

    private AreaViewport areaViewport;
    private ViewManager viewManager;
    private GamePlayController controller;

    private InventoryView inventoryView;
    private StatsView statsView;
    private PauseView pauseView;
    private SettingsView settingsView;
    private SkillsView skillsView;
    private TradeView tradeView;

    //
    private int paintOrder;

    // gamePanel observer (viewManager)
    private Observer observer;

    public GamePanel(ViewManager viewManager){
        //When initalized it'll create the AreaViewport - might be changed for later though
        setLayout(new BorderLayout());
        this.viewManager = viewManager;
        paintOrder = 1;
    }

    //These views come built in with the GamePanel
    public void init(ActiveGameState gameState, GamePlayController gamePlayController){
        areaViewport = new AreaViewport(gameState);
        inventoryView = new InventoryView(gameState);
        statsView = new StatsView(gameState);
        pauseView = new PauseView(viewManager);
        settingsView = new SettingsView();
        skillsView = new SkillsView(gameState.getAvatar());
        tradeView = new TradeView();
        controller = gamePlayController;
        addView(areaViewport);
        controller.setState(gameState);
        gameState.setController(controller);
    }

    //These views can be added to the GamePanel
    public void addInventoryView(){
        addView(inventoryView);
    }

    public void closeInventoryView(){
        closeView(inventoryView);
    }

    public void addStatsView() {addView(statsView); }

    public void closeStatsView() {closeView(statsView);}

    public void addPauseView(){addView(pauseView); }

    public void closePauseView(){ closeView(pauseView); }

    public void addSettingsView(){ addView(settingsView); }

    public void closeSettingsView(){ closeView(settingsView); }

    public void addSkillsView(){ addView(skillsView); }

    public void closeSkillsView(){ closeView(skillsView); }

    public void addTradeView() { addView(tradeView); }

    public void closeTradeView() { closeView(tradeView);}

    public GamePanel getGamePanel(){
        return this;
    }

    public InventoryView getInventoryView() {return inventoryView;}

    public PauseView getPauseView() {return pauseView; }

    public SettingsView getSettingsView() {return settingsView; }

    public SkillsView getSkillsView() {return skillsView; }

    public TradeView getTradeView() { return tradeView; }

    public StatsView getStatsView(){return statsView;}

    public void setGamePlayController(GamePlayController gamePlayController){
        controller = gamePlayController;
    }

    public GamePlayController getController(){
        return controller;
    }

    private void reverseComponents(JComponent view){
        Component temp;
        System.out.println("you");
        temp = getComponent(0);
        remove((JComponent)temp);
        add(view, BorderLayout.CENTER);
        add(temp, BorderLayout.CENTER);
    }

    private void addView(JComponent view){
        add(view, BorderLayout.CENTER);
        for(int i = 0; i < getComponentCount() - 1; i++){
            setComponentZOrder(getComponent(i), getComponentCount() - 1 - i);
        }
        this.revalidate();
        this.repaint();
    }

    private void closeView(JComponent view){
        this.remove(view);
        this.revalidate();
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        //This doesn't get called anymore
        System.out.println("GamePanel: Paint Game View!");
        super.paintComponent(g);
    }
}