package View;

import Model.States.GameState;
import Utilities.SpriteImageFactory;
import View.TerrainView.Tileview;

import javax.swing.*;
import java.awt.*;



/**
 * Created by dyeung on 4/5/16.
 */
public class AreaViewport extends JPanel {

    //used for testing purposes
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 1000;
    public static final int MAXSIZE = 10;
    private Tileview[][] tileViews = new Tileview[MAXSIZE][MAXSIZE];
    public AreaViewport(){
        //This needs to be initialized later on or grabbed from the inventory
        this.setBackground(Color.GRAY);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        for (int i = 0; i < MAXSIZE; i++){
            for(int j = 0; j < MAXSIZE; j++){
                tileViews[i][j] = new Tileview(i, j);
            }
        }
    }
    //This needs to take in gamestate
    public AreaViewport(GameState gs){

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //System.out.println("Is this not being called?");
        for (int i=MAXSIZE - 1; i>=0; i--) {
            for (int j = MAXSIZE - 1; j >=0; j--) {
                if (tileViews[i][j] != null) {
                    tileViews[i][j].paintComponent(g);

                }
            }
        }

        //this.add(grass);
        //this.repaint();
    }

}
