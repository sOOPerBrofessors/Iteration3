package View.AreaViewport.HUDView;

import Model.Entity.Character.Avatar;
import Utilities.GameMessageQueue;
import Utilities.Settings;
import View.ViewUtilities.ImageAssets;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by broskj on 4/14/16.
 */
public class HUD {
    private Avatar avatar;
    private static BufferedImage occupationSprite;
    private int width = Settings.GAMEWIDTH,
        height = Settings.GAMEHEIGHT;

    public HUD(Avatar avatar) {
        this.avatar = avatar;
    } // end constructor

    public static void setOccupationSprite(BufferedImage newOccupationSprite) {
        occupationSprite = newOccupationSprite;
    } // end setOccupationSprite

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
        int level = avatar.getLevel();
        String currentLevel = "Lvl " + level,
                nextLevel = "Lvl " + (level+1);

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
        g2d.drawString(currentLevel, 195+fm.stringWidth(currentLevel)/2, 116);
        g2d.drawString(xpMessage, (168+(310/2) - fm.stringWidth(xpMessage)/2), 116);
        g2d.drawString(nextLevel, 505-fm.stringWidth(nextLevel)/2-25, 116);

        g2d.setColor(new Color(5, 255, 78, 200));
        g2d.fillOval(2,2,163,163);
        g2d.drawImage(ImageAssets.hud, 0, 0, 520, 180, null);
        g2d.drawImage(occupationSprite, 55, 55, 64, 64, null);

        renderGameMessages(g2d);

        g2d.dispose();
    } // end updateHUD

    public void renderGameMessages(Graphics2D g2d) {
        int messageBoxW = 600, messageBoxH = 140;
        g2d.drawImage(ImageAssets.messageBox, 0, height-messageBoxH, messageBoxW, messageBoxH, null);

        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.PLAIN, 22));

        for(int i = 0; i < GameMessageQueue.queue.size(); i++) {
            g2d.drawString(GameMessageQueue.queue.get(i), 20, (height-20*(GameMessageQueue.queue.size()-i))-10);
        }
    } // end renderGameMessages
} // end class HUD
