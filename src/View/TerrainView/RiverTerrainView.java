package View.TerrainView;

import Utilities.Settings;
import View.ViewUtilities.Sprites.ImageAssets;

import java.awt.*;

/**
 * Created by dyeung on 4/7/16.
 */
public class RiverTerrainView extends TerrainView {
    public RiverTerrainView() {
        super(ImageAssets.water); //suppose to be for river
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.drawImage(image,xPixel* Settings.SCALEFACTOR,yPixel*Settings.SCALEFACTOR,tileWidth*Settings.SCALEFACTOR+3,tileHeight* Settings.SCALEFACTOR+5,null);

    }
}
