package View.EntityView;

import Model.Map.Location;
import Utilities.SpriteImageFactory;
import View.AreaViewport.CameraView;
import View.ViewUtilities.ImageAssets;
import View.ViewUtilities.SpriteLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by dyeung on 4/6/16.
 */
public class AvatarView extends EntityView {
    private String url = "./res/Entity/Sneak_Single.png";
    //Width height scale formula is Height/Width * new width = new height
    private Image avatarImage;
    public AvatarView(Location initLocation){
        super(initLocation);
        avatarImage = SpriteImageFactory.getImage(url);
        //avatarImage = SpriteImageFactory.getImage(url);

    }
    @Override
    public void updateMove(Location direction) {
        super.updateMove(direction);

        //TODO: Might require some specific things with avatar view
    }
    @Override
    public void paintComponent(Graphics g) {
        //System.out.println("EntityView: paint component");
        g.drawImage(avatarImage,xPixel,yPixel,entityWidth,entityHeight,null);
        //super.paintComponent(g);
    }
}
