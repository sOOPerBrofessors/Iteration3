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

    @Override
    protected void updateCoordinateToScreenPosition(int xOffset, int yOffset) {
        xPixel = (int)(x*itemWidth*2.5 + xOffset);
        yPixel = (int)(y*itemHeight*2.63 + yOffset);
    }
}
