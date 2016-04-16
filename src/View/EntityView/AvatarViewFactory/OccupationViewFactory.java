package View.EntityView.AvatarViewFactory;

import Model.Map.Orientation;
import View.EntityView.OrientationView;
import View.ViewUtilities.ImageAssets;

import java.awt.*;

/**
 * Created by dyeung on 4/9/16.
 */
public class OccupationViewFactory {
    OccupationViewFactory(){

    }

    public static OrientationView createSmasherView(Orientation orientation){
        return new OrientationView(orientation, ImageAssets.smasherN, ImageAssets.smasherNW, ImageAssets.smasherNE,ImageAssets.smasherS,ImageAssets.smasherSE,ImageAssets.smasherSW);
    }
    //TODO: Need to change to summoner
    public static OrientationView createSummonerView(Orientation orientation){
        return new OrientationView(orientation, ImageAssets.summonerN, ImageAssets.summonerNW, ImageAssets.summonerNE,ImageAssets.summonerS,ImageAssets.summonerSE,ImageAssets.summonerSW);
    }
    public static OrientationView createSneakView(Orientation orientation){
        return new OrientationView(orientation, ImageAssets.sneakN, ImageAssets.sneakNW, ImageAssets.sneakNE,ImageAssets.sneakS,ImageAssets.sneakSE,ImageAssets.sneakSW);
    }



}
