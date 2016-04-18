package View.MenuViews;

import Model.Entity.Character.Avatar;
import Model.Skills.Skill;
import Utilities.Settings;
import View.ViewUtilities.Sprites.ImageAssets;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by sgl on 4/16/16.
 */
public class SkillsView extends VertPanel{
    private final ArrayList<Skill> skills;
    private final boolean selected;
    private final Avatar avatar;

    public SkillsView(Avatar avatar) {
        ySel = 0;

        this.avatar = avatar;
        selected = false;
        skills = avatar.getSKillList();
        yMax = skills.size() - 1;
    }

    @Override
    public void selectUp() {
        if (ySel>0)ySel--;
    }

    @Override
    public void selectDown() {
        if (ySel < yMax) ySel++;
    }

    public void select(){
        skills.get(ySel).levelUp();
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g.create();
        drawBackground(g2d);

        g2d.setColor(new Color(166, 0, 4, 255));
        g2d.setFont(new Font(Font.MONOSPACED, 1, 48));
        g2d.drawString("Skills", xBorderOffset*3+35, yBorderOffset+70);

        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font(Font.MONOSPACED, 1, 22));

        for(int i = 0; i < skills.size(); i++ ){
            g2d.drawString(skills.get(i).getName(), xBorderOffset+300, yBorderOffset*7/4+20*i);
        }

        for(int i = 0; i < skills.size(); i++ ){
            g2d.drawString(" " + skills.get(i).getLevel(), xBorderOffset+500, yBorderOffset*7/4+20*i);
        }

        g2d.drawString("Skill points: " + avatar.getSkillPoint(), xBorderOffset+300, yBorderOffset*7/4+20*10);

        g2d.drawImage(ImageAssets.select,(xBorderOffset+270)* Settings.SCALEFACTOR,(yBorderOffset+85+20*ySel)* Settings.SCALEFACTOR,325*Settings.SCALEFACTOR,25*Settings.SCALEFACTOR,null );

        g2d.setColor(new Color(166, 0, 4, 255));
        g2d.setFont(new Font(Font.MONOSPACED, 1, 120));

        if (selected) g2d.setColor(Color.WHITE);
        g2d.dispose();
    }
}
