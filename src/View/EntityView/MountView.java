package View.EntityView;

import Model.Entity.Character.Mount.Mount;
import Utilities.Observers.EntityObserver;
import Utilities.Settings;
import View.MapView.MapObjectView;

import java.awt.*;

/**
 * Created by Wimberley on 4/17/16.
 */
public class MountView extends MapObjectView{

    private Mount mount;
    private Image image;
    private int viewWidth;
    private int viewHeight;
    private int xPixel; // on the map
    private int yPixel; // on the map

    public MountView(Mount mount, Image image){
        this.image = image;
        this.mount = mount;
        viewHeight = Settings.MOUNTHEIGHT;
        viewWidth = Settings.MOUNTWIDTH;
    }

    @Override
    public void paintComponent(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.drawImage(image,xPixel* Settings.SCALEFACTOR,yPixel*Settings.SCALEFACTOR,viewWidth*Settings.SCALEFACTOR,viewHeight* Settings.SCALEFACTOR,null);
    }

    @Override
    public void setPixels(int x, int y) {
        xPixel = x;
        yPixel = y;
    }

    @Override
    protected void adjustHeight() {

    }
}