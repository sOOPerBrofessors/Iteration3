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

    private int xPixel; // on the map
    private int yPixel; // on the map
    private int pixelXGoal;
    private int pixelYGoal;
    private int viewWidth;
    private int viewHeight;
    private int imageIndex;
    private boolean metXGoal;
    private boolean metYGoal;

    public ProjectileView(Projectile projectile, ArrayList<BufferedImage> images){
        this.projectile = projectile;
        projectile.addObserver(this);
        this.images = images;
        viewHeight = Settings.PROJECTILEHEIGHT;
        viewWidth = Settings.PROJECTILEWIDTH;
        imageIndex = 0;
        metXGoal = false;
        metYGoal = false;
    }

    @Override
    public void update() {
    }

    @Override
    public void remove() {

    }

    public void paintComponent(Graphics2D g2d, int centerX, int centerY) {
        adjustMovement();

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
        xPixel = ViewCalculations.startXPixel(projectile.getOrientation(), x + 10);
        yPixel = ViewCalculations.startYPixel(projectile.getOrientation(), y - 12);
        pixelXGoal = ViewCalculations.goalXPixel(projectile.getOrientation(), xPixel);
        pixelYGoal = ViewCalculations.goalYPixel(projectile.getOrientation(), yPixel);
    }

    @Override
    protected void adjustHeight() {

    }

    private void adjustMovement(){
        xPixel = ViewCalculations.moveXPixel(projectile.getOrientation(), xPixel);
        yPixel = ViewCalculations.moveYpixel(projectile.getOrientation(), yPixel);
        incrementImageIndex();
        if(Math.abs(xPixel - pixelXGoal) <= 1){
            metXGoal = true;
        }
        if(Math.abs(yPixel - pixelYGoal) <= 1){
            metYGoal = true;
        }
        if(metXGoal && metYGoal){
            projectile.ViewDone(true);
        }
    }

    private void incrementImageIndex(){
        if(imageIndex == 3){
            imageIndex = 0;
        }
        else{
            imageIndex++;
        }
    }
}