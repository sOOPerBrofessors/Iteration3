package View.EntityView;

import Model.Entity.Character.Avatar;
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
    public AvatarView(Avatar avatar){
        super(avatar);
        avatarImage = SpriteImageFactory.getImage(url);
        //avatarImage = SpriteImageFactory.getImage(url);

    }

    @Override
    public void paintComponent(Graphics g) {
        //System.out.println("EntityView: paint component");
        g.drawImage(avatarImage,xPixel,yPixel,entityWidth,entityHeight,null);
        //super.paintComponent(g);
    }
}
