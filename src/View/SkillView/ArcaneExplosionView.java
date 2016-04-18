package View.SkillView;

import Model.Map.Location;
import View.ViewUtilities.Sprites.ImageAssets;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by AndyZhu on 18/4/2016.
 */
public class ArcaneExplosionView {
    private static boolean arcaneViewFirstOn = false;
    private static boolean arcaneViewSecondOn = false;
    public ArcaneExplosionView () {
    }

    public void updateObservation(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int yourPositionY = 383;
        int intervalY = 57;
        int yourPositionX = 520;
        int intervalX = 72;

        if (arcaneViewFirstOn) {
            g2d.drawImage(ImageAssets.arcaneExplosion, yourPositionX, yourPositionY - intervalY, 92, 71, null);
            g2d.drawImage(ImageAssets.arcaneExplosion, yourPositionX + intervalX, yourPositionY - intervalY / 2, 92, 71, null);
            g2d.drawImage(ImageAssets.arcaneExplosion, yourPositionX + intervalX, yourPositionY + intervalY / 2, 92, 71, null);
            g2d.drawImage(ImageAssets.arcaneExplosion, yourPositionX, yourPositionY + intervalY, 92, 71, null);
            g2d.drawImage(ImageAssets.arcaneExplosion, yourPositionX - intervalX, yourPositionY + intervalY / 2, 92, 71, null);
            g2d.drawImage(ImageAssets.arcaneExplosion, yourPositionX - intervalX, yourPositionY - intervalY /2, 92, 71, null);
        } else if (arcaneViewSecondOn) {
            g2d.drawImage(ImageAssets.arcaneExplosion, yourPositionX, yourPositionY - intervalY * 2, 92, 71, null);
            g2d.drawImage(ImageAssets.arcaneExplosion, yourPositionX + intervalX, yourPositionY - intervalY * 3/2, 92, 71, null);
            g2d.drawImage(ImageAssets.arcaneExplosion, yourPositionX + intervalX * 2, yourPositionY - intervalY, 92, 71, null);
            g2d.drawImage(ImageAssets.arcaneExplosion, yourPositionX + intervalX * 2, yourPositionY, 92, 71, null);
            g2d.drawImage(ImageAssets.arcaneExplosion, yourPositionX + intervalX * 2, yourPositionY + intervalY, 92, 71, null);
            g2d.drawImage(ImageAssets.arcaneExplosion, yourPositionX + intervalX, yourPositionY + intervalY * 3/2, 92, 71, null);
            g2d.drawImage(ImageAssets.arcaneExplosion, yourPositionX, yourPositionY + intervalY * 2, 92, 71, null);
            g2d.drawImage(ImageAssets.arcaneExplosion, yourPositionX - intervalX, yourPositionY - intervalY * 3/2, 92, 71, null);
            g2d.drawImage(ImageAssets.arcaneExplosion, yourPositionX - intervalX * 2, yourPositionY - intervalY, 92, 71, null);
            g2d.drawImage(ImageAssets.arcaneExplosion, yourPositionX - intervalX * 2, yourPositionY, 92, 71, null);
            g2d.drawImage(ImageAssets.arcaneExplosion, yourPositionX - intervalX * 2, yourPositionY + intervalY, 92, 71, null);
            g2d.drawImage(ImageAssets.arcaneExplosion, yourPositionX - intervalX, yourPositionY + intervalY * 3/2, 92, 71, null);
        }
        g2d.dispose();
    }

    public static void setArcaneViewFirstOn(boolean bool) {
        arcaneViewFirstOn = bool;
    }

    public static void setArcaneViewSecondOn(boolean bool) {
        arcaneViewSecondOn = bool;
    }

}
