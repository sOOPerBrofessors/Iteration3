package View.AreaViewport.FogOfWar;

import Model.Entity.Character.Avatar;
import Model.Map.Location;
import Utilities.InfluenceAreas.Planer.RadialEffect;
import View.AreaViewport.MapView;

import java.util.ArrayList;

/**
 * Created by dyeung on 4/13/16.
 */
public class FogOfWar {
    //Takes in avatar or takes in avatar view? for now agree on avatar
    int radius;
    Avatar avatar; //we can probably get rid of avatar by using the observer
    Location oldLocation;
    public FogOfWar(Avatar avatar){
        radius = avatar.getRadiusVisibility();
        this.avatar = avatar;
        this.oldLocation = new Location(avatar.getX(),avatar.getY(),0);
    }

    public void setFogOfWar(MapView mapView){
        setNonVisible(mapView);
        this.oldLocation = new Location(avatar.getX(),avatar.getY(),0);
        ArrayList<Location> visible = RadialEffect.getRadialArea(avatar.getLocation(), radius);
        for (Location location : visible){
            int x = location.getX();
            int y = location.getY();
            mapView.setVisibleState(x,y);
        }

    }
    //TODO: think of better way to handle this (bascially we're clearing it and making it back)

    //This will set all the previous states back to non-visible (they had to already have been shrouded)
    private void setNonVisible(MapView mapView){
        //Location is the previous location
        ArrayList<Location> nonVisible = RadialEffect.getRadialArea(oldLocation, radius);
        for (Location location : nonVisible){
            int x = location.getX();
            int y = location.getY();
            mapView.setNonVisibleState(x,y);
        }
    }

}
