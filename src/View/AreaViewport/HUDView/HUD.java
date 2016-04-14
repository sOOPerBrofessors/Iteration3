package View.AreaViewport.HUDView;

import Model.Entity.Character.Avatar;
import Utilities.Settings;

import java.awt.*;

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
        int x = width/2 - width/100;
        int y = height/2 - height/16 + height/56 - 8*avatar.getZ();
        double health = avatar.getHealth();
        double baseHealth = avatar.getBaseHealth();
        double mana = avatar.getMana();
        double baseMana = avatar.getBaseMana();


    } // end updateHUD
} // end class HUD
