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
    private int xLocation;
    private int yLocation;
    private String url = "./res/terrain/grass_deep.png";
    public EntityView(int x, int y){
        xLocation = x;
        yLocation = y;
        avatarImage = SpriteImageFactory.getImage(url);
    }

    @Override
    public void updateMove(int direction) {
        System.out.println("Entity: updated move");

        xLocation += 100;
        yLocation += 100;

        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        //System.out.println("EntityView: paint componenet");
        g.drawImage(avatarImage,xLocation,yLocation,100,100,null);
    }
}
