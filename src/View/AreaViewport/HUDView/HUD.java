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
        double healthRatio = avatar.getHealth()*1.0 / avatar.getBaseHealth()*1.0;
        if(healthRatio > 1)
            healthRatio = 1;
        double manaRatio = avatar.getMana()*1.0 / avatar.getBaseMana()*1.0;
        if(manaRatio > 1)
            manaRatio = 1;
        int xp = avatar.getExperience(),
                xpThreshold = avatar.getExperienceThreshold();
        double experienceRatio = xp*1.0 / xpThreshold*1.0;
        if(experienceRatio > 1)
            experienceRatio = 1;
        FontMetrics fm = g.getFontMetrics();

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // draw health bar
        g2d.setColor(new Color(255, 2, 3, 120));
        g2d.fillRect(174,17,(int)(303 * healthRatio),24);

        // draw mana bar
        g2d.setColor(new Color(13, 17, 255, 120));
        g2d.fillRect(195,58,(int)(312 * manaRatio),24);

        // draw experience bar
        g2d.setColor(new Color(255, 197, 0, 120));
        g2d.fillRect(195,99,(int)(310 * experienceRatio),24);

        // draw experience text
        g2d.setColor(new Color(247, 255, 204));
        String xpMessage = xp + " / " + xpThreshold;
        int messageWidth = fm.stringWidth(xpMessage);
        g2d.drawString(xpMessage, (168+(337/2) - messageWidth/2), 116);

        g2d.setColor(new Color(5, 255, 78, 200));
        g2d.fillOval(2,2,163,163);
        g2d.drawImage(ImageAssets.hud, 0, 0, 520, 180, null);
        g2d.drawImage(ImageAssets.sneakS, 55, 55, 64, 64, null);

        g2d.dispose();
    } // end updateHUD
} // end class HUD
