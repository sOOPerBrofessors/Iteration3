package View.ItemView;

import Utilities.Settings;

import java.awt.*;

/**
 * Created by Wimberley on 4/14/16.
 */
public class PotionView extends ItemView {

    public PotionView(Image image){
        this.image = image;
        itemHeight = Settings.POTIONHEIGHT;
        itemWidth = Settings.POTIONWIDTH;
    }

}
