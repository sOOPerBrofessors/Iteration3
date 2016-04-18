package View.AreaViewport;

import Model.Entity.Character.Avatar;
import Model.Map.Location;
import Utilities.Settings;

/**
 * Created by dyeung on 4/6/16.
 */
class CameraView {

    private final Avatar avatar;
    private int xPixels;
    private int yPixels;
    private final int tileWidth = Settings.TILEWIDTH;
    private final int tileHeight = Settings.TILEHEIGHT;
    public CameraView(Avatar avatar){
        this.avatar = avatar;
    }
    
    //TODO: Need to implement some sort of class that will tie in CameraView with the AreaViewport so we have 
    //consistent pixel translations
    public Location computeOffset(){
        updateLocationToPixels();
        int x = Settings.GAMEWIDTH/2 - xPixels;
        int y = Settings.GAMEHEIGHT/2 - yPixels;
        int z = 0;
        return new Location(x,y,z);
    }
    private void updateLocationToPixels(){
        //TODO I might need to change this into a class
        int x = avatar.getLocation().getX();
        int y = avatar.getLocation().getY();

        xPixels = x*tileWidth - (x*(tileWidth))/4 + getCenterX();
        yPixels = y*(tileHeight - 5) + ((tileHeight-7)*x)/2 + getCenterY();
//
//        System.out.println("CameraView: Location " + x  + "," + y );
//        System.out.println("CameraView: pixels " + xPixels  + "," + yPixels );

    }
    private int getCenterX(){
        return tileWidth/4;
    }
    private int getCenterY(){
        return -(tileHeight/2);
    }

}
