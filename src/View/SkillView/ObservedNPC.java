package View.SkillView;

import Model.Entity.Character.Character;
import View.ViewUtilities.Sprites.ImageAssets;

import java.awt.*;

/**
 * Created by AndyZhu on 16/4/2016.
 */
public class ObservedNPC {
    private Character enemy;

    public ObservedNPC (Character enemy) {
        this.enemy = enemy;
    }

    public void updateObservation(Graphics g) {
        FontMetrics fm = g.getFontMetrics();
        int level = enemy.getLevel();
        String currentLevel = "Lvl " + level;

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // draw experience text
        g2d.setColor(new Color(247, 255, 204));
        String levelMessage = currentLevel;
        g2d.drawString(currentLevel, 500 + fm.stringWidth(levelMessage) / 2, 400);

        g2d.dispose();
    }
}
