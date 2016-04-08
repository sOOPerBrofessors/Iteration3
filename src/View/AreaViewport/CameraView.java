package View.AreaViewport;

import Model.Map.Location;
import Utilities.Settings;
import View.EntityView.AvatarView;

import java.util.Set;

/**
 * Created by dyeung on 4/6/16.
 */
public class CameraView {
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private AvatarView avatarView; //The center view
    public CameraView(AvatarView avatar){
        this.avatarView = avatar;
    }
    public Location computeOffset(){
        //System.out.println("CameraView: " + avatarView.getX()  + "," + avatarView.getY() );
        int x = Settings.GAMEWIDTH/2 - avatarView.getXPixel();
        int y = Settings.GAMEHEIGHT/2 - avatarView.getYPixel();
        int z = 0;
        return new Location(x,y,z);
    }
    public void update(Location location){

    }
    //TERRIBLE WAY TO HANDLE. THINK OF BETTER WAY
    public boolean requiresOffset(){
        Location loc = computeOffset();
        if (loc.getX() != 0 || loc.getY() != 0 || loc.getZ() != 0){
            return true;
        }else{
            return false;
        }
    }

}
