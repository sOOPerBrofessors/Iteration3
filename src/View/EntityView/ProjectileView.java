package View.EntityView;

import Model.Entity.Projectile.Projectile;
import Utilities.Observers.Observer;
import View.MapView.MapObjectView;

import java.awt.*;

/**
 * Created by dyeung on 4/16/16.
 */
public class ProjectileView extends MapObjectView implements Observer{

    private Projectile projectile;
    private int xPixel; // on the map
    private int yPixel; // on the map

    public ProjectileView(Projectile projectile){
        this.projectile = projectile;
    }

    @Override
    public void update() {
        setPixels(projectile.getX(), projectile.getY());
    }

    @Override
    public void remove() {

    }


    @Override
    public void paintComponent(Graphics2D g) {

    }

    @Override
    public void setPixels(int x, int y) {

    }

    @Override
    protected void adjustHeight() {

    }
}
