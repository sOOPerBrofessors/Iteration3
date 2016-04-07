package View;

import Model.States.GameState;
import View.AreaViewport.AreaViewport;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dyeung on 4/5/16.
 */
public class GameView extends JPanel{
    private AreaViewport areaViewport;

    public GameView(GameState gS){
        //When initalized it'll create the AreaViewport - might be changed for later though
        this.setLayout(new BorderLayout());
        init(gS);
    }
    //These views come built in with the GameView
    public void init(GameState gameState){
        areaViewport = new AreaViewport(gameState);
        addView(areaViewport);
    }
    //These views can be added to the GameView
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
        System.out.println("GameView: Paint Game View!");
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
}
