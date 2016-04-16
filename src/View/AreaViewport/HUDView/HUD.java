package View.AreaViewport.HUDView;

import Model.Entity.Character.Avatar;
import Utilities.GameMessageQueue;
import Utilities.Settings;

import java.awt.*;
import java.awt.image.BufferedImage;

import View.ViewUtilities.Sprites.ImageAssets;

/**
 * Created by broskj on 4/14/16.
 *
 * Designed to be an overlay on the main interface.  Contains a status orb that reflects combat status and health
 *  ratio; health, mana, and experience bars; and a game message box.
 *
 *
 */
public class HUD {
    private Avatar avatar;
    private static BufferedImage occupationSprite;
    private static Color statusColor = new Color(5, 255, 78, 120);
    private int width = Settings.GAMEWIDTH,
        height = Settings.GAMEHEIGHT;

    public HUD(Avatar avatar) {
        this.avatar = avatar;
    } // end constructor

    public static void setOccupationSprite(BufferedImage newOccupationSprite) {
        occupationSprite = newOccupationSprite;
    } // end setOccupationSprite

    public static void setStatusCombat() {
        statusColor = new Color(255, 2, 30, 120);
    } // end setStatusCombat

    public static void setStatusRegular() {
        statusColor = new Color(5, 255, 78, 120);
    } // end setStatusCombat

    public void updateHUD(Graphics g) {
        int health = avatar.getHealth(),
                baseHealth = avatar.getBaseHealth();
        int mana = avatar.getMana(),
                baseMana = avatar.getBaseMana();
        double healthRatio = health*1.0 / baseHealth*1.0;
        if(healthRatio > 1)
            healthRatio = 1;
        double manaRatio = mana*1.0 / baseMana*1.0;
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

        // draw text onto bars
        g2d.setColor(new Color(247, 255, 204));
        g2d.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

        // draw health text
        String hpMessage = health + " / " + baseHealth;
        g2d.drawString(hpMessage, (174 + (303/2) - fm.stringWidth(hpMessage)/2), 34);

        // draw mana text
        String manaMessage = mana + " / " + baseMana;
        g2d.drawString(manaMessage, (195+(310/2) - fm.stringWidth(manaMessage)/2), 75);

        // draw experience text
        String xpMessage = xp + " / " + xpThreshold;
        g2d.drawString(currentLevel, 195+fm.stringWidth(currentLevel)/2, 116);
        g2d.drawString(xpMessage, (195+(310/2) - fm.stringWidth(xpMessage)/2), 116);
        g2d.drawString(nextLevel, 505-fm.stringWidth(nextLevel)/2-25, 116);

        if(healthRatio <= 0.4)
            pulseOrb(g2d, healthRatio);
        else if(!avatar.isInCombat())
            statusColor = new Color(5, 255, 78, 120);
        g2d.setColor(statusColor);

        g2d.fillOval(2,4,163,165);
        g2d.drawImage(ImageAssets.hud, 0, 0, 520, 180, null);
        g2d.drawImage(occupationSprite, 55, 45, 64, 84, null);

        renderGameMessages(g2d);

        g2d.dispose();
    } // end updateHUD

    public void renderGameMessages(Graphics2D g2d) {
        int messageBoxW = 480, messageBoxH = 130;
        g2d.setColor(new Color(255,255,255,50));
        g2d.fillRect(width-messageBoxW, 0, messageBoxW, messageBoxH);
        g2d.drawImage(ImageAssets.messageBox, width-messageBoxW, 0, messageBoxW, messageBoxH, null);

        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

        for(int i = 0; i < GameMessageQueue.queue.size(); i++) {
            g2d.drawString(GameMessageQueue.queue.get(i), width-messageBoxW+20, (22*(GameMessageQueue.queue.size()-i))+5);
        }
    } // end renderGameMessages

    public void pulseOrb(Graphics2D g2d, double ratio) {
        //int a = statusColor.getAlpha();
        if (ratio == 0) {
            statusColor = new Color(255,2,30,120);
            g2d.setColor(statusColor);
        } else {
            double modifier = Math.cos(Math.PI * System.currentTimeMillis() / (ratio * 1440));
            int a = Math.abs((int) (120 * Math.pow(modifier,2)));

            statusColor = new Color(255, 2, 30, a);
            g2d.setColor(statusColor);
        }
    }
} // end class HUD
