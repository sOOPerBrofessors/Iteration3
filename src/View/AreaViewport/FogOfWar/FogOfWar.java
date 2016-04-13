package View.AreaViewport.FogOfWar;

import Model.Entity.Character.Avatar;
import Model.Map.Location;
import View.MapView.TileColumnView;

/**
 * Created by dyeung on 4/13/16.
 */
public class FogOfWar {
    //Takes in avatar or takes in avatar view? for now agree on avatar
    int radius;
    Avatar avatar; //we can probably get rid of avatar by using the observer
    int x;
    int y;
    public FogOfWar(Avatar avatar){
        radius = avatar.getRadiusVisibility();
        this.avatar = avatar;
        this.x = avatar.getX();
        this.y = avatar.getY();
    }

    public void setFogOfWar(TileColumnView[][] tileColumnViews){
        updateLocation();

        tileColumnViews[x][y].setVisibleState();
        for (int i = 1; i < radius; i++){

        }

    }
    public void updateLocation(){
        x = avatar.getX();
        y = avatar.getY();
    }

}
