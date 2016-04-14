package View.AreaViewport.FogOfWar;

import Model.Entity.Character.Avatar;
import Model.Map.Location;
import Utilities.InfluenceAreas.Planer.AreaEffect;
import View.AreaViewport.MapView;

import java.util.ArrayList;

/**
 * Created by dyeung on 4/13/16.
 */
public class FogOfWar {
    //Takes in avatar or takes in avatar view? for now agree on avatar
    int radius;
    Avatar avatar; //we can probably get rid of avatar by using the observer
    public FogOfWar(Avatar avatar){
        radius = avatar.getRadiusVisibility();
        this.avatar = avatar;
    }

    public void setFogOfWar(MapView mapView){

        ArrayList<Location> visible = AreaEffect.getInfluenceArea(avatar.getLocation(), radius);
        for (Location location : visible){
            int x = location.getX();
            int y = location.getY();
           mapView.setVisibleState(x,y);
        }
    }

}
