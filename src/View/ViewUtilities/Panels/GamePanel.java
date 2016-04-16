package View.ViewUtilities.Panels;

import Controller.Controllers.GamePlayController;
import Model.Inventory.Inventory;
import Model.State.GameState.ActiveGameState;
import Utilities.Observers.Observer;
import View.AreaViewport.AreaViewport;
import View.InventoryView.InventoryView;
import View.InventoryView.StatsView;
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
    public void init(ActiveGameState gameState){
        areaViewport = new AreaViewport(gameState);
        inventoryView = new InventoryView(gameState);
        statsView = new StatsView(gameState);
        addView(areaViewport);
        controller.setState(gameState);
    }

    //These views can be added to the GamePanel
    public void addInventoryView(){
        addView(inventoryView);
    }

    public void closeInventoryView(){
        closeView(inventoryView);
    }

    public void addStatsView() {addView(statsView); }
//
    public void closeStatsView() {closeView(statsView);}

    //currently part of InventoryView
//    public void addEquipmentView(){}
//    public void closeEquipmentView(){}

    public void addStatusView(){
        //TODO:
    }

    public void closeStatusView(){
        //TODO:
    }

    public void addSkillsView(){
        //TODO:
    }

    public void closeSkillsview(){
        //TODO:
    }

    @Override
    protected void paintComponent(Graphics g) {
        //This doesn't get called anymore
        System.out.println("GamePanel: Paint Game View!");
        super.paintComponent(g);
    }

    public void addView(JComponent view){
        add(view, BorderLayout.CENTER);
        for(int i = 0; i < getComponentCount() - 1; i++){
            setComponentZOrder(getComponent(i), getComponentCount() - 1 - i);
        }
        this.revalidate();
        this.repaint();
    }

    public void closeView(JComponent view){
        this.remove(view);
        this.revalidate();
        this.repaint();
    }

    public GamePanel getGamePanel(){
        return this;
    }

    public InventoryView getInventoryView() {return inventoryView;}

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
}
