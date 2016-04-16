package View.ItemView;

import Utilities.Settings;

import java.awt.*;

/**
 * Created by Wimberley on 4/16/16.
 */
public class InteractableView extends ItemView{

    public InteractableView(Image image){
        this.image = image;
        itemHeight = Settings.INTERACTABLEHEIGHT;
        itemWidth = Settings.INTERACTABLEWIDTH;
    }

    @Override
    protected void adjustHeight() {
        yPixel = yPixel+40;
    }
}
