package View.EntityView;

import Model.Entity.Character.Avatar;
import View.EntityView.AvatarViewFactory.OccupationViewFactory;
import View.ViewUtilities.ImageAssets;

import java.awt.*;

/**
 * Created by dyeung on 4/6/16.
 */
public class AvatarView extends EntityView {

    //private String url = "./res/Entity/newSneak.png";
    //Width height scale formula is Height/Width * new width = new height
    private Image avatarImage;
    private OccupationViewFactory occupationViewFactory;
    private Avatar avatar;

    public AvatarView(Avatar avatar){
        super(avatar);
        this.avatar = avatar;
        avatarImage = ImageAssets.sneakS;
        //occupationViewFactory = new OccupationViewFactory();
    }

    private void renderOrientation(){
        avatarImage = ImageAssets.sneakS;
    }

    @Override
    public void paintComponent(Graphics g) {
        //System.out.println("AvatarView: paint was called");
        //Used for testing purposes
        //g.setColor(Color.blue);
        //g.drawRect(xPixel,yPixel,entityWidth,entityHeight);
        updateOrientationImage();
        g.drawImage(avatarImage,xPixel,yPixel,entityWidth, entityHeight,null);
    }

    @Override
    public void updateOrientationImage() {
        //avatarViewFactory.getView(this, avatar.getOccupation());
    }

}
