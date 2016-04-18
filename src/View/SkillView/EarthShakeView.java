package View.SkillView;

import Model.Entity.Character.Character;
import Model.Map.Location;
import Model.Skills.RangedSkills.ObservationInfo;
import View.ViewUtilities.Sprites.ImageAssets;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by AndyZhu on 18/4/2016.
 */
public class EarthShakeView {
    private static boolean earthShakeViewOn = false;
    private static ArrayList<Location> locationArrayList;
    private static int radius;
    public EarthShakeView () {
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

        if (earthShakeViewOn) {
            g2d.drawImage(ImageAssets.crackedEarth, yourPositionX, yourPositionY - intervalY, 92, 71, null);
            g2d.drawImage(ImageAssets.crackedEarth, yourPositionX + intervalX, yourPositionY - intervalY / 2, 92, 71, null);
            g2d.drawImage(ImageAssets.crackedEarth, yourPositionX + intervalX, yourPositionY + intervalY / 2, 92, 71, null);
            g2d.drawImage(ImageAssets.crackedEarth, yourPositionX, yourPositionY + intervalY, 92, 71, null);
            g2d.drawImage(ImageAssets.crackedEarth, yourPositionX - intervalX, yourPositionY + intervalY / 2, 92, 71, null);
            g2d.drawImage(ImageAssets.crackedEarth, yourPositionX - intervalX, yourPositionY - intervalY /2, 92, 71, null);
        }
        g.setColor((new Color(255, 255, 255)));

        g2d.dispose();
    }

    public static void setEarthShakeViewOn(boolean bool) {
        earthShakeViewOn = bool;
    }

    public static void setLocationArrayList(ArrayList<Location> arrayList) {
        locationArrayList = arrayList;
    }

    public static void setRadius(int newRadius) {
        radius = newRadius;
    }
}
