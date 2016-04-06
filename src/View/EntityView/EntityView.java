package View.EntityView;

import EntityObserver.EntityObserver;
import Utilities.SpriteImageFactory;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dyeung on 4/6/16.
 */
public class EntityView extends JComponent implements EntityObserver{
    private Image avatarImage;
    private int x;
    private int y;
    private int tileWidth = 56;
    private int tileHeight = 48;
    private int xLocation;
    private int yLocation;
    private String url = "./res/terrain/grass_deep.png";
    public EntityView(int x, int y){
        this.x = x;
        this.y = y;
        avatarImage = SpriteImageFactory.getImage(url);
        offsetXY(x,y);
    }
    public void offsetXY(int oldx, int oldy){
        System.out.println(oldx + "," + oldy);
        xLocation = oldx*tileWidth;
        yLocation = oldy*tileHeight + tileHeight*oldx/2;
        System.out.println(xLocation + "," + yLocation);
    }
    @Override
    public void updateMove(int direction) {
        System.out.println("Entity: updated move");

        x += direction;
        y += direction;
        offsetXY(x,y);
        //TODO needs to change what tile I am on
    }
    @Override
    public void paintComponent(Graphics g) {
        System.out.println("EntityView: paint component");
        g.drawImage(avatarImage,xLocation,yLocation,100,100,null);
        super.paintComponent(g);
    }
}
