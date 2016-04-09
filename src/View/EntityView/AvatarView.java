package View.EntityView;

import Model.Entity.Character.Avatar;
import Model.Map.Location;
import Model.Map.Orientation;
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

    //private String url = "./res/Entity/newSneak.png";
    //Width height scale formula is Height/Width * new width = new height
    private Image avatarImage;
    public AvatarView(Avatar avatar){
        super(avatar);
        ImageAssets.init();
        avatarImage = ImageAssets.sneakS;

    }

    private void renderOrientation(){
        avatarImage = ImageAssets.sneakS;
    }

    @Override
    public void paintComponent(Graphics g) {
        //System.out.println("AvatarView: paint was called");
        g.drawImage(avatarImage,xPixel,yPixel,entityWidth, entityHeight,null);
    }
}
