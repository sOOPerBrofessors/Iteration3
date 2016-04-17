package View.InventoryView;

import Utilities.Settings;
import View.ViewUtilities.Sprites.ImageAssets;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sgl on 4/16/16.
 */
public abstract class ViewPanel extends JPanel{
    protected int xBorderOffset = Settings.GAMEWIDTH/8;
    protected int yBorderOffset = Settings.GAMEHEIGHT/8;
    protected int xSize = Settings.GAMEWIDTH*3/4;
    protected int ySize = Settings.GAMEHEIGHT*3/4;

    public abstract void paintComponent(Graphics g);

    protected void drawBackground(Graphics2D g2d){
        float opacity = 0.95f; //make pictures opaque
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1)); //make pictures opaque
        g2d.setColor(new Color(123, 123, 123, 120));
        g2d.fillRect(xBorderOffset,yBorderOffset,xSize, ySize);
        g2d.drawImage(ImageAssets.interfaceBorder, 0, 0, Settings.GAMEWIDTH, Settings.GAMEHEIGHT, null);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f)); //make pictures opaque
    }


}
