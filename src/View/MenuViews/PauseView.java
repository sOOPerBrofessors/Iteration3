package View.MenuViews;

import Controller.ControllerUtility.Command;
import Utilities.Settings;
import View.ViewManager;
import View.ViewUtilities.Sprites.ImageAssets;

import java.awt.*;
import java.util.HashMap;

/**
 * Created by sgl on 4/16/16.
 */
public class PauseView extends VertPanel {

    private int sel = 0;
    private final int selMax = 3;
    private final String[] menuArray = {"SAVE","SETTINGS","MAIN_MENU","QUIT"};
    private HashMap<Integer, Command> commands;
    private ViewManager viewManager;

    public PauseView(ViewManager viewManager){
        this.viewManager = viewManager;
        commands = new HashMap<>();
        commands.put(0, () -> doNothing());
        commands.put(1, () -> goToSettings());
        commands.put(2, () -> restart());
        commands.put(3, () -> System.exit(0));
    }

    @Override
    public void selectUp() {
        if(sel>0) sel--;
    }

    @Override
    public void selectDown() {
        if (sel<selMax) sel++;
    }

    public void select(){
        commands.get(sel).execute();
    }

    private void restart(){
        viewManager.stopThread();
        viewManager.displayIntro();
    }

    private void goToSettings(){
        viewManager.closePauseScreen();
        viewManager.displaySettings();
    }
    private void doNothing(){    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g.create();
        drawBackground(g2d);

        g2d.setColor(new Color(166, 0, 4, 255));
        g2d.setFont(new Font("Courier New", 1, 48));
        g2d.drawString("Pause_Menu", xBorderOffset*11/4, yBorderOffset+50);

        g2d.setColor(new Color(23, 39, 166, 255));
        g2d.setFont(new Font("Courier New", 1, 40));
        for (int i =0; i <= selMax; i++){
            g2d.drawString(menuArray[i], xBorderOffset*11/4, yBorderOffset*(3+i));
        }
        g2d.drawImage(ImageAssets.select,xBorderOffset*11/4-25*Settings.SCALEFACTOR,yBorderOffset*(2+sel)+50* Settings.SCALEFACTOR,325*Settings.SCALEFACTOR,50*Settings.SCALEFACTOR,null );
        g2d.dispose();
    }
}
