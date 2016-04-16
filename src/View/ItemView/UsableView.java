package View.ItemView;

import Utilities.Settings;

import java.awt.*;

/**
 * Created by Wimberley on 4/14/16.
 */
public class UsableView extends ItemView {

    public UsableView(Image image){
        this.image = image;
        itemHeight = Settings.TAKABLEHEIGHT;
        itemWidth = Settings.TAKABLEWIDTH;
    }
}
