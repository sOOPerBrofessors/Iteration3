package View.MenuViews;

import Controller.ControllerUtility.Command;
import Utilities.Settings;
import View.ViewUtilities.Sprites.ImageAssets;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;

/**
 * Created by sgl on 4/16/16.
 */
public class SettingsView extends VertPanel{


    private final String[] settingsArray = {"MOVE_N", "MOVE_NW", "MOVE_NE", "MOVE_S","MOVE_SW","MOVE_SE","ATTACK","INTERACT",
            "SKILL_1","SKILL_2","SKILL_3","SKILL_4","SKILL_5","SKILL_6","SKILL_7","INVENTORY","STATS", "SKILLS"};
    private final int[] settingsInt={Settings.UP, Settings.UP_LEFT, Settings.UP_RIGHT, Settings.DOWN, Settings.DOWN_LEFT, Settings.DOWN_RIGHT, Settings.ATTACK, Settings.INTERACT,
            Settings.SKILL_1, Settings.SKILL_2, Settings.SKILL_3, Settings.SKILL_4,Settings.SKILL_5,Settings.SKILL_6, Settings.SKILL_7,
            Settings.INVENTORY, Settings.STATS, Settings.SKILLS};
    private boolean selected;
    private int lastkey;
    private final HashMap<Integer, Command> commands;


    public SettingsView(){
        ySel = 0;
        yMax = 17;
        selected = false;
        commands = new HashMap<>();
        commands.put(0, () -> Settings.UP = lastkey);
        commands.put(1, () -> Settings.UP_LEFT = lastkey);
        commands.put(2, () -> Settings.UP_RIGHT = lastkey);
        commands.put(3, () -> Settings.DOWN = lastkey);
        commands.put(4, () -> Settings.DOWN_LEFT = lastkey);
        commands.put(5, () -> Settings.DOWN_RIGHT = lastkey);
        commands.put(6, () -> Settings.ATTACK = lastkey);
        commands.put(7, () -> Settings.INTERACT = lastkey);
        commands.put(8, () -> Settings.SKILL_1 = lastkey);
        commands.put(9, () -> Settings.SKILL_2 = lastkey);
        commands.put(10, () -> Settings.SKILL_3 = lastkey);
        commands.put(11, () -> Settings.SKILL_4 = lastkey);
        commands.put(12, () -> Settings.SKILL_5 = lastkey);
        commands.put(13, () -> Settings.SKILL_6 = lastkey);
        commands.put(14, () -> Settings.SKILL_7 = lastkey);
        commands.put(15, () -> Settings.INVENTORY = lastkey);
        commands.put(16, () -> Settings.STATS = lastkey);
        commands.put(17, () -> Settings.SKILLS = lastkey);
    }

    @Override
    public void selectUp() {
        if (ySel>0)ySel--;
    }

    @Override
    public void selectDown() {
        if (ySel < yMax) ySel++;
    }

    public void select(int lastKey){
        this.lastkey = lastKey;
        selected=!selected;
        if (!selected)commands.get(ySel).execute();
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
        g2d.drawString(String.valueOf((char)lastkey), xBorderOffset*4, yBorderOffset*4);
        if(settingsInt[ySel]== KeyEvent.VK_SPACE) g2d.drawString("Space", xBorderOffset*4, yBorderOffset*3);

        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font(Font.MONOSPACED, 1, 20));
        g2d.drawString("Press Enter", xBorderOffset*3+100, yBorderOffset*4);
        g2d.drawString("Press New Key", xBorderOffset*3+100, yBorderOffset*4+20);
        g2d.drawString("Press Enter", xBorderOffset*3+100, yBorderOffset*4+40);



        g2d.dispose();
    }
}
