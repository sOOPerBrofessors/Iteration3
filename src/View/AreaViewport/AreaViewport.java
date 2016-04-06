package View.AreaViewport;

import Model.Entity.Avatar;
import Model.States.GameState;
import Utilities.GameLoader;
import View.EntityView.EntityView;
import View.TerrainView.GrassTileview;
import View.View;

import javax.swing.*;
import java.awt.*;



/**
 * Created by dyeung on 4/5/16.
 */
public class AreaViewport extends JPanel {

    //used for testing purposes
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 1000;
    public static final int MAXSIZE = 15;

    //TODO: Change this to map
    private GrassTileview[][] tileViews = new GrassTileview[MAXSIZE][MAXSIZE];

    //TODO: Add avatar views and stuff
    private EntityView avatarView;

    public AreaViewport(GameState gameState){
        //This needs to be initialized later on or grabbed from the inventory
        this.setBackground(Color.GRAY);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));


        //THIS IS HELLA TEMPORARY
        Avatar a = gameState.getAvatar();
        avatarView = new EntityView(5,5);
        a.addObserver(avatarView);

        for (int i = 0; i < MAXSIZE; i++){
            for(int j = 0; j < MAXSIZE; j++){
                tileViews[i][j] = new GrassTileview(i, j);

                //add(tileViews[i][j]);
            }
        }


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("Is this not being called?");
        //Painted the other way cause it looks better
//        for (int i=MAXSIZE - 1; i>=0; i--) {
//            for (int j = MAXSIZE - 1; j >=0; j--) {
//                if (tileViews[i][j] != null) {
//                    tileViews[i][j].paintComponent(g);
//
//                }
//            }
//        }
        for (int i = 0; i < MAXSIZE; i++) {
            for (int j = 0; j < MAXSIZE; j++){
                tileViews[i][j].paintComponent(g);
            }
        }

        avatarView.paintComponent(g);
    }
}
