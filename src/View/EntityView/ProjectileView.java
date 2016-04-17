package View.EntityView;

import Model.Entity.Projectile.Projectile;
import Utilities.MovementCalculations.ViewCalculations;
import Utilities.Observers.Observer;
import Utilities.Settings;
import View.MapView.MapObjectView;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by dyeung on 4/16/16.
 */
public class ProjectileView extends MapObjectView implements Observer{

    private Projectile projectile;
    private ArrayList<BufferedImage> images;

    private int xPixelStart;
    private int yPixelStart;
    private double adjustedXPixel; // used to move across screen
    private double adjustedYPixel; // used to move across screen
    private int xPixel; // on the map
    private int yPixel; // on the map
    private int viewWidth;
    private int viewHeight;
    private int imageIndex;

    public ProjectileView(Projectile projectile, ArrayList<BufferedImage> images){
        this.projectile = projectile;
        projectile.addObserver(this);
        this.images = images;
        viewHeight = Settings.PROJECTILEHEIGHT;
        viewWidth = Settings.PROJECTILEWIDTH;
        imageIndex = 0;
        adjustedXPixel = 0;
        adjustedYPixel = 0;
    }

    @Override
    public void update() {
        setPixels(projectile.getX(), projectile.getY());
    }

    @Override
    public void remove() {

    }

    public void paintComponent(Graphics2D g2d, int centerX, int centerY) {
        adjustMovement(centerX, centerY);

        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.drawImage(images.get(imageIndex),xPixel*Settings.SCALEFACTOR,yPixel*Settings.SCALEFACTOR,viewWidth*Settings.SCALEFACTOR,viewHeight* Settings.SCALEFACTOR,null);
    }

    @Override
    public void paintComponent(Graphics2D g) {

    }

    @Override
    public void setPixels(int x, int y) {
        xPixelStart = ViewCalculations.getXPixel(projectile.getOrientation(), projectile.getX());
        yPixelStart = ViewCalculations.getYPixel(projectile.getOrientation(), projectile.getY());
    }

    @Override
    protected void adjustHeight() {

    }

    private void adjustMovement(int centerX, int centerY){
        xPixel = xPixelStart + (int)(centerX*adjustedXPixel);
        yPixel = yPixelStart + (int)(centerY*adjustedYPixel);
    }
}