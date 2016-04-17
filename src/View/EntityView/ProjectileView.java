package View.EntityView;

import Model.Entity.Projectile.Projectile;
import Utilities.Observers.Observer;
import Utilities.Settings;
import View.MapView.MapObjectView;

import java.awt.*;

/**
 * Created by dyeung on 4/16/16.
 */
public class ProjectileView extends MapObjectView implements Observer{

    private Projectile projectile;
    private Image image;

    private int xPixel; // on the map
    private int yPixel; // on the map
    private int viewWidth;
    private int viewHeight;

    public ProjectileView(Projectile projectile, Image image){
        this.projectile = projectile;
        this.image = image;
        projectile.addObserver(this);
        viewHeight = Settings.PROJECTILEHEIGHT;
        viewWidth = Settings.PROJECTILEWIDTH;
    }

    @Override
    public void update() {
        setPixels(projectile.getX(), projectile.getY());
    }

    @Override
    public void remove() {

    }

    @Override
    public void paintComponent(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.drawImage(image,xPixel*Settings.SCALEFACTOR,yPixel*Settings.SCALEFACTOR,viewWidth*Settings.SCALEFACTOR,viewHeight* Settings.SCALEFACTOR,null);
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