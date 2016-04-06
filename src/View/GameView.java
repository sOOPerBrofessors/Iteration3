package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by dyeung on 4/5/16.
 */
public class GameView extends JPanel{
    private AreaViewport areaViewport;

    //This stuff should be in the active view container
    //used for testing purposes
    public static final int WIDTH = 100;
    public static final int HEIGHT = 100;
    public GameView(){
        //When initalized it'll create the AreaViewport - might be changed for later though
        this.setLayout(new BorderLayout());
        init();
    }
    //These views come built in with the GameView
    public void init(){
        areaViewport = new AreaViewport();
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
        //System.out.println("Paint Game View!");
        //super.paintComponent(g);
        //This doesn't get called anymore
//        g.setFont(new Font("Helvetica",1,50));
//        g.setColor(new Color(67, 22, 244, 80));
//        g.drawString("GAMEVIEWPORT",0,0);

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
