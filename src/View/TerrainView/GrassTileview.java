package View.TerrainView;

import Utilities.SpriteImageFactory;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dyeung on 4/5/16.
 */
public class GrassTileview extends JComponent{
    private String url = "./res/terrain/grass_deep.png";
    private Image grassImage;
    private int x;
    private int y;
    private int width = 56;
    private int height = 48;
    private int row;
    public GrassTileview(int x, int y){
        this.x = x;
        this.y = y;
        //this.row = r;
        grassImage = SpriteImageFactory.getImage(url);
        offsetXY(x,y);
    }
    //Function to offset the x and y coordinates based off of the (x,y) positions
    public void offsetXY(int oldx, int oldy){
        System.out.println(oldx + "," + oldy);
        x = oldx*width;
        y = oldy*height + height*oldx/2;

        System.out.println("Coordinates:" + x + "," + y);
    }
    @Override
    public void paintComponent(Graphics g) {
        //System.out.println("Paint compenent in tileview");
        g.drawImage(grassImage,x,y,78,52,null);
    }

}


