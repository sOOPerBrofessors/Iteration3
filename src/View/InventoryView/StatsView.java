package View.InventoryView;

import Model.Entity.Character.Avatar;
import Model.State.GameState.GameState;
import Utilities.ErrorLevel;
import Utilities.MessageHandler;
import Utilities.Observers.Observer;
import Utilities.PersonFilter;
import Utilities.Settings;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sgl on 4/15/16.
 */
public class StatsView extends ViewPanel implements Observer {

    Avatar avatar;
    String statsArray[]={"Agility", "Experience", "Hardiness", "Intellect", "Lives", "Strength", "Health", "Level", "Mana", "Offensive_Rating",
            "Defensive_Rating", "Armor_Rating", "Equipped_Weapon_Rating", "Equipped_Armor_Rating","Experience_Threshold" };
    int statsValArray[]= new int[15];

    public StatsView(GameState gameState){
        this.avatar = gameState.getAvatar();
        avatar.addObserver(this);
        update();
    }


    @Override
    public void update() {
        statsValArray[0]=avatar.getAgility();
        statsValArray[1]=avatar.getExperience();
        statsValArray[2]=avatar.getHardiness();
        statsValArray[3]=avatar.getIntellect();
        statsValArray[4]=avatar.getLives();
        statsValArray[5]=avatar.getStrength();
        statsValArray[6]=avatar.getHealth();
        statsValArray[7]=avatar.getLevel();
        statsValArray[8]=avatar.getMana();
        statsValArray[9]=avatar.getOffensiveRating();
        statsValArray[10]=avatar.getDefensiveRating();
        statsValArray[11]=avatar.getArmorRating();
        statsValArray[12]=avatar.getEquippedWeapon();
        statsValArray[13]=avatar.getEquippedArmor();
        statsValArray[14]=avatar.getExperienceThreshold();
    }

    @Override
    public void remove() {}

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g.create();
        drawBackground(g2d); //Draws background box

        g2d.setColor(new Color(166, 0, 4, 255));
        g2d.setFont(new Font("Courier New", 1, 48));
        g2d.drawString("Stats", xBorderOffset*3+50, yBorderOffset+50);

        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Courier New", 1, 22));

        for(int i = 0; i < statsArray.length; i++ ){
            g2d.drawString(statsArray[i], xBorderOffset+50, yBorderOffset*7/4+30*i);
            g2d.drawString(Integer.toString(statsValArray[i]),xBorderOffset*13/2, yBorderOffset*7/4+30*i);
        }
        g2d.dispose();
    }
}
