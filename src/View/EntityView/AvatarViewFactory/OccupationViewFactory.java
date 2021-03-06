package View.EntityView.AvatarViewFactory;

import Model.Map.Orientation;
import View.EntityView.OrientationView;
import View.ViewUtilities.Sprites.ImageAssets;

/**
 * Created by dyeung on 4/9/16.
 */
public class OccupationViewFactory {
    OccupationViewFactory(){

    }

    public static OrientationView createSmasherView(Orientation orientation){
        return new OrientationView(orientation, ImageAssets.smasherN, ImageAssets.smasherNW, ImageAssets.smasherNE,ImageAssets.smasherS,ImageAssets.smasherSE,ImageAssets.smasherSW);
    }
    public static OrientationView createSummonerView(Orientation orientation){
        return new OrientationView(orientation, ImageAssets.summonerN, ImageAssets.summonerNW, ImageAssets.summonerNE,ImageAssets.summonerS,ImageAssets.summonerSE,ImageAssets.summonerSW);
    }
    public static OrientationView createSneakView(Orientation orientation){
        return new OrientationView(orientation, ImageAssets.sneakN, ImageAssets.sneakNW, ImageAssets.sneakNE,ImageAssets.sneakS,ImageAssets.sneakSE,ImageAssets.sneakSW);
    }
    public static OrientationView createPetView(Orientation orientation){
        return new OrientationView(orientation, ImageAssets.hellCatN, ImageAssets.hellCatNW, ImageAssets.hellCatNE,ImageAssets.hellCatS,ImageAssets.hellCatSE,ImageAssets.hellCatSW);
    }
    public static OrientationView createShopkeeperView(Orientation orientation){
        return new OrientationView(orientation, ImageAssets.shopKeeperN, ImageAssets.shopKeeperNW, ImageAssets.shopKeeperNE,ImageAssets.shopKeeperS,ImageAssets.shopKeeperSE,ImageAssets.shopKeeperSW);
    }
    public static OrientationView createEnemyView(Orientation orientation){
        return new OrientationView(orientation, ImageAssets.enemyN, ImageAssets.enemyNW, ImageAssets.enemyNE,ImageAssets.enemyS,ImageAssets.enemySE,ImageAssets.enemySW);
    }
    public static OrientationView createBirdView(Orientation orientation){
        return new OrientationView(orientation, ImageAssets.enemyN, ImageAssets.enemyNW, ImageAssets.enemyNE,ImageAssets.enemyS,ImageAssets.enemySE,ImageAssets.enemySW);
    }
    public static OrientationView createCrabbyView(Orientation orientation){
        return new OrientationView(orientation, ImageAssets.crabN, ImageAssets.crabNW, ImageAssets.crabNE,ImageAssets.crabS,ImageAssets.crabSE,ImageAssets.crabSW);
    }

}