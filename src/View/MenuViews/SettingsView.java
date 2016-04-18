package View.MenuViews;

import Model.Entity.Character.Character;
import Utilities.Observers.Observer;
import Utilities.Settings;
import View.ViewUtilities.Sprites.ImageAssets;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Set;

/**
 * Created by sgl on 4/16/16.
 */
public class SettingsView extends VertPanel{

    String[] settingsArray = {"MOVE_N", "MOVE_NW", "MOVE_NE", "MOVE_S","MOVE_SW","MOVE_SE","ATTACK","INTERACT",
            "SKILL_1","SKILL_2","SKILL_3","SKILL_4","SKILL_5","SKILL_6","SKILL_7","INVENTORY","STATS", "SKILLS"};
    int[] settingsInt={Settings.UP, Settings.UP_LEFT, Settings.UP_RIGHT, Settings.DOWN, Settings.DOWN_LEFT, Settings.DOWN_RIGHT, Settings.ATTACK, Settings.INTERACT,
            Settings.SKILL_1, Settings.SKILL_2, Settings.SKILL_3, Settings.SKILL_4,Settings.SKILL_5,Settings.SKILL_6, Settings.SKILL_7,
            Settings.INVENTORY, Settings.STATS, Settings.SKILLS};
    boolean selected = false;

    public SettingsView(){
        ySel = 0;
        yMax = 17;
    }

    @Override
    public void selectUp() {
        if (ySel>0)ySel--;
    }

    @Override
    public void selectDown() {
        if (ySel < yMax) ySel++;
    }

    @Override
    public void select(){
        selected=!selected;
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g.create();
        drawBackground(g2d);

        g2d.setColor(new Color(166, 0, 4, 255));
        g2d.setFont(new Font(Font.MONOSPACED, 1, 48));
        g2d.drawString("Settings", xBorderOffset*3+35, yBorderOffset+70);

        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font(Font.MONOSPACED, 1, 22));

        for(int i = 0; i <= yMax; i++ ){
            g2d.drawString(settingsArray[i], xBorderOffset+50, yBorderOffset*7/4+20*i);
        }
        g2d.drawImage(ImageAssets.select,(xBorderOffset+20)*Settings.SCALEFACTOR,(yBorderOffset+85+20*ySel)* Settings.SCALEFACTOR,325*Settings.SCALEFACTOR,25*Settings.SCALEFACTOR,null );

        g2d.setColor(new Color(166, 0, 4, 255));
        g2d.setFont(new Font(Font.MONOSPACED, 1, 120));

        if (selected) g2d.setColor(Color.WHITE);
        g2d.drawString(String.valueOf((char)settingsInt[ySel]), xBorderOffset*4, yBorderOffset*3);
        if(settingsInt[ySel]== KeyEvent.VK_SPACE) g2d.drawString("Space", xBorderOffset*4, yBorderOffset*3);
        g2d.dispose();
    }
}
