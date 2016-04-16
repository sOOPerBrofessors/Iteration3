package View.MapView.AOEView;

import Model.Map.AreaEffect.AreaOfEffect;
import Utilities.Visitor.AOEVisitor;
import View.MapView.MapObjectView;
import View.ViewUtilities.Sprites.ImageAssets;

import java.awt.*;

/**
 * Created by dyeung on 4/16/16.
 */
public class AreaOfEffectView extends MapObjectView implements AOEVisitor{
    private Image image;
    private int xPixels;
    private int yPixels;
    private final int viewWidth = 0;
    private final int viewHeight = 30;
    private AreaOfEffect areaOfEffect;
    public AreaOfEffectView(AreaOfEffect areaOfEffect){
        this.areaOfEffect = areaOfEffect;
        areaOfEffect.acceptAOEVisitor(this);

    }

    @Override
    public void paintComponent(Graphics2D g2d) {
        //for now paint a graphics 2d
        g2d.setColor(Color.yellow);
        g2d.fillOval(xPixels,yPixels,50,50);
    }

    @Override
    public void setPixels(int x, int y) {
        this.xPixels = x;
        this.yPixels = y;
        adjustHeight();
    }

    @Override
    protected void adjustHeight() {
        yPixels = yPixels - viewHeight;
    }

    @Override
    public void visitHealAOE() {
        //needs to change heal effect image
        image = null;//new AreaOfEffectView();
    }

    @Override
    public void visitTakeDamageAoe() {
        image = null;
    }

    @Override
    public void visitTeleportAoe() {
        image = null;
    }

    @Override
    public void visitLevelUpAoe() {
        image = null;
    }

    @Override
    public void visitInstantDeath() {
        image = null;
    }
}
