package View.SkillView;

import Model.Entity.Character.Character;
import Model.Map.Location;
import Model.Skills.RangedSkills.ObservationInfo;
import View.ViewUtilities.Sprites.ImageAssets;

import java.awt.*;
import java.util.ArrayList;


/**
 * Created by AndyZhu on 16/4/2016.
 *
 */
public class ObservedNPC {
    private Character enemy;
    private static ArrayList<String> msg = new ArrayList<>();
    public ObservedNPC () {
    }


    public void updateObservation(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int newline = g.getFont().getSize() + 5 ;
        int y = 400;
        for (String aMsg : msg) {
            g.setColor((new Color(255, 255, 255)));
            g.drawString(aMsg, 50, y += newline);
        }

        g2d.dispose();
    }

    public static void setObservationMsg(ObservationInfo observationInfo) {
        //an enemy is spotted
        if (observationInfo.getLocation() != null) {
            Location location = observationInfo.getLocation();
            ArrayList<String> observedMsg = observationInfo.getObservedMsg();
            msg.add("Location: (" + location.getX() + ", " + location.getY() +")");
            msg.addAll(observedMsg);
        }
        //no enemy
        else {
            msg = observationInfo.getObservedMsg();
        }
    }

    public static void resetObservationMsg() {
        msg.clear();
    }
}
