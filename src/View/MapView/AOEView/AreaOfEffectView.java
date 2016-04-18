package View.MapView.AOEView;

import Model.Map.AreaEffect.AreaOfEffect;
import Utilities.Settings;
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
    private final int viewWidth = 30;
    private final int viewHeight = 30;
    private AreaOfEffect areaOfEffect;
    public AreaOfEffectView(AreaOfEffect areaOfEffect){
        this.areaOfEffect = areaOfEffect;
        areaOfEffect.acceptAOEVisitor(this);
    }

    @Override
    public void paintComponent(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        //for now paint a graphics 2d
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, areaOfEffect.getAlpha()));
        g2d.drawImage(image,xPixels*Settings.SCALEFACTOR,yPixels*Settings.SCALEFACTOR,viewWidth*Settings.SCALEFACTOR,viewHeight* Settings.SCALEFACTOR,null);

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
        image = ImageAssets.redCrossAOE;;//new AreaOfEffectView();
    }

    @Override
    public void visitTakeDamageAoe() {
        image = ImageAssets.instantDeathAOE;
    }

    @Override
    public void visitTeleportAoe() {
        image = ImageAssets.teleportAOE;
    }

    @Override
    public void visitLevelUpAoe() {
        image = ImageAssets.goldStarAOE;
    }

    @Override
    public void visitInstantDeath() {
        image = ImageAssets.instantDeathAOE;
    }

    @Override
    public void visitTrap() { image = ImageAssets.trapAOE; }
}
