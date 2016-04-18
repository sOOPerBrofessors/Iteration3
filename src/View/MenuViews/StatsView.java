package View.MenuViews;

import Model.Entity.Character.Avatar;
import Model.State.GameState.GameState;
import Utilities.Observers.Observer;

import java.awt.*;

/**
 * Created by sgl on 4/15/16.
 */
public class StatsView extends ViewPanel implements Observer {

    private final Avatar avatar;
    private final String[] statsArray={"Level", "Experience", "Exp. to Level", "Lives Left", "Health", "Mana", "Movement", "Agility",
            "Hardiness", "Intellect", "Strength", "Offensive Rating", "Defensive Rating", "Armor Rating"};
    private int[] statsValArray={};

    public StatsView(GameState gameState){
        this.avatar = gameState.getAvatar();
        avatar.addObserver(this);
        update();
    }


    @Override
    public void update() {
        statsValArray = new int[]{
                avatar.getLevel(),
                avatar.getExperience(),
                avatar.getExperienceThreshold(),
                avatar.getLives(),
                avatar.getHealth(),
                avatar.getMana(),
                avatar.getMovement(),
                avatar.getAgility(),
                avatar.getHardiness(),
                avatar.getIntellect(),
                avatar.getStrength(),
                avatar.getOffensiveRating(),
                avatar.getDefensiveRating(),
                avatar.getArmorRating()
    };
    }

    @Override
    public void remove() {}

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g.create();
        drawBackground(g2d); //Draws background box

        g2d.setColor(new Color(166, 0, 4, 255));
        g2d.setFont(new Font(Font.MONOSPACED, 1, 48));
        g2d.drawString("Stats", xBorderOffset*3+50, yBorderOffset+70);

        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font(Font.MONOSPACED, 1, 22));

        for(int i = 0; i < statsArray.length; i++ ){
            g2d.drawString(statsArray[i], xBorderOffset+50, yBorderOffset*7/4+30*i);
            g2d.drawString(Integer.toString(statsValArray[i]),xBorderOffset*13/2, yBorderOffset*7/4+30*i);
        }
        g2d.dispose();
    }
}
