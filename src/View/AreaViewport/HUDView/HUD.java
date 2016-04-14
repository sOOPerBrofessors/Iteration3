package View.AreaViewport.HUDView;

import Model.Entity.Character.Avatar;
import Utilities.Settings;
import View.ViewUtilities.ImageAssets;
import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

/**
 * Created by broskj on 4/14/16.
 */
public class HUD {
    private Avatar avatar;
    private int width = Settings.GAMEWIDTH;
    private int height = Settings.GAMEHEIGHT;

    public HUD(Avatar avatar) {
        this.avatar = avatar;
    } // end constructor

    public void updateHUD(Graphics g) {
        double health = avatar.getHealth();
        double baseHealth = avatar.getBaseHealth();
        double mana = avatar.getMana();
        double baseMana = avatar.getBaseMana();

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        //TODO: draw circle
        g2d.setColor(Color.BLACK);
        g2d.drawOval(0,0,128,128);
        g2d.setColor(new Color(41, 255, 0,80));
        g2d.fillOval(0,0,128,128);
        g2d.drawImage(ImageAssets.smasherS, 32,32, 64, 64, null);
    } // end updateHUD
} // end class HUD
