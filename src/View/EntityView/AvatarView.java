package View.EntityView;

import Model.Map.Location;
import Utilities.SpriteImageFactory;
import View.AreaViewport.CameraView;

import java.awt.*;

/**
 * Created by dyeung on 4/6/16.
 */
public class AvatarView extends EntityView {
    private String url = "./res/terrain/grass.png";
    private Image avatarImage;
    public AvatarView(Location initLocation){
        super(initLocation);
        avatarImage = SpriteImageFactory.getImage(url);
    }
    @Override
    public void updateMove(Location direction) {
        super.updateMove(direction);

        //TODO: finish with camera
        //Also updates the camera. So the AvatarView has a handle to the camera view
        //cameraView.update(location);
    }
    @Override
    public void paintComponent(Graphics g) {
        //System.out.println("EntityView: paint component");
        g.drawImage(avatarImage,xPixel,yPixel,50,50,null);
        //g.drawOval(xPosition,yPosition, 50, 50);
        //super.paintComponent(g);
    }
}
