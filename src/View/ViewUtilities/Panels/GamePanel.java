package View.ViewUtilities.Panels;

import Model.State.GameState.ActiveGameState;
import View.AreaViewport.AreaViewport;
import View.ViewManager;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dyeung on 4/5/16.
 */
public class GamePanel extends JPanel{

    private AreaViewport areaViewport;
    private ViewManager viewManager;

    public GamePanel(ViewManager viewManager){
        //When initalized it'll create the AreaViewport - might be changed for later though
        setLayout(new BorderLayout());
        this.viewManager = viewManager;
    }
    //These views come built in with the GamePanel
    public void init(ActiveGameState gameState){
        areaViewport = new AreaViewport(gameState);
        addView(areaViewport);
    }
    //These views can be added to the GamePanel
    public void addInventoryView(){
        //TODO:
    }
    public void closeInventoryView(){
        //TODO:
    }
    public void addEquipmentView(){
        //TODO:
    }
    public void closeEquipmentView(){
        //TODO:
    }
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
        this.add(view, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }
    public void closeView(JComponent view){
        this.remove(view);
        this.revalidate();
        this.repaint();
    }

    public void setAreaViewport(ActiveGameState gs){
        init(gs);
    }

    public GamePanel getGamePanel(){
        return this;
    }
}
